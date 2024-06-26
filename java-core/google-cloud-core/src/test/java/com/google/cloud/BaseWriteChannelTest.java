/*
 * Copyright 2015 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.cloud.spi.ServiceRpcFactory;
import java.io.IOException;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.util.Arrays;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BaseWriteChannelTest {

  private abstract static class CustomService implements Service<CustomServiceOptions> {}

  private abstract static class CustomServiceOptions
      extends ServiceOptions<CustomService, CustomServiceOptions> {

    private static final long serialVersionUID = 3302358029307467197L;

    protected CustomServiceOptions(
        Class<? extends ServiceFactory<CustomService, CustomServiceOptions>> serviceFactoryClass,
        Class<? extends ServiceRpcFactory<CustomServiceOptions>> rpcFactoryClass,
        Builder<CustomService, CustomServiceOptions, ?> builder) {
      super(serviceFactoryClass, rpcFactoryClass, builder, null);
    }
  }

  private static final Serializable ENTITY = 42L;
  private static final String UPLOAD_ID = "uploadId";
  private static final byte[] CONTENT = {0xD, 0xE, 0xA, 0xD};
  private static final int MIN_CHUNK_SIZE = 256 * 1024; // 256 KiB
  private static final int DEFAULT_CHUNK_SIZE = 60 * MIN_CHUNK_SIZE; // 15MiB
  private static final Random RANDOM = new Random();
  private static BaseWriteChannel channel;

  @BeforeEach
  void setUp() {
    channel =
        new BaseWriteChannel<CustomServiceOptions, Serializable>(null, ENTITY, UPLOAD_ID) {
          @Override
          public RestorableState<WriteChannel> capture() {
            return null;
          }

          @Override
          protected void flushBuffer(int length, boolean last) {}

          @Override
          protected BaseState.Builder<CustomServiceOptions, Serializable> stateBuilder() {
            return null;
          }
        };
  }

  @Test
  void testConstructor() {
    assertNull(channel.getOptions());
    assertEquals(ENTITY, channel.getEntity());
    assertEquals(0, channel.getPosition());
    assertEquals(UPLOAD_ID, channel.getUploadId());
    assertEquals(0, channel.getLimit());
    assertTrue(channel.isOpen());
    assertArrayEquals(new byte[0], channel.getBuffer());
    assertEquals(DEFAULT_CHUNK_SIZE, channel.getChunkSize());
  }

  @Test
  void testClose() throws IOException {
    channel.close();
    assertFalse(channel.isOpen());
    assertNull(channel.getBuffer());
  }

  @Test
  public void testValidateOpen() throws IOException {
    channel.close();
    assertThrows(ClosedChannelException.class, () -> channel.write(ByteBuffer.allocate(42)));
  }

  @Test
  void testChunkSize() {
    channel.setChunkSize(42);
    assertThat(channel.getChunkSize() >= MIN_CHUNK_SIZE).isTrue();
    assertThat(channel.getChunkSize() % MIN_CHUNK_SIZE).isEqualTo(0);

    channel.setChunkSize(2 * MIN_CHUNK_SIZE);
    assertThat(channel.getChunkSize() >= MIN_CHUNK_SIZE).isTrue();
    assertThat(channel.getChunkSize() % MIN_CHUNK_SIZE).isEqualTo(0);

    channel.setChunkSize(2 * MIN_CHUNK_SIZE + 1);
    assertThat(channel.getChunkSize() >= MIN_CHUNK_SIZE).isTrue();
    assertThat(channel.getChunkSize() % MIN_CHUNK_SIZE).isEqualTo(0);
  }

  @Test
  void testWrite() throws IOException {
    channel.write(ByteBuffer.wrap(CONTENT));
    assertEquals(CONTENT.length, channel.getLimit());
    assertEquals(DEFAULT_CHUNK_SIZE, channel.getBuffer().length);
    assertArrayEquals(Arrays.copyOf(CONTENT, DEFAULT_CHUNK_SIZE), channel.getBuffer());
  }

  @Test
  void testWriteAndFlush() throws IOException {
    ByteBuffer content = randomBuffer(DEFAULT_CHUNK_SIZE + 1);
    channel.write(content);
    assertEquals(DEFAULT_CHUNK_SIZE, channel.getPosition());
    assertEquals(1, channel.getLimit());
    byte[] newContent = new byte[DEFAULT_CHUNK_SIZE];
    newContent[0] = content.get(DEFAULT_CHUNK_SIZE);
    assertArrayEquals(newContent, channel.getBuffer());
  }

  private static ByteBuffer randomBuffer(int size) {
    byte[] byteArray = new byte[size];
    RANDOM.nextBytes(byteArray);
    return ByteBuffer.wrap(byteArray);
  }
}
