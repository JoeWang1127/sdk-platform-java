/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/rpc/error_details.proto

package com.google.rpc;

public interface QuotaFailureOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.rpc.QuotaFailure)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * Describes all quota violations.
   * </pre>
   *
   * <code>repeated .google.rpc.QuotaFailure.Violation violations = 1;</code>
   */
  java.util.List<com.google.rpc.QuotaFailure.Violation> getViolationsList();
  /**
   *
   *
   * <pre>
   * Describes all quota violations.
   * </pre>
   *
   * <code>repeated .google.rpc.QuotaFailure.Violation violations = 1;</code>
   */
  com.google.rpc.QuotaFailure.Violation getViolations(int index);
  /**
   *
   *
   * <pre>
   * Describes all quota violations.
   * </pre>
   *
   * <code>repeated .google.rpc.QuotaFailure.Violation violations = 1;</code>
   */
  int getViolationsCount();
  /**
   *
   *
   * <pre>
   * Describes all quota violations.
   * </pre>
   *
   * <code>repeated .google.rpc.QuotaFailure.Violation violations = 1;</code>
   */
  java.util.List<? extends com.google.rpc.QuotaFailure.ViolationOrBuilder>
      getViolationsOrBuilderList();
  /**
   *
   *
   * <pre>
   * Describes all quota violations.
   * </pre>
   *
   * <code>repeated .google.rpc.QuotaFailure.Violation violations = 1;</code>
   */
  com.google.rpc.QuotaFailure.ViolationOrBuilder getViolationsOrBuilder(int index);
}
