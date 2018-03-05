/*
 * Copyright 2018 Jaden Young
 * For a full list of individual contributors, please see the commit history.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.eiffelcommunity.eiffeljiraplugin.model.eiffel;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.net.URI;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link Source}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableSource.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "Source"})
public final class ImmutableSource implements Source {
  private final String domainId;
  private final String host;
  private final String name;
  private final Serializer serializer;
  private final URI uri;

  private ImmutableSource(
      String domainId,
      String host,
      String name,
      Serializer serializer,
      URI uri) {
    this.domainId = domainId;
    this.host = host;
    this.name = name;
    this.serializer = serializer;
    this.uri = uri;
  }

  /**
   * @return The value of the {@code domainId} attribute
   */
  @JsonProperty("domainId")
  @Override
  public Optional<String> domainId() {
    return Optional.ofNullable(domainId);
  }

  /**
   * @return The value of the {@code host} attribute
   */
  @JsonProperty("host")
  @Override
  public Optional<String> host() {
    return Optional.ofNullable(host);
  }

  /**
   * @return The value of the {@code name} attribute
   */
  @JsonProperty("name")
  @Override
  public Optional<String> name() {
    return Optional.ofNullable(name);
  }

  /**
   * @return The value of the {@code serializer} attribute
   */
  @JsonProperty("serializer")
  @Override
  public Optional<Serializer> serializer() {
    return Optional.ofNullable(serializer);
  }

  /**
   * @return The value of the {@code uri} attribute
   */
  @JsonProperty("uri")
  @Override
  public Optional<URI> uri() {
    return Optional.ofNullable(uri);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link Source#domainId() domainId} attribute.
   * @param value The value for domainId
   * @return A modified copy of {@code this} object
   */
  public final ImmutableSource withDomainId(String value) {
    String newValue = Objects.requireNonNull(value, "domainId");
    if (Objects.equals(this.domainId, newValue)) return this;
    return new ImmutableSource(newValue, this.host, this.name, this.serializer, this.uri);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link Source#domainId() domainId} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for domainId
   * @return A modified copy of {@code this} object
   */
  public final ImmutableSource withDomainId(Optional<String> optional) {
    String value = optional.orElse(null);
    if (Objects.equals(this.domainId, value)) return this;
    return new ImmutableSource(value, this.host, this.name, this.serializer, this.uri);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link Source#host() host} attribute.
   * @param value The value for host
   * @return A modified copy of {@code this} object
   */
  public final ImmutableSource withHost(String value) {
    String newValue = Objects.requireNonNull(value, "host");
    if (Objects.equals(this.host, newValue)) return this;
    return new ImmutableSource(this.domainId, newValue, this.name, this.serializer, this.uri);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link Source#host() host} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for host
   * @return A modified copy of {@code this} object
   */
  public final ImmutableSource withHost(Optional<String> optional) {
    String value = optional.orElse(null);
    if (Objects.equals(this.host, value)) return this;
    return new ImmutableSource(this.domainId, value, this.name, this.serializer, this.uri);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link Source#name() name} attribute.
   * @param value The value for name
   * @return A modified copy of {@code this} object
   */
  public final ImmutableSource withName(String value) {
    String newValue = Objects.requireNonNull(value, "name");
    if (Objects.equals(this.name, newValue)) return this;
    return new ImmutableSource(this.domainId, this.host, newValue, this.serializer, this.uri);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link Source#name() name} attribute.
   * An equality check is used on inner nullable value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for name
   * @return A modified copy of {@code this} object
   */
  public final ImmutableSource withName(Optional<String> optional) {
    String value = optional.orElse(null);
    if (Objects.equals(this.name, value)) return this;
    return new ImmutableSource(this.domainId, this.host, value, this.serializer, this.uri);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link Source#serializer() serializer} attribute.
   * @param value The value for serializer
   * @return A modified copy of {@code this} object
   */
  public final ImmutableSource withSerializer(Serializer value) {
    Serializer newValue = Objects.requireNonNull(value, "serializer");
    if (this.serializer == newValue) return this;
    return new ImmutableSource(this.domainId, this.host, this.name, newValue, this.uri);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link Source#serializer() serializer} attribute.
   * A shallow reference equality check is used on unboxed optional value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for serializer
   * @return A modified copy of {@code this} object
   */
  public final ImmutableSource withSerializer(Optional<? extends Serializer> optional) {
    Serializer value = optional.orElse(null);
    if (this.serializer == value) return this;
    return new ImmutableSource(this.domainId, this.host, this.name, value, this.uri);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link Source#uri() uri} attribute.
   * @param value The value for uri
   * @return A modified copy of {@code this} object
   */
  public final ImmutableSource withUri(URI value) {
    URI newValue = Objects.requireNonNull(value, "uri");
    if (this.uri == newValue) return this;
    return new ImmutableSource(this.domainId, this.host, this.name, this.serializer, newValue);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link Source#uri() uri} attribute.
   * A shallow reference equality check is used on unboxed optional value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for uri
   * @return A modified copy of {@code this} object
   */
  public final ImmutableSource withUri(Optional<? extends URI> optional) {
    URI value = optional.orElse(null);
    if (this.uri == value) return this;
    return new ImmutableSource(this.domainId, this.host, this.name, this.serializer, value);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableSource} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableSource
        && equalTo((ImmutableSource) another);
  }

  private boolean equalTo(ImmutableSource another) {
    return Objects.equals(domainId, another.domainId)
        && Objects.equals(host, another.host)
        && Objects.equals(name, another.name)
        && Objects.equals(serializer, another.serializer)
        && Objects.equals(uri, another.uri);
  }

  /**
   * Computes a hash code from attributes: {@code domainId}, {@code host}, {@code name}, {@code serializer}, {@code uri}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + Objects.hashCode(domainId);
    h += (h << 5) + Objects.hashCode(host);
    h += (h << 5) + Objects.hashCode(name);
    h += (h << 5) + Objects.hashCode(serializer);
    h += (h << 5) + Objects.hashCode(uri);
    return h;
  }

  /**
   * Prints the immutable value {@code Source} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder("Source{");
    if (domainId != null) {
      builder.append("domainId=").append(domainId);
    }
    if (host != null) {
      if (builder.length() > 7) builder.append(", ");
      builder.append("host=").append(host);
    }
    if (name != null) {
      if (builder.length() > 7) builder.append(", ");
      builder.append("name=").append(name);
    }
    if (serializer != null) {
      if (builder.length() > 7) builder.append(", ");
      builder.append("serializer=").append(serializer);
    }
    if (uri != null) {
      if (builder.length() > 7) builder.append(", ");
      builder.append("uri=").append(uri);
    }
    return builder.append("}").toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements Source {
    Optional<String> domainId = Optional.empty();
    Optional<String> host = Optional.empty();
    Optional<String> name = Optional.empty();
    Optional<Serializer> serializer = Optional.empty();
    Optional<URI> uri = Optional.empty();
    @JsonProperty("domainId")
    public void setDomainId(Optional<String> domainId) {
      this.domainId = domainId;
    }
    @JsonProperty("host")
    public void setHost(Optional<String> host) {
      this.host = host;
    }
    @JsonProperty("name")
    public void setName(Optional<String> name) {
      this.name = name;
    }
    @JsonProperty("serializer")
    public void setSerializer(Optional<Serializer> serializer) {
      this.serializer = serializer;
    }
    @JsonProperty("uri")
    public void setUri(Optional<URI> uri) {
      this.uri = uri;
    }
    @Override
    public Optional<String> domainId() { throw new UnsupportedOperationException(); }
    @Override
    public Optional<String> host() { throw new UnsupportedOperationException(); }
    @Override
    public Optional<String> name() { throw new UnsupportedOperationException(); }
    @Override
    public Optional<Serializer> serializer() { throw new UnsupportedOperationException(); }
    @Override
    public Optional<URI> uri() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableSource fromJson(Json json) {
    ImmutableSource.Builder builder = ImmutableSource.builder();
    if (json.domainId != null) {
      builder.domainId(json.domainId);
    }
    if (json.host != null) {
      builder.host(json.host);
    }
    if (json.name != null) {
      builder.name(json.name);
    }
    if (json.serializer != null) {
      builder.serializer(json.serializer);
    }
    if (json.uri != null) {
      builder.uri(json.uri);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link Source} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Source instance
   */
  public static ImmutableSource copyOf(Source instance) {
    if (instance instanceof ImmutableSource) {
      return (ImmutableSource) instance;
    }
    return ImmutableSource.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableSource ImmutableSource}.
   * @return A new ImmutableSource builder
   */
  public static ImmutableSource.Builder builder() {
    return new ImmutableSource.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableSource ImmutableSource}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private String domainId;
    private String host;
    private String name;
    private Serializer serializer;
    private URI uri;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code Source} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(Source instance) {
      Objects.requireNonNull(instance, "instance");
      Optional<String> domainIdOptional = instance.domainId();
      if (domainIdOptional.isPresent()) {
        domainId(domainIdOptional);
      }
      Optional<String> hostOptional = instance.host();
      if (hostOptional.isPresent()) {
        host(hostOptional);
      }
      Optional<String> nameOptional = instance.name();
      if (nameOptional.isPresent()) {
        name(nameOptional);
      }
      Optional<Serializer> serializerOptional = instance.serializer();
      if (serializerOptional.isPresent()) {
        serializer(serializerOptional);
      }
      Optional<URI> uriOptional = instance.uri();
      if (uriOptional.isPresent()) {
        uri(uriOptional);
      }
      return this;
    }

    /**
     * Initializes the optional value {@link Source#domainId() domainId} to domainId.
     * @param domainId The value for domainId
     * @return {@code this} builder for chained invocation
     */
    public final Builder domainId(String domainId) {
      this.domainId = Objects.requireNonNull(domainId, "domainId");
      return this;
    }

    /**
     * Initializes the optional value {@link Source#domainId() domainId} to domainId.
     * @param domainId The value for domainId
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("domainId")
    public final Builder domainId(Optional<String> domainId) {
      this.domainId = domainId.orElse(null);
      return this;
    }

    /**
     * Initializes the optional value {@link Source#host() host} to host.
     * @param host The value for host
     * @return {@code this} builder for chained invocation
     */
    public final Builder host(String host) {
      this.host = Objects.requireNonNull(host, "host");
      return this;
    }

    /**
     * Initializes the optional value {@link Source#host() host} to host.
     * @param host The value for host
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("host")
    public final Builder host(Optional<String> host) {
      this.host = host.orElse(null);
      return this;
    }

    /**
     * Initializes the optional value {@link Source#name() name} to name.
     * @param name The value for name
     * @return {@code this} builder for chained invocation
     */
    public final Builder name(String name) {
      this.name = Objects.requireNonNull(name, "name");
      return this;
    }

    /**
     * Initializes the optional value {@link Source#name() name} to name.
     * @param name The value for name
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("name")
    public final Builder name(Optional<String> name) {
      this.name = name.orElse(null);
      return this;
    }

    /**
     * Initializes the optional value {@link Source#serializer() serializer} to serializer.
     * @param serializer The value for serializer
     * @return {@code this} builder for chained invocation
     */
    public final Builder serializer(Serializer serializer) {
      this.serializer = Objects.requireNonNull(serializer, "serializer");
      return this;
    }

    /**
     * Initializes the optional value {@link Source#serializer() serializer} to serializer.
     * @param serializer The value for serializer
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("serializer")
    public final Builder serializer(Optional<? extends Serializer> serializer) {
      this.serializer = serializer.orElse(null);
      return this;
    }

    /**
     * Initializes the optional value {@link Source#uri() uri} to uri.
     * @param uri The value for uri
     * @return {@code this} builder for chained invocation
     */
    public final Builder uri(URI uri) {
      this.uri = Objects.requireNonNull(uri, "uri");
      return this;
    }

    /**
     * Initializes the optional value {@link Source#uri() uri} to uri.
     * @param uri The value for uri
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("uri")
    public final Builder uri(Optional<? extends URI> uri) {
      this.uri = uri.orElse(null);
      return this;
    }

    /**
     * Builds a new {@link ImmutableSource ImmutableSource}.
     * @return An immutable instance of Source
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableSource build() {
      return new ImmutableSource(domainId, host, name, serializer, uri);
    }
  }
}
