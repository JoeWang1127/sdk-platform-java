/*
 * Copyright 2017 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.google.api.gax.grpc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeCallContext;
import com.google.api.gax.rpc.testing.FakeChannel;
import com.google.api.gax.rpc.testing.FakeTransportChannel;
import com.google.api.gax.tracing.ApiTracer;
import com.google.auth.Credentials;
import com.google.common.collect.ImmutableMap;
import com.google.common.truth.Truth;
import io.grpc.CallOptions;
import io.grpc.ManagedChannel;
import io.grpc.Metadata.Key;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

@RunWith(JUnit4.class)
public class GrpcCallContextTest {

  @Test
  public void testNullToSelfWrongType() {
    try {
      GrpcCallContext.createDefault().nullToSelf(FakeCallContext.createDefault());
      Assert.fail("GrpcCallContext should have thrown an exception");
    } catch (IllegalArgumentException expected) {
      Truth.assertThat(expected)
          .hasMessageThat()
          .contains("context must be an instance of GrpcCallContext");
    }
  }

  @Test
  public void testWithCredentials() {
    Credentials credentials = Mockito.mock(Credentials.class);
    GrpcCallContext emptyContext = GrpcCallContext.createDefault();
    assertNull(emptyContext.getCallOptions().getCredentials());
    GrpcCallContext context = emptyContext.withCredentials(credentials);
    assertNotNull(context.getCallOptions().getCredentials());
  }

  @Test
  public void testWithTransportChannel() {
    ManagedChannel channel = Mockito.mock(ManagedChannel.class);
    GrpcCallContext context =
        GrpcCallContext.createDefault().withTransportChannel(GrpcTransportChannel.create(channel));
    Truth.assertThat(context.getChannel()).isSameInstanceAs(channel);
  }

  @Test
  public void testWithTransportChannelWrongType() {
    FakeChannel channel = new FakeChannel();
    try {
      GrpcCallContext.createDefault().withTransportChannel(FakeTransportChannel.create(channel));
      Assert.fail("GrpcCallContext should have thrown an exception");
    } catch (IllegalArgumentException expected) {
      Truth.assertThat(expected).hasMessageThat().contains("Expected GrpcTransportChannel");
    }
  }

  @Test
  public void testMergeWrongType() {
    try {
      GrpcCallContext.createDefault().merge(FakeCallContext.createDefault());
      Assert.fail("GrpcCallContext should have thrown an exception");
    } catch (IllegalArgumentException expected) {
      Truth.assertThat(expected)
          .hasMessageThat()
          .contains("context must be an instance of " + "GrpcCallContext");
    }
  }

  @Test
  public void testWithRequestParamsDynamicHeaderOption() {
    String encodedRequestParams = "param1=value&param2.param3=value23";
    GrpcCallContext context =
        GrpcCallContext.createDefault().withRequestParamsDynamicHeaderOption(encodedRequestParams);

    Map<Key<String>, String> headers =
        CallOptionsUtil.getDynamicHeadersOption(context.getCallOptions());

    assertEquals(
        ImmutableMap.of(CallOptionsUtil.REQUEST_PARAMS_HEADER_KEY, encodedRequestParams), headers);
  }

  @Test
  public void testWithTimeout() {
    org.threeten.bp.Duration timeout = null;
    assertNull(GrpcCallContext.createDefault().withTimeout(timeout).getTimeoutDuration());
  }

  @Test
  public void testWithNegativeTimeout() {
    assertNull(
        GrpcCallContext.createDefault()
            .withTimeout(java.time.Duration.ofSeconds(-1L))
            .getTimeoutDuration());
  }

  @Test
  public void testWithZeroTimeout() {
    assertNull(
        GrpcCallContext.createDefault().withTimeout(java.time.Duration.ofSeconds(0L)).getTimeoutDuration());
  }

  @Test
  public void testWithShorterTimeout() {
    GrpcCallContext ctxWithLongTimeout =
        GrpcCallContext.createDefault().withTimeout(java.time.Duration.ofSeconds(10));

    // Sanity check
    Truth.assertThat(ctxWithLongTimeout.getTimeoutDuration()).isEqualTo(java.time.Duration.ofSeconds(10));

    // Shorten the timeout and make sure it changed
    GrpcCallContext ctxWithShorterTimeout =
        ctxWithLongTimeout.withTimeout(java.time.Duration.ofSeconds(5));
    Truth.assertThat(ctxWithShorterTimeout.getTimeoutDuration()).isEqualTo(java.time.Duration.ofSeconds(5));
  }

  @Test
  public void testWithLongerTimeout() {
    GrpcCallContext ctxWithShortTimeout =
        GrpcCallContext.createDefault().withTimeout(java.time.Duration.ofSeconds(5));

    // Sanity check
    Truth.assertThat(ctxWithShortTimeout.getTimeoutDuration()).isEqualTo(java.time.Duration.ofSeconds(5));

    // Try to extend the timeout and verify that it was ignored
    GrpcCallContext ctxWithUnchangedTimeout =
        ctxWithShortTimeout.withTimeout(java.time.Duration.ofSeconds(10));
    Truth.assertThat(ctxWithUnchangedTimeout.getTimeoutDuration())
        .isEqualTo(java.time.Duration.ofSeconds(5));
  }

  @Test
  public void testMergeWithNullTimeout() {
    java.time.Duration timeout = java.time.Duration.ofSeconds(10);
    GrpcCallContext baseContext = GrpcCallContext.createDefault().withTimeout(timeout);

    GrpcCallContext defaultOverlay = GrpcCallContext.createDefault();
    Truth.assertThat(baseContext.merge(defaultOverlay).getTimeoutDuration()).isEqualTo(timeout);

    org.threeten.bp.Duration callContextTimeout = null;
    GrpcCallContext explicitNullOverlay =
        GrpcCallContext.createDefault().withTimeout(callContextTimeout);
    Truth.assertThat(baseContext.merge(explicitNullOverlay).getTimeoutDuration()).isEqualTo(timeout);
  }

  @Test
  public void testMergeWithTimeout() {
    java.time.Duration timeout = java.time.Duration.ofSeconds(19);
    GrpcCallContext ctx1 = GrpcCallContext.createDefault();
    GrpcCallContext ctx2 = GrpcCallContext.createDefault().withTimeout(timeout);

    Truth.assertThat(ctx1.merge(ctx2).getTimeoutDuration()).isEqualTo(timeout);
  }

  @Test
  public void testWithStreamingWaitTimeout() {
    java.time.Duration timeout = java.time.Duration.ofSeconds(15);
    GrpcCallContext context = GrpcCallContext.createDefault().withStreamWaitTimeout(timeout);
    Truth.assertThat(context.getStreamWaitTimeoutDuration()).isEqualTo(timeout);
  }

  @Test
  public void testMergeWithNullStreamingWaitTimeout() {
    java.time.Duration timeout = java.time.Duration.ofSeconds(10);
    GrpcCallContext baseContext = GrpcCallContext.createDefault().withStreamWaitTimeout(timeout);

    GrpcCallContext defaultOverlay = GrpcCallContext.createDefault();
    Truth.assertThat(baseContext.merge(defaultOverlay).getStreamWaitTimeoutDuration()).isEqualTo(timeout);

    java.time.Duration streamWaitTimeout = null;
    GrpcCallContext explicitNullOverlay =
        GrpcCallContext.createDefault().withStreamWaitTimeout(streamWaitTimeout);
    Truth.assertThat(baseContext.merge(explicitNullOverlay).getStreamWaitTimeoutDuration())
        .isEqualTo(timeout);
  }

  @Test
  public void testWithZeroStreamingWaitTimeout() {
    java.time.Duration timeout = java.time.Duration.ZERO;
    Truth.assertThat(
            GrpcCallContext.createDefault().withStreamWaitTimeout(timeout).getStreamWaitTimeoutDuration())
        .isEqualTo(timeout);
  }

  @Test
  public void testMergeWithStreamingWaitTimeout() {
    java.time.Duration timeout = java.time.Duration.ofSeconds(19);
    GrpcCallContext ctx1 = GrpcCallContext.createDefault();
    GrpcCallContext ctx2 = GrpcCallContext.createDefault().withStreamWaitTimeout(timeout);

    Truth.assertThat(ctx1.merge(ctx2).getStreamWaitTimeoutDuration()).isEqualTo(timeout);
  }

  @Test
  public void testWithStreamingIdleTimeout() {
    java.time.Duration timeout = java.time.Duration.ofSeconds(15);
    GrpcCallContext context = GrpcCallContext.createDefault().withStreamIdleTimeout(timeout);
    Truth.assertThat(context.getStreamIdleTimeoutDuration()).isEqualTo(timeout);
  }

  @Test
  public void testMergeWithNullStreamingIdleTimeout() {
    java.time.Duration timeout = java.time.Duration.ofSeconds(10);
    GrpcCallContext baseContext = GrpcCallContext.createDefault().withStreamIdleTimeout(timeout);

    GrpcCallContext defaultOverlay = GrpcCallContext.createDefault();
    Truth.assertThat(baseContext.merge(defaultOverlay).getStreamIdleTimeoutDuration()).isEqualTo(timeout);

    java.time.Duration idleTimeout = null;
    GrpcCallContext explicitNullOverlay =
        GrpcCallContext.createDefault().withStreamIdleTimeout(idleTimeout);
    Truth.assertThat(baseContext.merge(explicitNullOverlay).getStreamIdleTimeoutDuration())
        .isEqualTo(timeout);
  }

  @Test
  public void testWithZeroStreamingIdleTimeout() {
    java.time.Duration timeout = java.time.Duration.ZERO;
    Truth.assertThat(
            GrpcCallContext.createDefault().withStreamIdleTimeout(timeout).getStreamIdleTimeoutDuration())
        .isEqualTo(timeout);
  }

  @Test
  public void testMergeWithStreamingIdleTimeout() {
    java.time.Duration timeout = java.time.Duration.ofSeconds(19);
    GrpcCallContext ctx1 = GrpcCallContext.createDefault();
    GrpcCallContext ctx2 = GrpcCallContext.createDefault().withStreamIdleTimeout(timeout);

    Truth.assertThat(ctx1.merge(ctx2).getStreamIdleTimeoutDuration()).isEqualTo(timeout);
  }

  @Test
  public void testMergeWithCustomCallOptions() {
    CallOptions.Key<String> key = CallOptions.Key.createWithDefault("somekey", "somedefault");
    GrpcCallContext ctx1 = GrpcCallContext.createDefault();
    GrpcCallContext ctx2 =
        GrpcCallContext.createDefault()
            .withCallOptions(CallOptions.DEFAULT.withOption(key, "somevalue"));

    GrpcCallContext merged = (GrpcCallContext) ctx1.merge(ctx2);
    Truth.assertThat(merged.getCallOptions().getOption(key))
        .isNotEqualTo(ctx1.getCallOptions().getOption(key));
    Truth.assertThat(merged.getCallOptions().getOption(key))
        .isEqualTo(ctx2.getCallOptions().getOption(key));
  }

  @Test
  public void testWithExtraHeaders() {
    Map<String, List<String>> extraHeaders =
        createTestExtraHeaders("key1", "value1", "key1", "value2");
    GrpcCallContext ctx = GrpcCallContext.createDefault().withExtraHeaders(extraHeaders);
    Map<String, List<String>> moreExtraHeaders =
        createTestExtraHeaders("key1", "value2", "key2", "value2");
    ctx = ctx.withExtraHeaders(moreExtraHeaders);
    Map<String, List<String>> gotExtraHeaders = ctx.getExtraHeaders();
    Map<String, List<String>> expectedExtraHeaders =
        createTestExtraHeaders(
            "key1", "value1", "key1", "value2", "key1", "value2", "key2", "value2");
    Truth.assertThat(gotExtraHeaders).containsExactlyEntriesIn(expectedExtraHeaders);
  }

  @Test
  public void testMergeWithExtraHeaders() {
    Map<String, List<String>> extraHeaders1 =
        createTestExtraHeaders("key1", "value1", "key1", "value2");
    GrpcCallContext ctx1 = GrpcCallContext.createDefault().withExtraHeaders(extraHeaders1);
    Map<String, List<String>> extraHeaders2 =
        createTestExtraHeaders("key1", "value2", "key2", "value2");
    GrpcCallContext ctx2 = GrpcCallContext.createDefault().withExtraHeaders(extraHeaders2);
    ApiCallContext mergedApiCallContext = ctx1.merge(ctx2);
    Truth.assertThat(mergedApiCallContext).isInstanceOf(GrpcCallContext.class);
    GrpcCallContext mergedGrpcCallContext = (GrpcCallContext) mergedApiCallContext;
    Map<String, List<String>> gotExtraHeaders = mergedGrpcCallContext.getExtraHeaders();
    Map<String, List<String>> expectedExtraHeaders =
        createTestExtraHeaders(
            "key1", "value1", "key1", "value2", "key1", "value2", "key2", "value2");
    Truth.assertThat(gotExtraHeaders).containsExactlyEntriesIn(expectedExtraHeaders);
  }

  @Test
  public void testMergeWithTracer() {
    ApiTracer explicitTracer = Mockito.mock(ApiTracer.class);
    GrpcCallContext ctxWithExplicitTracer =
        GrpcCallContext.createDefault().withTracer(explicitTracer);

    GrpcCallContext ctxWithDefaultTracer = GrpcCallContext.createDefault();
    ApiTracer defaultTracer = ctxWithDefaultTracer.getTracer();

    // Explicit tracer overrides the default tracer.
    Truth.assertThat(ctxWithDefaultTracer.merge(ctxWithExplicitTracer).getTracer())
        .isSameInstanceAs(explicitTracer);

    // Default tracer does not override an explicit tracer.
    Truth.assertThat(ctxWithExplicitTracer.merge(ctxWithDefaultTracer).getTracer())
        .isSameInstanceAs(explicitTracer);

    // Default tracer does not override another default tracer.
    Truth.assertThat(ctxWithDefaultTracer.merge(GrpcCallContext.createDefault()).getTracer())
        .isSameInstanceAs(defaultTracer);
  }

  @Test
  public void testWithRetrySettings() {
    RetrySettings retrySettings = Mockito.mock(RetrySettings.class);
    GrpcCallContext emptyContext = GrpcCallContext.createDefault();
    assertNull(emptyContext.getRetrySettings());
    GrpcCallContext context = emptyContext.withRetrySettings(retrySettings);
    assertNotNull(context.getRetrySettings());
  }

  @Test
  public void testWithRetryableCodes() {
    Set<StatusCode.Code> codes = Collections.singleton(StatusCode.Code.UNAVAILABLE);
    GrpcCallContext emptyContext = GrpcCallContext.createDefault();
    assertNull(emptyContext.getRetryableCodes());
    GrpcCallContext context = emptyContext.withRetryableCodes(codes);
    assertNotNull(context.getRetryableCodes());
  }

  @Test
  public void testWithOptions() {
    GrpcCallContext emptyCallContext = GrpcCallContext.createDefault();
    ApiCallContext.Key<String> contextKey1 = ApiCallContext.Key.create("testKey1");
    ApiCallContext.Key<String> contextKey2 = ApiCallContext.Key.create("testKey2");
    String testContext1 = "test1";
    String testContext2 = "test2";
    String testContextOverwrite = "test1Overwrite";
    GrpcCallContext context =
        emptyCallContext
            .withOption(contextKey1, testContext1)
            .withOption(contextKey2, testContext2);
    assertEquals(testContext1, context.getOption(contextKey1));
    assertEquals(testContext2, context.getOption(contextKey2));
    GrpcCallContext newContext = context.withOption(contextKey1, testContextOverwrite);
    assertEquals(testContextOverwrite, newContext.getOption(contextKey1));
  }

  @Test
  public void testMergeOptions() {
    GrpcCallContext emptyCallContext = GrpcCallContext.createDefault();
    ApiCallContext.Key<String> contextKey1 = ApiCallContext.Key.create("testKey1");
    ApiCallContext.Key<String> contextKey2 = ApiCallContext.Key.create("testKey2");
    ApiCallContext.Key<String> contextKey3 = ApiCallContext.Key.create("testKey3");
    String testContext1 = "test1";
    String testContext2 = "test2";
    String testContext3 = "test3";
    String testContextOverwrite = "test1Overwrite";
    GrpcCallContext context1 =
        emptyCallContext
            .withOption(contextKey1, testContext1)
            .withOption(contextKey2, testContext2);
    GrpcCallContext context2 =
        emptyCallContext
            .withOption(contextKey1, testContextOverwrite)
            .withOption(contextKey3, testContext3);
    ApiCallContext mergedContext = context1.merge(context2);
    assertEquals(testContextOverwrite, mergedContext.getOption(contextKey1));
    assertEquals(testContext2, mergedContext.getOption(contextKey2));
    assertEquals(testContext3, mergedContext.getOption(contextKey3));
  }

  private static Map<String, List<String>> createTestExtraHeaders(String... keyValues) {
    Map<String, List<String>> extraHeaders = new HashMap<>();
    for (int i = 0; i < keyValues.length; i += 2) {
      String key = keyValues[i];
      String value = keyValues[i + 1];
      if (!extraHeaders.containsKey(key)) {
        extraHeaders.put(key, new ArrayList<String>());
      }
      extraHeaders.get(key).add(value);
    }
    return extraHeaders;
  }
}
