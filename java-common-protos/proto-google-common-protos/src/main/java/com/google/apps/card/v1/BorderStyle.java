/*
 * Copyright 2024 Google LLC
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
// source: google/apps/card/v1/card.proto

// Protobuf Java Version: 3.25.2
package com.google.apps.card.v1;

/**
 *
 *
 * <pre>
 * The style options for the border of a card or widget, including the border
 * type and color.
 *
 * [Google Workspace Add-ons and Chat
 * apps](https://developers.google.com/workspace/extend):
 * </pre>
 *
 * Protobuf type {@code google.apps.card.v1.BorderStyle}
 */
public final class BorderStyle extends com.google.protobuf.GeneratedMessageV3
    implements
    // @@protoc_insertion_point(message_implements:google.apps.card.v1.BorderStyle)
    BorderStyleOrBuilder {
  private static final long serialVersionUID = 0L;
  // Use BorderStyle.newBuilder() to construct.
  private BorderStyle(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private BorderStyle() {
    type_ = 0;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
    return new BorderStyle();
  }

  public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
    return com.google.apps.card.v1.CardProto
        .internal_static_google_apps_card_v1_BorderStyle_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.google.apps.card.v1.CardProto
        .internal_static_google_apps_card_v1_BorderStyle_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.google.apps.card.v1.BorderStyle.class,
            com.google.apps.card.v1.BorderStyle.Builder.class);
  }

  /**
   *
   *
   * <pre>
   * Represents the border types applied to widgets.
   *
   * [Google Workspace Add-ons
   * and Chat apps](https://developers.google.com/workspace/extend):
   * </pre>
   *
   * Protobuf enum {@code google.apps.card.v1.BorderStyle.BorderType}
   */
  public enum BorderType implements com.google.protobuf.ProtocolMessageEnum {
    /**
     *
     *
     * <pre>
     * Don't use. Unspecified.
     * </pre>
     *
     * <code>BORDER_TYPE_UNSPECIFIED = 0;</code>
     */
    BORDER_TYPE_UNSPECIFIED(0),
    /**
     *
     *
     * <pre>
     * Default value. No border.
     * </pre>
     *
     * <code>NO_BORDER = 1;</code>
     */
    NO_BORDER(1),
    /**
     *
     *
     * <pre>
     * Outline.
     * </pre>
     *
     * <code>STROKE = 2;</code>
     */
    STROKE(2),
    UNRECOGNIZED(-1),
    ;

    /**
     *
     *
     * <pre>
     * Don't use. Unspecified.
     * </pre>
     *
     * <code>BORDER_TYPE_UNSPECIFIED = 0;</code>
     */
    public static final int BORDER_TYPE_UNSPECIFIED_VALUE = 0;
    /**
     *
     *
     * <pre>
     * Default value. No border.
     * </pre>
     *
     * <code>NO_BORDER = 1;</code>
     */
    public static final int NO_BORDER_VALUE = 1;
    /**
     *
     *
     * <pre>
     * Outline.
     * </pre>
     *
     * <code>STROKE = 2;</code>
     */
    public static final int STROKE_VALUE = 2;

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
    public static BorderType valueOf(int value) {
      return forNumber(value);
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     */
    public static BorderType forNumber(int value) {
      switch (value) {
        case 0:
          return BORDER_TYPE_UNSPECIFIED;
        case 1:
          return NO_BORDER;
        case 2:
          return STROKE;
        default:
          return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<BorderType> internalGetValueMap() {
      return internalValueMap;
    }

    private static final com.google.protobuf.Internal.EnumLiteMap<BorderType> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<BorderType>() {
          public BorderType findValueByNumber(int number) {
            return BorderType.forNumber(number);
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
      return com.google.apps.card.v1.BorderStyle.getDescriptor().getEnumTypes().get(0);
    }

    private static final BorderType[] VALUES = values();

    public static BorderType valueOf(com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException("EnumValueDescriptor is not for this type.");
      }
      if (desc.getIndex() == -1) {
        return UNRECOGNIZED;
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private BorderType(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:google.apps.card.v1.BorderStyle.BorderType)
  }

  private int bitField0_;
  public static final int TYPE_FIELD_NUMBER = 1;
  private int type_ = 0;
  /**
   *
   *
   * <pre>
   * The border type.
   * </pre>
   *
   * <code>.google.apps.card.v1.BorderStyle.BorderType type = 1;</code>
   *
   * @return The enum numeric value on the wire for type.
   */
  @java.lang.Override
  public int getTypeValue() {
    return type_;
  }
  /**
   *
   *
   * <pre>
   * The border type.
   * </pre>
   *
   * <code>.google.apps.card.v1.BorderStyle.BorderType type = 1;</code>
   *
   * @return The type.
   */
  @java.lang.Override
  public com.google.apps.card.v1.BorderStyle.BorderType getType() {
    com.google.apps.card.v1.BorderStyle.BorderType result =
        com.google.apps.card.v1.BorderStyle.BorderType.forNumber(type_);
    return result == null ? com.google.apps.card.v1.BorderStyle.BorderType.UNRECOGNIZED : result;
  }

  public static final int STROKE_COLOR_FIELD_NUMBER = 2;
  private com.google.type.Color strokeColor_;
  /**
   *
   *
   * <pre>
   * The colors to use when the type is `BORDER_TYPE_STROKE`.
   * </pre>
   *
   * <code>.google.type.Color stroke_color = 2;</code>
   *
   * @return Whether the strokeColor field is set.
   */
  @java.lang.Override
  public boolean hasStrokeColor() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   *
   *
   * <pre>
   * The colors to use when the type is `BORDER_TYPE_STROKE`.
   * </pre>
   *
   * <code>.google.type.Color stroke_color = 2;</code>
   *
   * @return The strokeColor.
   */
  @java.lang.Override
  public com.google.type.Color getStrokeColor() {
    return strokeColor_ == null ? com.google.type.Color.getDefaultInstance() : strokeColor_;
  }
  /**
   *
   *
   * <pre>
   * The colors to use when the type is `BORDER_TYPE_STROKE`.
   * </pre>
   *
   * <code>.google.type.Color stroke_color = 2;</code>
   */
  @java.lang.Override
  public com.google.type.ColorOrBuilder getStrokeColorOrBuilder() {
    return strokeColor_ == null ? com.google.type.Color.getDefaultInstance() : strokeColor_;
  }

  public static final int CORNER_RADIUS_FIELD_NUMBER = 3;
  private int cornerRadius_ = 0;
  /**
   *
   *
   * <pre>
   * The corner radius for the border.
   * </pre>
   *
   * <code>int32 corner_radius = 3;</code>
   *
   * @return The cornerRadius.
   */
  @java.lang.Override
  public int getCornerRadius() {
    return cornerRadius_;
  }

  private byte memoizedIsInitialized = -1;

  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output) throws java.io.IOException {
    if (type_
        != com.google.apps.card.v1.BorderStyle.BorderType.BORDER_TYPE_UNSPECIFIED.getNumber()) {
      output.writeEnum(1, type_);
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      output.writeMessage(2, getStrokeColor());
    }
    if (cornerRadius_ != 0) {
      output.writeInt32(3, cornerRadius_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (type_
        != com.google.apps.card.v1.BorderStyle.BorderType.BORDER_TYPE_UNSPECIFIED.getNumber()) {
      size += com.google.protobuf.CodedOutputStream.computeEnumSize(1, type_);
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.CodedOutputStream.computeMessageSize(2, getStrokeColor());
    }
    if (cornerRadius_ != 0) {
      size += com.google.protobuf.CodedOutputStream.computeInt32Size(3, cornerRadius_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof com.google.apps.card.v1.BorderStyle)) {
      return super.equals(obj);
    }
    com.google.apps.card.v1.BorderStyle other = (com.google.apps.card.v1.BorderStyle) obj;

    if (type_ != other.type_) return false;
    if (hasStrokeColor() != other.hasStrokeColor()) return false;
    if (hasStrokeColor()) {
      if (!getStrokeColor().equals(other.getStrokeColor())) return false;
    }
    if (getCornerRadius() != other.getCornerRadius()) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + TYPE_FIELD_NUMBER;
    hash = (53 * hash) + type_;
    if (hasStrokeColor()) {
      hash = (37 * hash) + STROKE_COLOR_FIELD_NUMBER;
      hash = (53 * hash) + getStrokeColor().hashCode();
    }
    hash = (37 * hash) + CORNER_RADIUS_FIELD_NUMBER;
    hash = (53 * hash) + getCornerRadius();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.google.apps.card.v1.BorderStyle parseFrom(java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.apps.card.v1.BorderStyle parseFrom(
      java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.apps.card.v1.BorderStyle parseFrom(com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.apps.card.v1.BorderStyle parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.apps.card.v1.BorderStyle parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.apps.card.v1.BorderStyle parseFrom(
      byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.apps.card.v1.BorderStyle parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.apps.card.v1.BorderStyle parseFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.apps.card.v1.BorderStyle parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
  }

  public static com.google.apps.card.v1.BorderStyle parseDelimitedFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.apps.card.v1.BorderStyle parseFrom(
      com.google.protobuf.CodedInputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.apps.card.v1.BorderStyle parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() {
    return newBuilder();
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(com.google.apps.card.v1.BorderStyle prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   *
   *
   * <pre>
   * The style options for the border of a card or widget, including the border
   * type and color.
   *
   * [Google Workspace Add-ons and Chat
   * apps](https://developers.google.com/workspace/extend):
   * </pre>
   *
   * Protobuf type {@code google.apps.card.v1.BorderStyle}
   */
  public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
      implements
      // @@protoc_insertion_point(builder_implements:google.apps.card.v1.BorderStyle)
      com.google.apps.card.v1.BorderStyleOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.google.apps.card.v1.CardProto
          .internal_static_google_apps_card_v1_BorderStyle_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.google.apps.card.v1.CardProto
          .internal_static_google_apps_card_v1_BorderStyle_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.google.apps.card.v1.BorderStyle.class,
              com.google.apps.card.v1.BorderStyle.Builder.class);
    }

    // Construct using com.google.apps.card.v1.BorderStyle.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {
        getStrokeColorFieldBuilder();
      }
    }

    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      type_ = 0;
      strokeColor_ = null;
      if (strokeColorBuilder_ != null) {
        strokeColorBuilder_.dispose();
        strokeColorBuilder_ = null;
      }
      cornerRadius_ = 0;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
      return com.google.apps.card.v1.CardProto
          .internal_static_google_apps_card_v1_BorderStyle_descriptor;
    }

    @java.lang.Override
    public com.google.apps.card.v1.BorderStyle getDefaultInstanceForType() {
      return com.google.apps.card.v1.BorderStyle.getDefaultInstance();
    }

    @java.lang.Override
    public com.google.apps.card.v1.BorderStyle build() {
      com.google.apps.card.v1.BorderStyle result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.google.apps.card.v1.BorderStyle buildPartial() {
      com.google.apps.card.v1.BorderStyle result = new com.google.apps.card.v1.BorderStyle(this);
      if (bitField0_ != 0) {
        buildPartial0(result);
      }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.google.apps.card.v1.BorderStyle result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.type_ = type_;
      }
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.strokeColor_ =
            strokeColorBuilder_ == null ? strokeColor_ : strokeColorBuilder_.build();
        to_bitField0_ |= 0x00000001;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.cornerRadius_ = cornerRadius_;
      }
      result.bitField0_ |= to_bitField0_;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }

    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field, java.lang.Object value) {
      return super.setField(field, value);
    }

    @java.lang.Override
    public Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }

    @java.lang.Override
    public Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }

    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field, int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }

    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field, java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.google.apps.card.v1.BorderStyle) {
        return mergeFrom((com.google.apps.card.v1.BorderStyle) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.google.apps.card.v1.BorderStyle other) {
      if (other == com.google.apps.card.v1.BorderStyle.getDefaultInstance()) return this;
      if (other.type_ != 0) {
        setTypeValue(other.getTypeValue());
      }
      if (other.hasStrokeColor()) {
        mergeStrokeColor(other.getStrokeColor());
      }
      if (other.getCornerRadius() != 0) {
        setCornerRadius(other.getCornerRadius());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 8:
              {
                type_ = input.readEnum();
                bitField0_ |= 0x00000001;
                break;
              } // case 8
            case 18:
              {
                input.readMessage(getStrokeColorFieldBuilder().getBuilder(), extensionRegistry);
                bitField0_ |= 0x00000002;
                break;
              } // case 18
            case 24:
              {
                cornerRadius_ = input.readInt32();
                bitField0_ |= 0x00000004;
                break;
              } // case 24
            default:
              {
                if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                  done = true; // was an endgroup tag
                }
                break;
              } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }

    private int bitField0_;

    private int type_ = 0;
    /**
     *
     *
     * <pre>
     * The border type.
     * </pre>
     *
     * <code>.google.apps.card.v1.BorderStyle.BorderType type = 1;</code>
     *
     * @return The enum numeric value on the wire for type.
     */
    @java.lang.Override
    public int getTypeValue() {
      return type_;
    }
    /**
     *
     *
     * <pre>
     * The border type.
     * </pre>
     *
     * <code>.google.apps.card.v1.BorderStyle.BorderType type = 1;</code>
     *
     * @param value The enum numeric value on the wire for type to set.
     * @return This builder for chaining.
     */
    public Builder setTypeValue(int value) {
      type_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * The border type.
     * </pre>
     *
     * <code>.google.apps.card.v1.BorderStyle.BorderType type = 1;</code>
     *
     * @return The type.
     */
    @java.lang.Override
    public com.google.apps.card.v1.BorderStyle.BorderType getType() {
      com.google.apps.card.v1.BorderStyle.BorderType result =
          com.google.apps.card.v1.BorderStyle.BorderType.forNumber(type_);
      return result == null ? com.google.apps.card.v1.BorderStyle.BorderType.UNRECOGNIZED : result;
    }
    /**
     *
     *
     * <pre>
     * The border type.
     * </pre>
     *
     * <code>.google.apps.card.v1.BorderStyle.BorderType type = 1;</code>
     *
     * @param value The type to set.
     * @return This builder for chaining.
     */
    public Builder setType(com.google.apps.card.v1.BorderStyle.BorderType value) {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x00000001;
      type_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * The border type.
     * </pre>
     *
     * <code>.google.apps.card.v1.BorderStyle.BorderType type = 1;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearType() {
      bitField0_ = (bitField0_ & ~0x00000001);
      type_ = 0;
      onChanged();
      return this;
    }

    private com.google.type.Color strokeColor_;
    private com.google.protobuf.SingleFieldBuilderV3<
            com.google.type.Color, com.google.type.Color.Builder, com.google.type.ColorOrBuilder>
        strokeColorBuilder_;
    /**
     *
     *
     * <pre>
     * The colors to use when the type is `BORDER_TYPE_STROKE`.
     * </pre>
     *
     * <code>.google.type.Color stroke_color = 2;</code>
     *
     * @return Whether the strokeColor field is set.
     */
    public boolean hasStrokeColor() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     *
     *
     * <pre>
     * The colors to use when the type is `BORDER_TYPE_STROKE`.
     * </pre>
     *
     * <code>.google.type.Color stroke_color = 2;</code>
     *
     * @return The strokeColor.
     */
    public com.google.type.Color getStrokeColor() {
      if (strokeColorBuilder_ == null) {
        return strokeColor_ == null ? com.google.type.Color.getDefaultInstance() : strokeColor_;
      } else {
        return strokeColorBuilder_.getMessage();
      }
    }
    /**
     *
     *
     * <pre>
     * The colors to use when the type is `BORDER_TYPE_STROKE`.
     * </pre>
     *
     * <code>.google.type.Color stroke_color = 2;</code>
     */
    public Builder setStrokeColor(com.google.type.Color value) {
      if (strokeColorBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        strokeColor_ = value;
      } else {
        strokeColorBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * The colors to use when the type is `BORDER_TYPE_STROKE`.
     * </pre>
     *
     * <code>.google.type.Color stroke_color = 2;</code>
     */
    public Builder setStrokeColor(com.google.type.Color.Builder builderForValue) {
      if (strokeColorBuilder_ == null) {
        strokeColor_ = builderForValue.build();
      } else {
        strokeColorBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * The colors to use when the type is `BORDER_TYPE_STROKE`.
     * </pre>
     *
     * <code>.google.type.Color stroke_color = 2;</code>
     */
    public Builder mergeStrokeColor(com.google.type.Color value) {
      if (strokeColorBuilder_ == null) {
        if (((bitField0_ & 0x00000002) != 0)
            && strokeColor_ != null
            && strokeColor_ != com.google.type.Color.getDefaultInstance()) {
          getStrokeColorBuilder().mergeFrom(value);
        } else {
          strokeColor_ = value;
        }
      } else {
        strokeColorBuilder_.mergeFrom(value);
      }
      if (strokeColor_ != null) {
        bitField0_ |= 0x00000002;
        onChanged();
      }
      return this;
    }
    /**
     *
     *
     * <pre>
     * The colors to use when the type is `BORDER_TYPE_STROKE`.
     * </pre>
     *
     * <code>.google.type.Color stroke_color = 2;</code>
     */
    public Builder clearStrokeColor() {
      bitField0_ = (bitField0_ & ~0x00000002);
      strokeColor_ = null;
      if (strokeColorBuilder_ != null) {
        strokeColorBuilder_.dispose();
        strokeColorBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * The colors to use when the type is `BORDER_TYPE_STROKE`.
     * </pre>
     *
     * <code>.google.type.Color stroke_color = 2;</code>
     */
    public com.google.type.Color.Builder getStrokeColorBuilder() {
      bitField0_ |= 0x00000002;
      onChanged();
      return getStrokeColorFieldBuilder().getBuilder();
    }
    /**
     *
     *
     * <pre>
     * The colors to use when the type is `BORDER_TYPE_STROKE`.
     * </pre>
     *
     * <code>.google.type.Color stroke_color = 2;</code>
     */
    public com.google.type.ColorOrBuilder getStrokeColorOrBuilder() {
      if (strokeColorBuilder_ != null) {
        return strokeColorBuilder_.getMessageOrBuilder();
      } else {
        return strokeColor_ == null ? com.google.type.Color.getDefaultInstance() : strokeColor_;
      }
    }
    /**
     *
     *
     * <pre>
     * The colors to use when the type is `BORDER_TYPE_STROKE`.
     * </pre>
     *
     * <code>.google.type.Color stroke_color = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
            com.google.type.Color, com.google.type.Color.Builder, com.google.type.ColorOrBuilder>
        getStrokeColorFieldBuilder() {
      if (strokeColorBuilder_ == null) {
        strokeColorBuilder_ =
            new com.google.protobuf.SingleFieldBuilderV3<
                com.google.type.Color,
                com.google.type.Color.Builder,
                com.google.type.ColorOrBuilder>(
                getStrokeColor(), getParentForChildren(), isClean());
        strokeColor_ = null;
      }
      return strokeColorBuilder_;
    }

    private int cornerRadius_;
    /**
     *
     *
     * <pre>
     * The corner radius for the border.
     * </pre>
     *
     * <code>int32 corner_radius = 3;</code>
     *
     * @return The cornerRadius.
     */
    @java.lang.Override
    public int getCornerRadius() {
      return cornerRadius_;
    }
    /**
     *
     *
     * <pre>
     * The corner radius for the border.
     * </pre>
     *
     * <code>int32 corner_radius = 3;</code>
     *
     * @param value The cornerRadius to set.
     * @return This builder for chaining.
     */
    public Builder setCornerRadius(int value) {

      cornerRadius_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * The corner radius for the border.
     * </pre>
     *
     * <code>int32 corner_radius = 3;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearCornerRadius() {
      bitField0_ = (bitField0_ & ~0x00000004);
      cornerRadius_ = 0;
      onChanged();
      return this;
    }

    @java.lang.Override
    public final Builder setUnknownFields(final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }

    // @@protoc_insertion_point(builder_scope:google.apps.card.v1.BorderStyle)
  }

  // @@protoc_insertion_point(class_scope:google.apps.card.v1.BorderStyle)
  private static final com.google.apps.card.v1.BorderStyle DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new com.google.apps.card.v1.BorderStyle();
  }

  public static com.google.apps.card.v1.BorderStyle getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<BorderStyle> PARSER =
      new com.google.protobuf.AbstractParser<BorderStyle>() {
        @java.lang.Override
        public BorderStyle parsePartialFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
          Builder builder = newBuilder();
          try {
            builder.mergeFrom(input, extensionRegistry);
          } catch (com.google.protobuf.InvalidProtocolBufferException e) {
            throw e.setUnfinishedMessage(builder.buildPartial());
          } catch (com.google.protobuf.UninitializedMessageException e) {
            throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
          } catch (java.io.IOException e) {
            throw new com.google.protobuf.InvalidProtocolBufferException(e)
                .setUnfinishedMessage(builder.buildPartial());
          }
          return builder.buildPartial();
        }
      };

  public static com.google.protobuf.Parser<BorderStyle> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<BorderStyle> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.apps.card.v1.BorderStyle getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
}