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
import java.util.UUID;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link Link}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableLink.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "Link"})
public final class ImmutableLink implements Link {
  private final String type;
  private final UUID target;

  private ImmutableLink(String type, UUID target) {
    this.type = type;
    this.target = target;
  }

  /**
   * @return The value of the {@code type} attribute
   */
  @JsonProperty("type")
  @Override
  public String type() {
    return type;
  }

  /**
   * @return The value of the {@code target} attribute
   */
  @JsonProperty("target")
  @Override
  public UUID target() {
    return target;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Link#type() type} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for type
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableLink withType(String value) {
    if (this.type.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "type");
    return new ImmutableLink(newValue, this.target);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Link#target() target} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for target
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableLink withTarget(UUID value) {
    if (this.target == value) return this;
    UUID newValue = Objects.requireNonNull(value, "target");
    return new ImmutableLink(this.type, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableLink} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableLink
        && equalTo((ImmutableLink) another);
  }

  private boolean equalTo(ImmutableLink another) {
    return type.equals(another.type)
        && target.equals(another.target);
  }

  /**
   * Computes a hash code from attributes: {@code type}, {@code target}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + type.hashCode();
    h += (h << 5) + target.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code Link} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "Link{"
        + "type=" + type
        + ", target=" + target
        + "}";
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements Link {
    String type;
    UUID target;
    @JsonProperty("type")
    public void setType(String type) {
      this.type = type;
    }
    @JsonProperty("target")
    public void setTarget(UUID target) {
      this.target = target;
    }
    @Override
    public String type() { throw new UnsupportedOperationException(); }
    @Override
    public UUID target() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableLink fromJson(Json json) {
    ImmutableLink.Builder builder = ImmutableLink.builder();
    if (json.type != null) {
      builder.type(json.type);
    }
    if (json.target != null) {
      builder.target(json.target);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link Link} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Link instance
   */
  public static ImmutableLink copyOf(Link instance) {
    if (instance instanceof ImmutableLink) {
      return (ImmutableLink) instance;
    }
    return ImmutableLink.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableLink ImmutableLink}.
   * @return A new ImmutableLink builder
   */
  public static ImmutableLink.Builder builder() {
    return new ImmutableLink.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableLink ImmutableLink}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private static final long INIT_BIT_TYPE = 0x1L;
    private static final long INIT_BIT_TARGET = 0x2L;
    private long initBits = 0x3L;

    private String type;
    private UUID target;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code Link} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(Link instance) {
      Objects.requireNonNull(instance, "instance");
      type(instance.type());
      target(instance.target());
      return this;
    }

    /**
     * Initializes the value for the {@link Link#type() type} attribute.
     * @param type The value for type 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("type")
    public final Builder type(String type) {
      this.type = Objects.requireNonNull(type, "type");
      initBits &= ~INIT_BIT_TYPE;
      return this;
    }

    /**
     * Initializes the value for the {@link Link#target() target} attribute.
     * @param target The value for target 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("target")
    public final Builder target(UUID target) {
      this.target = Objects.requireNonNull(target, "target");
      initBits &= ~INIT_BIT_TARGET;
      return this;
    }

    /**
     * Builds a new {@link ImmutableLink ImmutableLink}.
     * @return An immutable instance of Link
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableLink build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableLink(type, target);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<String>();
      if ((initBits & INIT_BIT_TYPE) != 0) attributes.add("type");
      if ((initBits & INIT_BIT_TARGET) != 0) attributes.add("target");
      return "Cannot build Link, some of required attributes are not set " + attributes;
    }
  }
}
