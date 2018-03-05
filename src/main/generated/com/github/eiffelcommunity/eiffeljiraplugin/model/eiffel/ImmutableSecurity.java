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
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link Security}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableSecurity.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "Security"})
public final class ImmutableSecurity
    implements Security {
  private final Sdm sdm;

  private ImmutableSecurity(Sdm sdm) {
    this.sdm = sdm;
  }

  /**
   * @return The value of the {@code sdm} attribute
   */
  @JsonProperty("sdm")
  @Override
  public Optional<Sdm> sdm() {
    return Optional.ofNullable(sdm);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link Security#sdm() sdm} attribute.
   * @param value The value for sdm
   * @return A modified copy of {@code this} object
   */
  public final ImmutableSecurity withSdm(Sdm value) {
    Sdm newValue = Objects.requireNonNull(value, "sdm");
    if (this.sdm == newValue) return this;
    return new ImmutableSecurity(newValue);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link Security#sdm() sdm} attribute.
   * A shallow reference equality check is used on unboxed optional value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for sdm
   * @return A modified copy of {@code this} object
   */
  public final ImmutableSecurity withSdm(Optional<? extends Sdm> optional) {
    Sdm value = optional.orElse(null);
    if (this.sdm == value) return this;
    return new ImmutableSecurity(value);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableSecurity} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableSecurity
        && equalTo((ImmutableSecurity) another);
  }

  private boolean equalTo(ImmutableSecurity another) {
    return Objects.equals(sdm, another.sdm);
  }

  /**
   * Computes a hash code from attributes: {@code sdm}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + Objects.hashCode(sdm);
    return h;
  }

  /**
   * Prints the immutable value {@code Security} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder("Security{");
    if (sdm != null) {
      builder.append("sdm=").append(sdm);
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
  static final class Json implements Security {
    Optional<Sdm> sdm = Optional.empty();
    @JsonProperty("sdm")
    public void setSdm(Optional<Sdm> sdm) {
      this.sdm = sdm;
    }
    @Override
    public Optional<Sdm> sdm() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableSecurity fromJson(Json json) {
    ImmutableSecurity.Builder builder = ImmutableSecurity.builder();
    if (json.sdm != null) {
      builder.sdm(json.sdm);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link Security} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Security instance
   */
  public static ImmutableSecurity copyOf(Security instance) {
    if (instance instanceof ImmutableSecurity) {
      return (ImmutableSecurity) instance;
    }
    return ImmutableSecurity.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableSecurity ImmutableSecurity}.
   * @return A new ImmutableSecurity builder
   */
  public static ImmutableSecurity.Builder builder() {
    return new ImmutableSecurity.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableSecurity ImmutableSecurity}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private Sdm sdm;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code Security} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(Security instance) {
      Objects.requireNonNull(instance, "instance");
      Optional<Sdm> sdmOptional = instance.sdm();
      if (sdmOptional.isPresent()) {
        sdm(sdmOptional);
      }
      return this;
    }

    /**
     * Initializes the optional value {@link Security#sdm() sdm} to sdm.
     * @param sdm The value for sdm
     * @return {@code this} builder for chained invocation
     */
    public final Builder sdm(Sdm sdm) {
      this.sdm = Objects.requireNonNull(sdm, "sdm");
      return this;
    }

    /**
     * Initializes the optional value {@link Security#sdm() sdm} to sdm.
     * @param sdm The value for sdm
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("sdm")
    public final Builder sdm(Optional<? extends Sdm> sdm) {
      this.sdm = sdm.orElse(null);
      return this;
    }

    /**
     * Builds a new {@link ImmutableSecurity ImmutableSecurity}.
     * @return An immutable instance of Security
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableSecurity build() {
      return new ImmutableSecurity(sdm);
    }
  }
}
