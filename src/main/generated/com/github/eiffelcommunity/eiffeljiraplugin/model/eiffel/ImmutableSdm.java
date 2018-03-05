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
 * Immutable implementation of {@link Sdm}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableSdm.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "Sdm"})
public final class ImmutableSdm implements Sdm {
  private final String authorIdentity;
  private final String encryptedDigest;

  private ImmutableSdm(String authorIdentity, String encryptedDigest) {
    this.authorIdentity = authorIdentity;
    this.encryptedDigest = encryptedDigest;
  }

  /**
   * @return The value of the {@code authorIdentity} attribute
   */
  @JsonProperty("authorIdentity")
  @Override
  public String authorIdentity() {
    return authorIdentity;
  }

  /**
   * @return The value of the {@code encryptedDigest} attribute
   */
  @JsonProperty("encryptedDigest")
  @Override
  public String encryptedDigest() {
    return encryptedDigest;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Sdm#authorIdentity() authorIdentity} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for authorIdentity
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableSdm withAuthorIdentity(String value) {
    if (this.authorIdentity.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "authorIdentity");
    return new ImmutableSdm(newValue, this.encryptedDigest);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Sdm#encryptedDigest() encryptedDigest} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for encryptedDigest
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableSdm withEncryptedDigest(String value) {
    if (this.encryptedDigest.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "encryptedDigest");
    return new ImmutableSdm(this.authorIdentity, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableSdm} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableSdm
        && equalTo((ImmutableSdm) another);
  }

  private boolean equalTo(ImmutableSdm another) {
    return authorIdentity.equals(another.authorIdentity)
        && encryptedDigest.equals(another.encryptedDigest);
  }

  /**
   * Computes a hash code from attributes: {@code authorIdentity}, {@code encryptedDigest}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + authorIdentity.hashCode();
    h += (h << 5) + encryptedDigest.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code Sdm} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "Sdm{"
        + "authorIdentity=" + authorIdentity
        + ", encryptedDigest=" + encryptedDigest
        + "}";
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements Sdm {
    String authorIdentity;
    String encryptedDigest;
    @JsonProperty("authorIdentity")
    public void setAuthorIdentity(String authorIdentity) {
      this.authorIdentity = authorIdentity;
    }
    @JsonProperty("encryptedDigest")
    public void setEncryptedDigest(String encryptedDigest) {
      this.encryptedDigest = encryptedDigest;
    }
    @Override
    public String authorIdentity() { throw new UnsupportedOperationException(); }
    @Override
    public String encryptedDigest() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableSdm fromJson(Json json) {
    ImmutableSdm.Builder builder = ImmutableSdm.builder();
    if (json.authorIdentity != null) {
      builder.authorIdentity(json.authorIdentity);
    }
    if (json.encryptedDigest != null) {
      builder.encryptedDigest(json.encryptedDigest);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link Sdm} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Sdm instance
   */
  public static ImmutableSdm copyOf(Sdm instance) {
    if (instance instanceof ImmutableSdm) {
      return (ImmutableSdm) instance;
    }
    return ImmutableSdm.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableSdm ImmutableSdm}.
   * @return A new ImmutableSdm builder
   */
  public static ImmutableSdm.Builder builder() {
    return new ImmutableSdm.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableSdm ImmutableSdm}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private static final long INIT_BIT_AUTHOR_IDENTITY = 0x1L;
    private static final long INIT_BIT_ENCRYPTED_DIGEST = 0x2L;
    private long initBits = 0x3L;

    private String authorIdentity;
    private String encryptedDigest;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code Sdm} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(Sdm instance) {
      Objects.requireNonNull(instance, "instance");
      authorIdentity(instance.authorIdentity());
      encryptedDigest(instance.encryptedDigest());
      return this;
    }

    /**
     * Initializes the value for the {@link Sdm#authorIdentity() authorIdentity} attribute.
     * @param authorIdentity The value for authorIdentity 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("authorIdentity")
    public final Builder authorIdentity(String authorIdentity) {
      this.authorIdentity = Objects.requireNonNull(authorIdentity, "authorIdentity");
      initBits &= ~INIT_BIT_AUTHOR_IDENTITY;
      return this;
    }

    /**
     * Initializes the value for the {@link Sdm#encryptedDigest() encryptedDigest} attribute.
     * @param encryptedDigest The value for encryptedDigest 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("encryptedDigest")
    public final Builder encryptedDigest(String encryptedDigest) {
      this.encryptedDigest = Objects.requireNonNull(encryptedDigest, "encryptedDigest");
      initBits &= ~INIT_BIT_ENCRYPTED_DIGEST;
      return this;
    }

    /**
     * Builds a new {@link ImmutableSdm ImmutableSdm}.
     * @return An immutable instance of Sdm
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableSdm build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableSdm(authorIdentity, encryptedDigest);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<String>();
      if ((initBits & INIT_BIT_AUTHOR_IDENTITY) != 0) attributes.add("authorIdentity");
      if ((initBits & INIT_BIT_ENCRYPTED_DIGEST) != 0) attributes.add("encryptedDigest");
      return "Cannot build Sdm, some of required attributes are not set " + attributes;
    }
  }
}
