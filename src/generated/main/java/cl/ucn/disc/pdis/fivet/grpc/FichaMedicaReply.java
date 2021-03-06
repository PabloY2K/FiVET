// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: fivet.proto

package cl.ucn.disc.pdis.fivet.grpc;

/**
 * Protobuf type {@code FichaMedicaReply}
 */
public final class FichaMedicaReply extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:FichaMedicaReply)
    FichaMedicaReplyOrBuilder {
private static final long serialVersionUID = 0L;
  // Use FichaMedicaReply.newBuilder() to construct.
  private FichaMedicaReply(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private FichaMedicaReply() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new FichaMedicaReply();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private FichaMedicaReply(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
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
            cl.ucn.disc.pdis.fivet.grpc.FichaMedicaEntity.Builder subBuilder = null;
            if (fichaMedica_ != null) {
              subBuilder = fichaMedica_.toBuilder();
            }
            fichaMedica_ = input.readMessage(cl.ucn.disc.pdis.fivet.grpc.FichaMedicaEntity.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(fichaMedica_);
              fichaMedica_ = subBuilder.buildPartial();
            }

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
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return cl.ucn.disc.pdis.fivet.grpc.Fivet.internal_static_FichaMedicaReply_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return cl.ucn.disc.pdis.fivet.grpc.Fivet.internal_static_FichaMedicaReply_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            cl.ucn.disc.pdis.fivet.grpc.FichaMedicaReply.class, cl.ucn.disc.pdis.fivet.grpc.FichaMedicaReply.Builder.class);
  }

  public static final int FICHA_MEDICA_FIELD_NUMBER = 1;
  private cl.ucn.disc.pdis.fivet.grpc.FichaMedicaEntity fichaMedica_;
  /**
   * <code>.FichaMedicaEntity ficha_medica = 1;</code>
   * @return Whether the fichaMedica field is set.
   */
  @java.lang.Override
  public boolean hasFichaMedica() {
    return fichaMedica_ != null;
  }
  /**
   * <code>.FichaMedicaEntity ficha_medica = 1;</code>
   * @return The fichaMedica.
   */
  @java.lang.Override
  public cl.ucn.disc.pdis.fivet.grpc.FichaMedicaEntity getFichaMedica() {
    return fichaMedica_ == null ? cl.ucn.disc.pdis.fivet.grpc.FichaMedicaEntity.getDefaultInstance() : fichaMedica_;
  }
  /**
   * <code>.FichaMedicaEntity ficha_medica = 1;</code>
   */
  @java.lang.Override
  public cl.ucn.disc.pdis.fivet.grpc.FichaMedicaEntityOrBuilder getFichaMedicaOrBuilder() {
    return getFichaMedica();
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
    if (fichaMedica_ != null) {
      output.writeMessage(1, getFichaMedica());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (fichaMedica_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getFichaMedica());
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
    if (!(obj instanceof cl.ucn.disc.pdis.fivet.grpc.FichaMedicaReply)) {
      return super.equals(obj);
    }
    cl.ucn.disc.pdis.fivet.grpc.FichaMedicaReply other = (cl.ucn.disc.pdis.fivet.grpc.FichaMedicaReply) obj;

    if (hasFichaMedica() != other.hasFichaMedica()) return false;
    if (hasFichaMedica()) {
      if (!getFichaMedica()
          .equals(other.getFichaMedica())) return false;
    }
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
    if (hasFichaMedica()) {
      hash = (37 * hash) + FICHA_MEDICA_FIELD_NUMBER;
      hash = (53 * hash) + getFichaMedica().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static cl.ucn.disc.pdis.fivet.grpc.FichaMedicaReply parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cl.ucn.disc.pdis.fivet.grpc.FichaMedicaReply parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cl.ucn.disc.pdis.fivet.grpc.FichaMedicaReply parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cl.ucn.disc.pdis.fivet.grpc.FichaMedicaReply parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cl.ucn.disc.pdis.fivet.grpc.FichaMedicaReply parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cl.ucn.disc.pdis.fivet.grpc.FichaMedicaReply parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cl.ucn.disc.pdis.fivet.grpc.FichaMedicaReply parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cl.ucn.disc.pdis.fivet.grpc.FichaMedicaReply parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static cl.ucn.disc.pdis.fivet.grpc.FichaMedicaReply parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static cl.ucn.disc.pdis.fivet.grpc.FichaMedicaReply parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static cl.ucn.disc.pdis.fivet.grpc.FichaMedicaReply parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cl.ucn.disc.pdis.fivet.grpc.FichaMedicaReply parseFrom(
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
  public static Builder newBuilder(cl.ucn.disc.pdis.fivet.grpc.FichaMedicaReply prototype) {
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
   * Protobuf type {@code FichaMedicaReply}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:FichaMedicaReply)
      cl.ucn.disc.pdis.fivet.grpc.FichaMedicaReplyOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return cl.ucn.disc.pdis.fivet.grpc.Fivet.internal_static_FichaMedicaReply_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return cl.ucn.disc.pdis.fivet.grpc.Fivet.internal_static_FichaMedicaReply_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              cl.ucn.disc.pdis.fivet.grpc.FichaMedicaReply.class, cl.ucn.disc.pdis.fivet.grpc.FichaMedicaReply.Builder.class);
    }

    // Construct using cl.ucn.disc.pdis.fivet.grpc.FichaMedicaReply.newBuilder()
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
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (fichaMedicaBuilder_ == null) {
        fichaMedica_ = null;
      } else {
        fichaMedica_ = null;
        fichaMedicaBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return cl.ucn.disc.pdis.fivet.grpc.Fivet.internal_static_FichaMedicaReply_descriptor;
    }

    @java.lang.Override
    public cl.ucn.disc.pdis.fivet.grpc.FichaMedicaReply getDefaultInstanceForType() {
      return cl.ucn.disc.pdis.fivet.grpc.FichaMedicaReply.getDefaultInstance();
    }

    @java.lang.Override
    public cl.ucn.disc.pdis.fivet.grpc.FichaMedicaReply build() {
      cl.ucn.disc.pdis.fivet.grpc.FichaMedicaReply result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public cl.ucn.disc.pdis.fivet.grpc.FichaMedicaReply buildPartial() {
      cl.ucn.disc.pdis.fivet.grpc.FichaMedicaReply result = new cl.ucn.disc.pdis.fivet.grpc.FichaMedicaReply(this);
      if (fichaMedicaBuilder_ == null) {
        result.fichaMedica_ = fichaMedica_;
      } else {
        result.fichaMedica_ = fichaMedicaBuilder_.build();
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
      if (other instanceof cl.ucn.disc.pdis.fivet.grpc.FichaMedicaReply) {
        return mergeFrom((cl.ucn.disc.pdis.fivet.grpc.FichaMedicaReply)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(cl.ucn.disc.pdis.fivet.grpc.FichaMedicaReply other) {
      if (other == cl.ucn.disc.pdis.fivet.grpc.FichaMedicaReply.getDefaultInstance()) return this;
      if (other.hasFichaMedica()) {
        mergeFichaMedica(other.getFichaMedica());
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
      cl.ucn.disc.pdis.fivet.grpc.FichaMedicaReply parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (cl.ucn.disc.pdis.fivet.grpc.FichaMedicaReply) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private cl.ucn.disc.pdis.fivet.grpc.FichaMedicaEntity fichaMedica_;
    private com.google.protobuf.SingleFieldBuilderV3<
        cl.ucn.disc.pdis.fivet.grpc.FichaMedicaEntity, cl.ucn.disc.pdis.fivet.grpc.FichaMedicaEntity.Builder, cl.ucn.disc.pdis.fivet.grpc.FichaMedicaEntityOrBuilder> fichaMedicaBuilder_;
    /**
     * <code>.FichaMedicaEntity ficha_medica = 1;</code>
     * @return Whether the fichaMedica field is set.
     */
    public boolean hasFichaMedica() {
      return fichaMedicaBuilder_ != null || fichaMedica_ != null;
    }
    /**
     * <code>.FichaMedicaEntity ficha_medica = 1;</code>
     * @return The fichaMedica.
     */
    public cl.ucn.disc.pdis.fivet.grpc.FichaMedicaEntity getFichaMedica() {
      if (fichaMedicaBuilder_ == null) {
        return fichaMedica_ == null ? cl.ucn.disc.pdis.fivet.grpc.FichaMedicaEntity.getDefaultInstance() : fichaMedica_;
      } else {
        return fichaMedicaBuilder_.getMessage();
      }
    }
    /**
     * <code>.FichaMedicaEntity ficha_medica = 1;</code>
     */
    public Builder setFichaMedica(cl.ucn.disc.pdis.fivet.grpc.FichaMedicaEntity value) {
      if (fichaMedicaBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        fichaMedica_ = value;
        onChanged();
      } else {
        fichaMedicaBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.FichaMedicaEntity ficha_medica = 1;</code>
     */
    public Builder setFichaMedica(
        cl.ucn.disc.pdis.fivet.grpc.FichaMedicaEntity.Builder builderForValue) {
      if (fichaMedicaBuilder_ == null) {
        fichaMedica_ = builderForValue.build();
        onChanged();
      } else {
        fichaMedicaBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.FichaMedicaEntity ficha_medica = 1;</code>
     */
    public Builder mergeFichaMedica(cl.ucn.disc.pdis.fivet.grpc.FichaMedicaEntity value) {
      if (fichaMedicaBuilder_ == null) {
        if (fichaMedica_ != null) {
          fichaMedica_ =
            cl.ucn.disc.pdis.fivet.grpc.FichaMedicaEntity.newBuilder(fichaMedica_).mergeFrom(value).buildPartial();
        } else {
          fichaMedica_ = value;
        }
        onChanged();
      } else {
        fichaMedicaBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.FichaMedicaEntity ficha_medica = 1;</code>
     */
    public Builder clearFichaMedica() {
      if (fichaMedicaBuilder_ == null) {
        fichaMedica_ = null;
        onChanged();
      } else {
        fichaMedica_ = null;
        fichaMedicaBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.FichaMedicaEntity ficha_medica = 1;</code>
     */
    public cl.ucn.disc.pdis.fivet.grpc.FichaMedicaEntity.Builder getFichaMedicaBuilder() {
      
      onChanged();
      return getFichaMedicaFieldBuilder().getBuilder();
    }
    /**
     * <code>.FichaMedicaEntity ficha_medica = 1;</code>
     */
    public cl.ucn.disc.pdis.fivet.grpc.FichaMedicaEntityOrBuilder getFichaMedicaOrBuilder() {
      if (fichaMedicaBuilder_ != null) {
        return fichaMedicaBuilder_.getMessageOrBuilder();
      } else {
        return fichaMedica_ == null ?
            cl.ucn.disc.pdis.fivet.grpc.FichaMedicaEntity.getDefaultInstance() : fichaMedica_;
      }
    }
    /**
     * <code>.FichaMedicaEntity ficha_medica = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        cl.ucn.disc.pdis.fivet.grpc.FichaMedicaEntity, cl.ucn.disc.pdis.fivet.grpc.FichaMedicaEntity.Builder, cl.ucn.disc.pdis.fivet.grpc.FichaMedicaEntityOrBuilder> 
        getFichaMedicaFieldBuilder() {
      if (fichaMedicaBuilder_ == null) {
        fichaMedicaBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            cl.ucn.disc.pdis.fivet.grpc.FichaMedicaEntity, cl.ucn.disc.pdis.fivet.grpc.FichaMedicaEntity.Builder, cl.ucn.disc.pdis.fivet.grpc.FichaMedicaEntityOrBuilder>(
                getFichaMedica(),
                getParentForChildren(),
                isClean());
        fichaMedica_ = null;
      }
      return fichaMedicaBuilder_;
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


    // @@protoc_insertion_point(builder_scope:FichaMedicaReply)
  }

  // @@protoc_insertion_point(class_scope:FichaMedicaReply)
  private static final cl.ucn.disc.pdis.fivet.grpc.FichaMedicaReply DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new cl.ucn.disc.pdis.fivet.grpc.FichaMedicaReply();
  }

  public static cl.ucn.disc.pdis.fivet.grpc.FichaMedicaReply getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<FichaMedicaReply>
      PARSER = new com.google.protobuf.AbstractParser<FichaMedicaReply>() {
    @java.lang.Override
    public FichaMedicaReply parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new FichaMedicaReply(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<FichaMedicaReply> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<FichaMedicaReply> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public cl.ucn.disc.pdis.fivet.grpc.FichaMedicaReply getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

