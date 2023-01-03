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
// source: google/api/field_behavior.proto

package com.google.api;

/**
 *
 *
 * <pre>
 * An indicator of the behavior of a given field (for example, that a field
 * is required in requests, or given as output but ignored as input).
 * This **does not** change the behavior in protocol buffers itself; it only
 * denotes the behavior and may affect how API tooling handles the field.
 * Note: This enum **may** receive new values in the future.
 * </pre>
 *
 * Protobuf enum {@code google.api.FieldBehavior}
 */
public enum FieldBehavior implements com.google.protobuf.ProtocolMessageEnum {
  /**
   *
   *
   * <pre>
   * Conventional default for enums. Do not use this.
   * </pre>
   *
   * <code>FIELD_BEHAVIOR_UNSPECIFIED = 0;</code>
   */
  FIELD_BEHAVIOR_UNSPECIFIED(0),
  /**
   *
   *
   * <pre>
   * Specifically denotes a field as optional.
   * While all fields in protocol buffers are optional, this may be specified
   * for emphasis if appropriate.
   * </pre>
   *
   * <code>OPTIONAL = 1;</code>
   */
  OPTIONAL(1),
  /**
   *
   *
   * <pre>
   * Denotes a field as required.
   * This indicates that the field **must** be provided as part of the request,
   * and failure to do so will cause an error (usually `INVALID_ARGUMENT`).
   * </pre>
   *
   * <code>REQUIRED = 2;</code>
   */
  REQUIRED(2),
  /**
   *
   *
   * <pre>
   * Denotes a field as output only.
   * This indicates that the field is provided in responses, but including the
   * field in a request does nothing (the server *must* ignore it and
   * *must not* throw an error as a result of the field's presence).
   * </pre>
   *
   * <code>OUTPUT_ONLY = 3;</code>
   */
  OUTPUT_ONLY(3),
  /**
   *
   *
   * <pre>
   * Denotes a field as input only.
   * This indicates that the field is provided in requests, and the
   * corresponding field is not included in output.
   * </pre>
   *
   * <code>INPUT_ONLY = 4;</code>
   */
  INPUT_ONLY(4),
  /**
   *
   *
   * <pre>
   * Denotes a field as immutable.
   * This indicates that the field may be set once in a request to create a
   * resource, but may not be changed thereafter.
   * </pre>
   *
   * <code>IMMUTABLE = 5;</code>
   */
  IMMUTABLE(5),
  /**
   *
   *
   * <pre>
   * Denotes that a (repeated) field is an unordered list.
   * This indicates that the service may provide the elements of the list
   * in any arbitrary  order, rather than the order the user originally
   * provided. Additionally, the list's order may or may not be stable.
   * </pre>
   *
   * <code>UNORDERED_LIST = 6;</code>
   */
  UNORDERED_LIST(6),
  /**
   *
   *
   * <pre>
   * Denotes that this field returns a non-empty default value if not set.
   * This indicates that if the user provides the empty value in a request,
   * a non-empty value will be returned. The user will not be aware of what
   * non-empty value to expect.
   * </pre>
   *
   * <code>NON_EMPTY_DEFAULT = 7;</code>
   */
  NON_EMPTY_DEFAULT(7),
  UNRECOGNIZED(-1),
  ;

  /**
   *
   *
   * <pre>
   * Conventional default for enums. Do not use this.
   * </pre>
   *
   * <code>FIELD_BEHAVIOR_UNSPECIFIED = 0;</code>
   */
  public static final int FIELD_BEHAVIOR_UNSPECIFIED_VALUE = 0;
  /**
   *
   *
   * <pre>
   * Specifically denotes a field as optional.
   * While all fields in protocol buffers are optional, this may be specified
   * for emphasis if appropriate.
   * </pre>
   *
   * <code>OPTIONAL = 1;</code>
   */
  public static final int OPTIONAL_VALUE = 1;
  /**
   *
   *
   * <pre>
   * Denotes a field as required.
   * This indicates that the field **must** be provided as part of the request,
   * and failure to do so will cause an error (usually `INVALID_ARGUMENT`).
   * </pre>
   *
   * <code>REQUIRED = 2;</code>
   */
  public static final int REQUIRED_VALUE = 2;
  /**
   *
   *
   * <pre>
   * Denotes a field as output only.
   * This indicates that the field is provided in responses, but including the
   * field in a request does nothing (the server *must* ignore it and
   * *must not* throw an error as a result of the field's presence).
   * </pre>
   *
   * <code>OUTPUT_ONLY = 3;</code>
   */
  public static final int OUTPUT_ONLY_VALUE = 3;
  /**
   *
   *
   * <pre>
   * Denotes a field as input only.
   * This indicates that the field is provided in requests, and the
   * corresponding field is not included in output.
   * </pre>
   *
   * <code>INPUT_ONLY = 4;</code>
   */
  public static final int INPUT_ONLY_VALUE = 4;
  /**
   *
   *
   * <pre>
   * Denotes a field as immutable.
   * This indicates that the field may be set once in a request to create a
   * resource, but may not be changed thereafter.
   * </pre>
   *
   * <code>IMMUTABLE = 5;</code>
   */
  public static final int IMMUTABLE_VALUE = 5;
  /**
   *
   *
   * <pre>
   * Denotes that a (repeated) field is an unordered list.
   * This indicates that the service may provide the elements of the list
   * in any arbitrary  order, rather than the order the user originally
   * provided. Additionally, the list's order may or may not be stable.
   * </pre>
   *
   * <code>UNORDERED_LIST = 6;</code>
   */
  public static final int UNORDERED_LIST_VALUE = 6;
  /**
   *
   *
   * <pre>
   * Denotes that this field returns a non-empty default value if not set.
   * This indicates that if the user provides the empty value in a request,
   * a non-empty value will be returned. The user will not be aware of what
   * non-empty value to expect.
   * </pre>
   *
   * <code>NON_EMPTY_DEFAULT = 7;</code>
   */
  public static final int NON_EMPTY_DEFAULT_VALUE = 7;

  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static FieldBehavior valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static FieldBehavior forNumber(int value) {
    switch (value) {
      case 0:
        return FIELD_BEHAVIOR_UNSPECIFIED;
      case 1:
        return OPTIONAL;
      case 2:
        return REQUIRED;
      case 3:
        return OUTPUT_ONLY;
      case 4:
        return INPUT_ONLY;
      case 5:
        return IMMUTABLE;
      case 6:
        return UNORDERED_LIST;
      case 7:
        return NON_EMPTY_DEFAULT;
      default:
        return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<FieldBehavior> internalGetValueMap() {
    return internalValueMap;
  }

  private static final com.google.protobuf.Internal.EnumLiteMap<FieldBehavior> internalValueMap =
      new com.google.protobuf.Internal.EnumLiteMap<FieldBehavior>() {
        public FieldBehavior findValueByNumber(int number) {
          return FieldBehavior.forNumber(number);
        }
      };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor getValueDescriptor() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalStateException(
          "Can't get the descriptor of an unrecognized enum value.");
    }
    return getDescriptor().getValues().get(ordinal());
  }

  public final com.google.protobuf.Descriptors.EnumDescriptor getDescriptorForType() {
    return getDescriptor();
  }

  public static final com.google.protobuf.Descriptors.EnumDescriptor getDescriptor() {
    return com.google.api.FieldBehaviorProto.getDescriptor().getEnumTypes().get(0);
  }

  private static final FieldBehavior[] VALUES = values();

  public static FieldBehavior valueOf(com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException("EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private FieldBehavior(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:google.api.FieldBehavior)
}