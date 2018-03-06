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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link Serializer}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableSerializer.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "Serializer"})
public final class ImmutableSerializer
    implements Serializer {
  private final String groupId;
  private final String artifcatId;
  private final String version;

  private ImmutableSerializer(String groupId, String artifcatId, String version) {
    this.groupId = groupId;
    this.artifcatId = artifcatId;
    this.version = version;
  }

  /**
   * @return The value of the {@code groupId} attribute
   */
  @JsonProperty("groupId")
  @Override
  public String groupId() {
    return groupId;
  }

  /**
   * @return The value of the {@code artifcatId} attribute
   */
  @JsonProperty("artifcatId")
  @Override
  public String artifcatId() {
    return artifcatId;
  }

  /**
   * @return The value of the {@code version} attribute
   */
  @JsonProperty("version")
  @Override
  public String version() {
    return version;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Serializer#groupId() groupId} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for groupId
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableSerializer withGroupId(String value) {
    if (this.groupId.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "groupId");
    return new ImmutableSerializer(newValue, this.artifcatId, this.version);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Serializer#artifcatId() artifcatId} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for artifcatId
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableSerializer withArtifcatId(String value) {
    if (this.artifcatId.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "artifcatId");
    return new ImmutableSerializer(this.groupId, newValue, this.version);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Serializer#version() version} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for version
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableSerializer withVersion(String value) {
    if (this.version.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "version");
    return new ImmutableSerializer(this.groupId, this.artifcatId, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableSerializer} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableSerializer
        && equalTo((ImmutableSerializer) another);
  }

  private boolean equalTo(ImmutableSerializer another) {
    return groupId.equals(another.groupId)
        && artifcatId.equals(another.artifcatId)
        && version.equals(another.version);
  }

  /**
   * Computes a hash code from attributes: {@code groupId}, {@code artifcatId}, {@code version}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + groupId.hashCode();
    h += (h << 5) + artifcatId.hashCode();
    h += (h << 5) + version.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code Serializer} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "Serializer{"
        + "groupId=" + groupId
        + ", artifcatId=" + artifcatId
        + ", version=" + version
        + "}";
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements Serializer {
    String groupId;
    String artifcatId;
    String version;
    @JsonProperty("groupId")
    public void setGroupId(String groupId) {
      this.groupId = groupId;
    }
    @JsonProperty("artifcatId")
    public void setArtifcatId(String artifcatId) {
      this.artifcatId = artifcatId;
    }
    @JsonProperty("version")
    public void setVersion(String version) {
      this.version = version;
    }
    @Override
    public String groupId() { throw new UnsupportedOperationException(); }
    @Override
    public String artifcatId() { throw new UnsupportedOperationException(); }
    @Override
    public String version() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableSerializer fromJson(Json json) {
    ImmutableSerializer.Builder builder = ImmutableSerializer.builder();
    if (json.groupId != null) {
      builder.groupId(json.groupId);
    }
    if (json.artifcatId != null) {
      builder.artifcatId(json.artifcatId);
    }
    if (json.version != null) {
      builder.version(json.version);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link Serializer} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Serializer instance
   */
  public static ImmutableSerializer copyOf(Serializer instance) {
    if (instance instanceof ImmutableSerializer) {
      return (ImmutableSerializer) instance;
    }
    return ImmutableSerializer.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableSerializer ImmutableSerializer}.
   * @return A new ImmutableSerializer builder
   */
  public static ImmutableSerializer.Builder builder() {
    return new ImmutableSerializer.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableSerializer ImmutableSerializer}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private static final long INIT_BIT_GROUP_ID = 0x1L;
    private static final long INIT_BIT_ARTIFCAT_ID = 0x2L;
    private static final long INIT_BIT_VERSION = 0x4L;
    private long initBits = 0x7L;

    private String groupId;
    private String artifcatId;
    private String version;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code Serializer} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(Serializer instance) {
      Objects.requireNonNull(instance, "instance");
      groupId(instance.groupId());
      artifcatId(instance.artifcatId());
      version(instance.version());
      return this;
    }

    /**
     * Initializes the value for the {@link Serializer#groupId() groupId} attribute.
     * @param groupId The value for groupId 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("groupId")
    public final Builder groupId(String groupId) {
      this.groupId = Objects.requireNonNull(groupId, "groupId");
      initBits &= ~INIT_BIT_GROUP_ID;
      return this;
    }

    /**
     * Initializes the value for the {@link Serializer#artifcatId() artifcatId} attribute.
     * @param artifcatId The value for artifcatId 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("artifcatId")
    public final Builder artifcatId(String artifcatId) {
      this.artifcatId = Objects.requireNonNull(artifcatId, "artifcatId");
      initBits &= ~INIT_BIT_ARTIFCAT_ID;
      return this;
    }

    /**
     * Initializes the value for the {@link Serializer#version() version} attribute.
     * @param version The value for version 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("version")
    public final Builder version(String version) {
      this.version = Objects.requireNonNull(version, "version");
      initBits &= ~INIT_BIT_VERSION;
      return this;
    }

    /**
     * Builds a new {@link ImmutableSerializer ImmutableSerializer}.
     * @return An immutable instance of Serializer
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableSerializer build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableSerializer(groupId, artifcatId, version);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<String>();
      if ((initBits & INIT_BIT_GROUP_ID) != 0) attributes.add("groupId");
      if ((initBits & INIT_BIT_ARTIFCAT_ID) != 0) attributes.add("artifcatId");
      if ((initBits & INIT_BIT_VERSION) != 0) attributes.add("version");
      return "Cannot build Serializer, some of required attributes are not set " + attributes;
    }
  }
}
