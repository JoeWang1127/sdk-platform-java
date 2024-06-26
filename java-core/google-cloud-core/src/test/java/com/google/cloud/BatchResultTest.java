/*
 * Copyright 2016 Google LLC
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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import com.google.cloud.BaseServiceException.ExceptionData;
import org.easymock.EasyMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BatchResultTest {

  private BatchResult<Boolean, BaseServiceException> result;

  @BeforeEach
  public void setUp() {
    result = new BatchResult<Boolean, BaseServiceException>() {};
  }

  @Test
  void testSuccess() {
    assertFalse(result.completed());
    try {
      result.get();
      fail("This was not completed yet.");
    } catch (IllegalStateException ex) {
      // expected
    }
    result.success(true);
    assertTrue(result.get());
    // test that null is allowed
    result.success(null);
  }

  @Test
  void testError() {
    assertFalse(result.completed());
    try {
      result.get();
      fail("This was not completed yet.");
    } catch (IllegalStateException ex) {
      // expected
    }
    try {
      result.error(null);
      fail();
    } catch (NullPointerException exc) {
      // expected
    }
    BaseServiceException ex =
        new BaseServiceException(ExceptionData.from(0, "message", "reason", false));
    result.error(ex);
    try {
      result.get();
      fail("This is a failed operation and should have thrown a DnsException.");
    } catch (BaseServiceException real) {
      assertSame(ex, real);
    }
  }

  @Test
  void testNotifyError() {
    final BaseServiceException ex =
        new BaseServiceException(ExceptionData.from(0, "message", "reason", false));
    assertFalse(result.completed());
    BatchResult.Callback<Boolean, BaseServiceException> callback =
        EasyMock.createStrictMock(BatchResult.Callback.class);
    callback.error(ex);
    EasyMock.replay(callback);
    result.notify(callback);
    result.error(ex);
    try {
      result.notify(callback);
      fail("The batch has been completed.");
    } catch (IllegalStateException exception) {
      // expected
    }
    EasyMock.verify(callback);
  }

  @Test
  void testNotifySuccess() {
    assertFalse(result.completed());
    BatchResult.Callback<Boolean, BaseServiceException> callback =
        EasyMock.createStrictMock(BatchResult.Callback.class);
    callback.success(true);
    EasyMock.replay(callback);
    result.notify(callback);
    result.success(true);
    try {
      result.notify(callback);
      fail("The batch has been completed.");
    } catch (IllegalStateException exception) {
      // expected
    }
    EasyMock.verify(callback);
  }
}
