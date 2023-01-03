// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: schema/google/showcase/v1beta1/compliance.proto

package com.google.showcase.v1beta1;

/**
 * <pre>
 * ComplianceSuite contains a set of requests that microgenerators should issue
 * over REST to the Compliance service to test their gRPC-to-REST transcoding
 * implementation.
 * </pre>
 *
 * Protobuf type {@code google.showcase.v1beta1.ComplianceSuite}
 */
public final class ComplianceSuite extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:google.showcase.v1beta1.ComplianceSuite)
    ComplianceSuiteOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ComplianceSuite.newBuilder() to construct.
  private ComplianceSuite(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ComplianceSuite() {
    group_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new ComplianceSuite();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ComplianceSuite(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              group_ = new java.util.ArrayList<com.google.showcase.v1beta1.ComplianceGroup>();
              mutable_bitField0_ |= 0x00000001;
            }
            group_.add(
                input.readMessage(com.google.showcase.v1beta1.ComplianceGroup.parser(), extensionRegistry));
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (com.google.protobuf.UninitializedMessageException e) {
      throw e.asInvalidProtocolBufferException().setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        group_ = java.util.Collections.unmodifiableList(group_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.google.showcase.v1beta1.ComplianceOuterClass.internal_static_google_showcase_v1beta1_ComplianceSuite_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.google.showcase.v1beta1.ComplianceOuterClass.internal_static_google_showcase_v1beta1_ComplianceSuite_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.google.showcase.v1beta1.ComplianceSuite.class, com.google.showcase.v1beta1.ComplianceSuite.Builder.class);
  }

  public static final int GROUP_FIELD_NUMBER = 1;
  private java.util.List<com.google.showcase.v1beta1.ComplianceGroup> group_;
  /**
   * <code>repeated .google.showcase.v1beta1.ComplianceGroup group = 1;</code>
   */
  @java.lang.Override
  public java.util.List<com.google.showcase.v1beta1.ComplianceGroup> getGroupList() {
    return group_;
  }
  /**
   * <code>repeated .google.showcase.v1beta1.ComplianceGroup group = 1;</code>
   */
  @java.lang.Override
  public java.util.List<? extends com.google.showcase.v1beta1.ComplianceGroupOrBuilder> 
      getGroupOrBuilderList() {
    return group_;
  }
  /**
   * <code>repeated .google.showcase.v1beta1.ComplianceGroup group = 1;</code>
   */
  @java.lang.Override
  public int getGroupCount() {
    return group_.size();
  }
  /**
   * <code>repeated .google.showcase.v1beta1.ComplianceGroup group = 1;</code>
   */
  @java.lang.Override
  public com.google.showcase.v1beta1.ComplianceGroup getGroup(int index) {
    return group_.get(index);
  }
  /**
   * <code>repeated .google.showcase.v1beta1.ComplianceGroup group = 1;</code>
   */
  @java.lang.Override
  public com.google.showcase.v1beta1.ComplianceGroupOrBuilder getGroupOrBuilder(
      int index) {
    return group_.get(index);
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
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < group_.size(); i++) {
      output.writeMessage(1, group_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < group_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, group_.get(i));
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.google.showcase.v1beta1.ComplianceSuite)) {
      return super.equals(obj);
    }
    com.google.showcase.v1beta1.ComplianceSuite other = (com.google.showcase.v1beta1.ComplianceSuite) obj;

    if (!getGroupList()
        .equals(other.getGroupList())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getGroupCount() > 0) {
      hash = (37 * hash) + GROUP_FIELD_NUMBER;
      hash = (53 * hash) + getGroupList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.google.showcase.v1beta1.ComplianceSuite parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.showcase.v1beta1.ComplianceSuite parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.showcase.v1beta1.ComplianceSuite parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.showcase.v1beta1.ComplianceSuite parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.showcase.v1beta1.ComplianceSuite parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.showcase.v1beta1.ComplianceSuite parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.showcase.v1beta1.ComplianceSuite parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.google.showcase.v1beta1.ComplianceSuite parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.google.showcase.v1beta1.ComplianceSuite parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.google.showcase.v1beta1.ComplianceSuite parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.google.showcase.v1beta1.ComplianceSuite parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.google.showcase.v1beta1.ComplianceSuite parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.google.showcase.v1beta1.ComplianceSuite prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * ComplianceSuite contains a set of requests that microgenerators should issue
   * over REST to the Compliance service to test their gRPC-to-REST transcoding
   * implementation.
   * </pre>
   *
   * Protobuf type {@code google.showcase.v1beta1.ComplianceSuite}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:google.showcase.v1beta1.ComplianceSuite)
      com.google.showcase.v1beta1.ComplianceSuiteOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.google.showcase.v1beta1.ComplianceOuterClass.internal_static_google_showcase_v1beta1_ComplianceSuite_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.google.showcase.v1beta1.ComplianceOuterClass.internal_static_google_showcase_v1beta1_ComplianceSuite_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.google.showcase.v1beta1.ComplianceSuite.class, com.google.showcase.v1beta1.ComplianceSuite.Builder.class);
    }

    // Construct using com.google.showcase.v1beta1.ComplianceSuite.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getGroupFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (groupBuilder_ == null) {
        group_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        groupBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.google.showcase.v1beta1.ComplianceOuterClass.internal_static_google_showcase_v1beta1_ComplianceSuite_descriptor;
    }

    @java.lang.Override
    public com.google.showcase.v1beta1.ComplianceSuite getDefaultInstanceForType() {
      return com.google.showcase.v1beta1.ComplianceSuite.getDefaultInstance();
    }

    @java.lang.Override
    public com.google.showcase.v1beta1.ComplianceSuite build() {
      com.google.showcase.v1beta1.ComplianceSuite result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.google.showcase.v1beta1.ComplianceSuite buildPartial() {
      com.google.showcase.v1beta1.ComplianceSuite result = new com.google.showcase.v1beta1.ComplianceSuite(this);
      int from_bitField0_ = bitField0_;
      if (groupBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          group_ = java.util.Collections.unmodifiableList(group_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.group_ = group_;
      } else {
        result.group_ = groupBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.google.showcase.v1beta1.ComplianceSuite) {
        return mergeFrom((com.google.showcase.v1beta1.ComplianceSuite)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.google.showcase.v1beta1.ComplianceSuite other) {
      if (other == com.google.showcase.v1beta1.ComplianceSuite.getDefaultInstance()) return this;
      if (groupBuilder_ == null) {
        if (!other.group_.isEmpty()) {
          if (group_.isEmpty()) {
            group_ = other.group_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureGroupIsMutable();
            group_.addAll(other.group_);
          }
          onChanged();
        }
      } else {
        if (!other.group_.isEmpty()) {
          if (groupBuilder_.isEmpty()) {
            groupBuilder_.dispose();
            groupBuilder_ = null;
            group_ = other.group_;
            bitField0_ = (bitField0_ & ~0x00000001);
            groupBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getGroupFieldBuilder() : null;
          } else {
            groupBuilder_.addAllMessages(other.group_);
          }
        }
      }
      this.mergeUnknownFields(other.unknownFields);
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
      com.google.showcase.v1beta1.ComplianceSuite parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.google.showcase.v1beta1.ComplianceSuite) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<com.google.showcase.v1beta1.ComplianceGroup> group_ =
      java.util.Collections.emptyList();
    private void ensureGroupIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        group_ = new java.util.ArrayList<com.google.showcase.v1beta1.ComplianceGroup>(group_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.google.showcase.v1beta1.ComplianceGroup, com.google.showcase.v1beta1.ComplianceGroup.Builder, com.google.showcase.v1beta1.ComplianceGroupOrBuilder> groupBuilder_;

    /**
     * <code>repeated .google.showcase.v1beta1.ComplianceGroup group = 1;</code>
     */
    public java.util.List<com.google.showcase.v1beta1.ComplianceGroup> getGroupList() {
      if (groupBuilder_ == null) {
        return java.util.Collections.unmodifiableList(group_);
      } else {
        return groupBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .google.showcase.v1beta1.ComplianceGroup group = 1;</code>
     */
    public int getGroupCount() {
      if (groupBuilder_ == null) {
        return group_.size();
      } else {
        return groupBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .google.showcase.v1beta1.ComplianceGroup group = 1;</code>
     */
    public com.google.showcase.v1beta1.ComplianceGroup getGroup(int index) {
      if (groupBuilder_ == null) {
        return group_.get(index);
      } else {
        return groupBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .google.showcase.v1beta1.ComplianceGroup group = 1;</code>
     */
    public Builder setGroup(
        int index, com.google.showcase.v1beta1.ComplianceGroup value) {
      if (groupBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureGroupIsMutable();
        group_.set(index, value);
        onChanged();
      } else {
        groupBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .google.showcase.v1beta1.ComplianceGroup group = 1;</code>
     */
    public Builder setGroup(
        int index, com.google.showcase.v1beta1.ComplianceGroup.Builder builderForValue) {
      if (groupBuilder_ == null) {
        ensureGroupIsMutable();
        group_.set(index, builderForValue.build());
        onChanged();
      } else {
        groupBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .google.showcase.v1beta1.ComplianceGroup group = 1;</code>
     */
    public Builder addGroup(com.google.showcase.v1beta1.ComplianceGroup value) {
      if (groupBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureGroupIsMutable();
        group_.add(value);
        onChanged();
      } else {
        groupBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .google.showcase.v1beta1.ComplianceGroup group = 1;</code>
     */
    public Builder addGroup(
        int index, com.google.showcase.v1beta1.ComplianceGroup value) {
      if (groupBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureGroupIsMutable();
        group_.add(index, value);
        onChanged();
      } else {
        groupBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .google.showcase.v1beta1.ComplianceGroup group = 1;</code>
     */
    public Builder addGroup(
        com.google.showcase.v1beta1.ComplianceGroup.Builder builderForValue) {
      if (groupBuilder_ == null) {
        ensureGroupIsMutable();
        group_.add(builderForValue.build());
        onChanged();
      } else {
        groupBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .google.showcase.v1beta1.ComplianceGroup group = 1;</code>
     */
    public Builder addGroup(
        int index, com.google.showcase.v1beta1.ComplianceGroup.Builder builderForValue) {
      if (groupBuilder_ == null) {
        ensureGroupIsMutable();
        group_.add(index, builderForValue.build());
        onChanged();
      } else {
        groupBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .google.showcase.v1beta1.ComplianceGroup group = 1;</code>
     */
    public Builder addAllGroup(
        java.lang.Iterable<? extends com.google.showcase.v1beta1.ComplianceGroup> values) {
      if (groupBuilder_ == null) {
        ensureGroupIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, group_);
        onChanged();
      } else {
        groupBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .google.showcase.v1beta1.ComplianceGroup group = 1;</code>
     */
    public Builder clearGroup() {
      if (groupBuilder_ == null) {
        group_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        groupBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .google.showcase.v1beta1.ComplianceGroup group = 1;</code>
     */
    public Builder removeGroup(int index) {
      if (groupBuilder_ == null) {
        ensureGroupIsMutable();
        group_.remove(index);
        onChanged();
      } else {
        groupBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .google.showcase.v1beta1.ComplianceGroup group = 1;</code>
     */
    public com.google.showcase.v1beta1.ComplianceGroup.Builder getGroupBuilder(
        int index) {
      return getGroupFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .google.showcase.v1beta1.ComplianceGroup group = 1;</code>
     */
    public com.google.showcase.v1beta1.ComplianceGroupOrBuilder getGroupOrBuilder(
        int index) {
      if (groupBuilder_ == null) {
        return group_.get(index);  } else {
        return groupBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .google.showcase.v1beta1.ComplianceGroup group = 1;</code>
     */
    public java.util.List<? extends com.google.showcase.v1beta1.ComplianceGroupOrBuilder> 
         getGroupOrBuilderList() {
      if (groupBuilder_ != null) {
        return groupBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(group_);
      }
    }
    /**
     * <code>repeated .google.showcase.v1beta1.ComplianceGroup group = 1;</code>
     */
    public com.google.showcase.v1beta1.ComplianceGroup.Builder addGroupBuilder() {
      return getGroupFieldBuilder().addBuilder(
          com.google.showcase.v1beta1.ComplianceGroup.getDefaultInstance());
    }
    /**
     * <code>repeated .google.showcase.v1beta1.ComplianceGroup group = 1;</code>
     */
    public com.google.showcase.v1beta1.ComplianceGroup.Builder addGroupBuilder(
        int index) {
      return getGroupFieldBuilder().addBuilder(
          index, com.google.showcase.v1beta1.ComplianceGroup.getDefaultInstance());
    }
    /**
     * <code>repeated .google.showcase.v1beta1.ComplianceGroup group = 1;</code>
     */
    public java.util.List<com.google.showcase.v1beta1.ComplianceGroup.Builder> 
         getGroupBuilderList() {
      return getGroupFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.google.showcase.v1beta1.ComplianceGroup, com.google.showcase.v1beta1.ComplianceGroup.Builder, com.google.showcase.v1beta1.ComplianceGroupOrBuilder> 
        getGroupFieldBuilder() {
      if (groupBuilder_ == null) {
        groupBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.google.showcase.v1beta1.ComplianceGroup, com.google.showcase.v1beta1.ComplianceGroup.Builder, com.google.showcase.v1beta1.ComplianceGroupOrBuilder>(
                group_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        group_ = null;
      }
      return groupBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:google.showcase.v1beta1.ComplianceSuite)
  }

  // @@protoc_insertion_point(class_scope:google.showcase.v1beta1.ComplianceSuite)
  private static final com.google.showcase.v1beta1.ComplianceSuite DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.google.showcase.v1beta1.ComplianceSuite();
  }

  public static com.google.showcase.v1beta1.ComplianceSuite getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ComplianceSuite>
      PARSER = new com.google.protobuf.AbstractParser<ComplianceSuite>() {
    @java.lang.Override
    public ComplianceSuite parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ComplianceSuite(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ComplianceSuite> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ComplianceSuite> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.showcase.v1beta1.ComplianceSuite getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
