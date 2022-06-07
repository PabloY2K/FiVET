// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: fivet.proto

package cl.ucn.disc.pdis.fivet.grpc;

/**
 * Protobuf type {@code ControlEntity}
 */
public final class ControlEntity extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:ControlEntity)
    ControlEntityOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ControlEntity.newBuilder() to construct.
  private ControlEntity(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ControlEntity() {
    fecha_ = "";
    diagnostico_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new ControlEntity();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ControlEntity(
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
            java.lang.String s = input.readStringRequireUtf8();

            fecha_ = s;
            break;
          }
          case 17: {

            temperatura_ = input.readDouble();
            break;
          }
          case 25: {

            peso_ = input.readDouble();
            break;
          }
          case 33: {

            altura_ = input.readDouble();
            break;
          }
          case 42: {
            java.lang.String s = input.readStringRequireUtf8();

            diagnostico_ = s;
            break;
          }
          case 50: {
            cl.ucn.disc.pdis.fivet.grpc.PersonaEntity.Builder subBuilder = null;
            if (veterinario_ != null) {
              subBuilder = veterinario_.toBuilder();
            }
            veterinario_ = input.readMessage(cl.ucn.disc.pdis.fivet.grpc.PersonaEntity.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(veterinario_);
              veterinario_ = subBuilder.buildPartial();
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
    return cl.ucn.disc.pdis.fivet.grpc.Fivet.internal_static_ControlEntity_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return cl.ucn.disc.pdis.fivet.grpc.Fivet.internal_static_ControlEntity_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            cl.ucn.disc.pdis.fivet.grpc.ControlEntity.class, cl.ucn.disc.pdis.fivet.grpc.ControlEntity.Builder.class);
  }

  public static final int FECHA_FIELD_NUMBER = 1;
  private volatile java.lang.Object fecha_;
  /**
   * <code>string fecha = 1;</code>
   * @return The fecha.
   */
  @java.lang.Override
  public java.lang.String getFecha() {
    java.lang.Object ref = fecha_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      fecha_ = s;
      return s;
    }
  }
  /**
   * <code>string fecha = 1;</code>
   * @return The bytes for fecha.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getFechaBytes() {
    java.lang.Object ref = fecha_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      fecha_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int TEMPERATURA_FIELD_NUMBER = 2;
  private double temperatura_;
  /**
   * <code>double temperatura = 2;</code>
   * @return The temperatura.
   */
  @java.lang.Override
  public double getTemperatura() {
    return temperatura_;
  }

  public static final int PESO_FIELD_NUMBER = 3;
  private double peso_;
  /**
   * <code>double peso = 3;</code>
   * @return The peso.
   */
  @java.lang.Override
  public double getPeso() {
    return peso_;
  }

  public static final int ALTURA_FIELD_NUMBER = 4;
  private double altura_;
  /**
   * <code>double altura = 4;</code>
   * @return The altura.
   */
  @java.lang.Override
  public double getAltura() {
    return altura_;
  }

  public static final int DIAGNOSTICO_FIELD_NUMBER = 5;
  private volatile java.lang.Object diagnostico_;
  /**
   * <code>string diagnostico = 5;</code>
   * @return The diagnostico.
   */
  @java.lang.Override
  public java.lang.String getDiagnostico() {
    java.lang.Object ref = diagnostico_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      diagnostico_ = s;
      return s;
    }
  }
  /**
   * <code>string diagnostico = 5;</code>
   * @return The bytes for diagnostico.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getDiagnosticoBytes() {
    java.lang.Object ref = diagnostico_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      diagnostico_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int VETERINARIO_FIELD_NUMBER = 6;
  private cl.ucn.disc.pdis.fivet.grpc.PersonaEntity veterinario_;
  /**
   * <code>.PersonaEntity veterinario = 6;</code>
   * @return Whether the veterinario field is set.
   */
  @java.lang.Override
  public boolean hasVeterinario() {
    return veterinario_ != null;
  }
  /**
   * <code>.PersonaEntity veterinario = 6;</code>
   * @return The veterinario.
   */
  @java.lang.Override
  public cl.ucn.disc.pdis.fivet.grpc.PersonaEntity getVeterinario() {
    return veterinario_ == null ? cl.ucn.disc.pdis.fivet.grpc.PersonaEntity.getDefaultInstance() : veterinario_;
  }
  /**
   * <code>.PersonaEntity veterinario = 6;</code>
   */
  @java.lang.Override
  public cl.ucn.disc.pdis.fivet.grpc.PersonaEntityOrBuilder getVeterinarioOrBuilder() {
    return getVeterinario();
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
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(fecha_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, fecha_);
    }
    if (java.lang.Double.doubleToRawLongBits(temperatura_) != 0) {
      output.writeDouble(2, temperatura_);
    }
    if (java.lang.Double.doubleToRawLongBits(peso_) != 0) {
      output.writeDouble(3, peso_);
    }
    if (java.lang.Double.doubleToRawLongBits(altura_) != 0) {
      output.writeDouble(4, altura_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(diagnostico_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 5, diagnostico_);
    }
    if (veterinario_ != null) {
      output.writeMessage(6, getVeterinario());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(fecha_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, fecha_);
    }
    if (java.lang.Double.doubleToRawLongBits(temperatura_) != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(2, temperatura_);
    }
    if (java.lang.Double.doubleToRawLongBits(peso_) != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(3, peso_);
    }
    if (java.lang.Double.doubleToRawLongBits(altura_) != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(4, altura_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(diagnostico_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, diagnostico_);
    }
    if (veterinario_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(6, getVeterinario());
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
    if (!(obj instanceof cl.ucn.disc.pdis.fivet.grpc.ControlEntity)) {
      return super.equals(obj);
    }
    cl.ucn.disc.pdis.fivet.grpc.ControlEntity other = (cl.ucn.disc.pdis.fivet.grpc.ControlEntity) obj;

    if (!getFecha()
        .equals(other.getFecha())) return false;
    if (java.lang.Double.doubleToLongBits(getTemperatura())
        != java.lang.Double.doubleToLongBits(
            other.getTemperatura())) return false;
    if (java.lang.Double.doubleToLongBits(getPeso())
        != java.lang.Double.doubleToLongBits(
            other.getPeso())) return false;
    if (java.lang.Double.doubleToLongBits(getAltura())
        != java.lang.Double.doubleToLongBits(
            other.getAltura())) return false;
    if (!getDiagnostico()
        .equals(other.getDiagnostico())) return false;
    if (hasVeterinario() != other.hasVeterinario()) return false;
    if (hasVeterinario()) {
      if (!getVeterinario()
          .equals(other.getVeterinario())) return false;
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
    hash = (37 * hash) + FECHA_FIELD_NUMBER;
    hash = (53 * hash) + getFecha().hashCode();
    hash = (37 * hash) + TEMPERATURA_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getTemperatura()));
    hash = (37 * hash) + PESO_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getPeso()));
    hash = (37 * hash) + ALTURA_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getAltura()));
    hash = (37 * hash) + DIAGNOSTICO_FIELD_NUMBER;
    hash = (53 * hash) + getDiagnostico().hashCode();
    if (hasVeterinario()) {
      hash = (37 * hash) + VETERINARIO_FIELD_NUMBER;
      hash = (53 * hash) + getVeterinario().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static cl.ucn.disc.pdis.fivet.grpc.ControlEntity parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cl.ucn.disc.pdis.fivet.grpc.ControlEntity parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cl.ucn.disc.pdis.fivet.grpc.ControlEntity parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cl.ucn.disc.pdis.fivet.grpc.ControlEntity parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cl.ucn.disc.pdis.fivet.grpc.ControlEntity parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static cl.ucn.disc.pdis.fivet.grpc.ControlEntity parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static cl.ucn.disc.pdis.fivet.grpc.ControlEntity parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cl.ucn.disc.pdis.fivet.grpc.ControlEntity parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static cl.ucn.disc.pdis.fivet.grpc.ControlEntity parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static cl.ucn.disc.pdis.fivet.grpc.ControlEntity parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static cl.ucn.disc.pdis.fivet.grpc.ControlEntity parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static cl.ucn.disc.pdis.fivet.grpc.ControlEntity parseFrom(
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
  public static Builder newBuilder(cl.ucn.disc.pdis.fivet.grpc.ControlEntity prototype) {
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
   * Protobuf type {@code ControlEntity}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ControlEntity)
      cl.ucn.disc.pdis.fivet.grpc.ControlEntityOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return cl.ucn.disc.pdis.fivet.grpc.Fivet.internal_static_ControlEntity_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return cl.ucn.disc.pdis.fivet.grpc.Fivet.internal_static_ControlEntity_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              cl.ucn.disc.pdis.fivet.grpc.ControlEntity.class, cl.ucn.disc.pdis.fivet.grpc.ControlEntity.Builder.class);
    }

    // Construct using cl.ucn.disc.pdis.fivet.grpc.ControlEntity.newBuilder()
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
      fecha_ = "";

      temperatura_ = 0D;

      peso_ = 0D;

      altura_ = 0D;

      diagnostico_ = "";

      if (veterinarioBuilder_ == null) {
        veterinario_ = null;
      } else {
        veterinario_ = null;
        veterinarioBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return cl.ucn.disc.pdis.fivet.grpc.Fivet.internal_static_ControlEntity_descriptor;
    }

    @java.lang.Override
    public cl.ucn.disc.pdis.fivet.grpc.ControlEntity getDefaultInstanceForType() {
      return cl.ucn.disc.pdis.fivet.grpc.ControlEntity.getDefaultInstance();
    }

    @java.lang.Override
    public cl.ucn.disc.pdis.fivet.grpc.ControlEntity build() {
      cl.ucn.disc.pdis.fivet.grpc.ControlEntity result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public cl.ucn.disc.pdis.fivet.grpc.ControlEntity buildPartial() {
      cl.ucn.disc.pdis.fivet.grpc.ControlEntity result = new cl.ucn.disc.pdis.fivet.grpc.ControlEntity(this);
      result.fecha_ = fecha_;
      result.temperatura_ = temperatura_;
      result.peso_ = peso_;
      result.altura_ = altura_;
      result.diagnostico_ = diagnostico_;
      if (veterinarioBuilder_ == null) {
        result.veterinario_ = veterinario_;
      } else {
        result.veterinario_ = veterinarioBuilder_.build();
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
      if (other instanceof cl.ucn.disc.pdis.fivet.grpc.ControlEntity) {
        return mergeFrom((cl.ucn.disc.pdis.fivet.grpc.ControlEntity)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(cl.ucn.disc.pdis.fivet.grpc.ControlEntity other) {
      if (other == cl.ucn.disc.pdis.fivet.grpc.ControlEntity.getDefaultInstance()) return this;
      if (!other.getFecha().isEmpty()) {
        fecha_ = other.fecha_;
        onChanged();
      }
      if (other.getTemperatura() != 0D) {
        setTemperatura(other.getTemperatura());
      }
      if (other.getPeso() != 0D) {
        setPeso(other.getPeso());
      }
      if (other.getAltura() != 0D) {
        setAltura(other.getAltura());
      }
      if (!other.getDiagnostico().isEmpty()) {
        diagnostico_ = other.diagnostico_;
        onChanged();
      }
      if (other.hasVeterinario()) {
        mergeVeterinario(other.getVeterinario());
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
      cl.ucn.disc.pdis.fivet.grpc.ControlEntity parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (cl.ucn.disc.pdis.fivet.grpc.ControlEntity) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object fecha_ = "";
    /**
     * <code>string fecha = 1;</code>
     * @return The fecha.
     */
    public java.lang.String getFecha() {
      java.lang.Object ref = fecha_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        fecha_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string fecha = 1;</code>
     * @return The bytes for fecha.
     */
    public com.google.protobuf.ByteString
        getFechaBytes() {
      java.lang.Object ref = fecha_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        fecha_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string fecha = 1;</code>
     * @param value The fecha to set.
     * @return This builder for chaining.
     */
    public Builder setFecha(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      fecha_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string fecha = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearFecha() {
      
      fecha_ = getDefaultInstance().getFecha();
      onChanged();
      return this;
    }
    /**
     * <code>string fecha = 1;</code>
     * @param value The bytes for fecha to set.
     * @return This builder for chaining.
     */
    public Builder setFechaBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      fecha_ = value;
      onChanged();
      return this;
    }

    private double temperatura_ ;
    /**
     * <code>double temperatura = 2;</code>
     * @return The temperatura.
     */
    @java.lang.Override
    public double getTemperatura() {
      return temperatura_;
    }
    /**
     * <code>double temperatura = 2;</code>
     * @param value The temperatura to set.
     * @return This builder for chaining.
     */
    public Builder setTemperatura(double value) {
      
      temperatura_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>double temperatura = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearTemperatura() {
      
      temperatura_ = 0D;
      onChanged();
      return this;
    }

    private double peso_ ;
    /**
     * <code>double peso = 3;</code>
     * @return The peso.
     */
    @java.lang.Override
    public double getPeso() {
      return peso_;
    }
    /**
     * <code>double peso = 3;</code>
     * @param value The peso to set.
     * @return This builder for chaining.
     */
    public Builder setPeso(double value) {
      
      peso_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>double peso = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearPeso() {
      
      peso_ = 0D;
      onChanged();
      return this;
    }

    private double altura_ ;
    /**
     * <code>double altura = 4;</code>
     * @return The altura.
     */
    @java.lang.Override
    public double getAltura() {
      return altura_;
    }
    /**
     * <code>double altura = 4;</code>
     * @param value The altura to set.
     * @return This builder for chaining.
     */
    public Builder setAltura(double value) {
      
      altura_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>double altura = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearAltura() {
      
      altura_ = 0D;
      onChanged();
      return this;
    }

    private java.lang.Object diagnostico_ = "";
    /**
     * <code>string diagnostico = 5;</code>
     * @return The diagnostico.
     */
    public java.lang.String getDiagnostico() {
      java.lang.Object ref = diagnostico_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        diagnostico_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string diagnostico = 5;</code>
     * @return The bytes for diagnostico.
     */
    public com.google.protobuf.ByteString
        getDiagnosticoBytes() {
      java.lang.Object ref = diagnostico_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        diagnostico_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string diagnostico = 5;</code>
     * @param value The diagnostico to set.
     * @return This builder for chaining.
     */
    public Builder setDiagnostico(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      diagnostico_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string diagnostico = 5;</code>
     * @return This builder for chaining.
     */
    public Builder clearDiagnostico() {
      
      diagnostico_ = getDefaultInstance().getDiagnostico();
      onChanged();
      return this;
    }
    /**
     * <code>string diagnostico = 5;</code>
     * @param value The bytes for diagnostico to set.
     * @return This builder for chaining.
     */
    public Builder setDiagnosticoBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      diagnostico_ = value;
      onChanged();
      return this;
    }

    private cl.ucn.disc.pdis.fivet.grpc.PersonaEntity veterinario_;
    private com.google.protobuf.SingleFieldBuilderV3<
        cl.ucn.disc.pdis.fivet.grpc.PersonaEntity, cl.ucn.disc.pdis.fivet.grpc.PersonaEntity.Builder, cl.ucn.disc.pdis.fivet.grpc.PersonaEntityOrBuilder> veterinarioBuilder_;
    /**
     * <code>.PersonaEntity veterinario = 6;</code>
     * @return Whether the veterinario field is set.
     */
    public boolean hasVeterinario() {
      return veterinarioBuilder_ != null || veterinario_ != null;
    }
    /**
     * <code>.PersonaEntity veterinario = 6;</code>
     * @return The veterinario.
     */
    public cl.ucn.disc.pdis.fivet.grpc.PersonaEntity getVeterinario() {
      if (veterinarioBuilder_ == null) {
        return veterinario_ == null ? cl.ucn.disc.pdis.fivet.grpc.PersonaEntity.getDefaultInstance() : veterinario_;
      } else {
        return veterinarioBuilder_.getMessage();
      }
    }
    /**
     * <code>.PersonaEntity veterinario = 6;</code>
     */
    public Builder setVeterinario(cl.ucn.disc.pdis.fivet.grpc.PersonaEntity value) {
      if (veterinarioBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        veterinario_ = value;
        onChanged();
      } else {
        veterinarioBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.PersonaEntity veterinario = 6;</code>
     */
    public Builder setVeterinario(
        cl.ucn.disc.pdis.fivet.grpc.PersonaEntity.Builder builderForValue) {
      if (veterinarioBuilder_ == null) {
        veterinario_ = builderForValue.build();
        onChanged();
      } else {
        veterinarioBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.PersonaEntity veterinario = 6;</code>
     */
    public Builder mergeVeterinario(cl.ucn.disc.pdis.fivet.grpc.PersonaEntity value) {
      if (veterinarioBuilder_ == null) {
        if (veterinario_ != null) {
          veterinario_ =
            cl.ucn.disc.pdis.fivet.grpc.PersonaEntity.newBuilder(veterinario_).mergeFrom(value).buildPartial();
        } else {
          veterinario_ = value;
        }
        onChanged();
      } else {
        veterinarioBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.PersonaEntity veterinario = 6;</code>
     */
    public Builder clearVeterinario() {
      if (veterinarioBuilder_ == null) {
        veterinario_ = null;
        onChanged();
      } else {
        veterinario_ = null;
        veterinarioBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.PersonaEntity veterinario = 6;</code>
     */
    public cl.ucn.disc.pdis.fivet.grpc.PersonaEntity.Builder getVeterinarioBuilder() {
      
      onChanged();
      return getVeterinarioFieldBuilder().getBuilder();
    }
    /**
     * <code>.PersonaEntity veterinario = 6;</code>
     */
    public cl.ucn.disc.pdis.fivet.grpc.PersonaEntityOrBuilder getVeterinarioOrBuilder() {
      if (veterinarioBuilder_ != null) {
        return veterinarioBuilder_.getMessageOrBuilder();
      } else {
        return veterinario_ == null ?
            cl.ucn.disc.pdis.fivet.grpc.PersonaEntity.getDefaultInstance() : veterinario_;
      }
    }
    /**
     * <code>.PersonaEntity veterinario = 6;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        cl.ucn.disc.pdis.fivet.grpc.PersonaEntity, cl.ucn.disc.pdis.fivet.grpc.PersonaEntity.Builder, cl.ucn.disc.pdis.fivet.grpc.PersonaEntityOrBuilder> 
        getVeterinarioFieldBuilder() {
      if (veterinarioBuilder_ == null) {
        veterinarioBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            cl.ucn.disc.pdis.fivet.grpc.PersonaEntity, cl.ucn.disc.pdis.fivet.grpc.PersonaEntity.Builder, cl.ucn.disc.pdis.fivet.grpc.PersonaEntityOrBuilder>(
                getVeterinario(),
                getParentForChildren(),
                isClean());
        veterinario_ = null;
      }
      return veterinarioBuilder_;
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


    // @@protoc_insertion_point(builder_scope:ControlEntity)
  }

  // @@protoc_insertion_point(class_scope:ControlEntity)
  private static final cl.ucn.disc.pdis.fivet.grpc.ControlEntity DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new cl.ucn.disc.pdis.fivet.grpc.ControlEntity();
  }

  public static cl.ucn.disc.pdis.fivet.grpc.ControlEntity getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ControlEntity>
      PARSER = new com.google.protobuf.AbstractParser<ControlEntity>() {
    @java.lang.Override
    public ControlEntity parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ControlEntity(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ControlEntity> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ControlEntity> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public cl.ucn.disc.pdis.fivet.grpc.ControlEntity getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

