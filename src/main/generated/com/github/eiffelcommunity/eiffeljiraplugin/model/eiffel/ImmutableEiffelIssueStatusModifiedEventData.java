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
 * Immutable implementation of {@link EiffelIssueStatusModifiedEventData}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableEiffelIssueStatusModifiedEventData.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "EiffelIssueStatusModifiedEventData"})
public final class ImmutableEiffelIssueStatusModifiedEventData
    implements EiffelIssueStatusModifiedEventData {
  private final EiffelIssueStatusCategory category;
  private final String status;

  private ImmutableEiffelIssueStatusModifiedEventData(
      EiffelIssueStatusCategory category,
      String status) {
    this.category = category;
    this.status = status;
  }

  /**
   * @return The value of the {@code category} attribute
   */
  @JsonProperty("category")
  @Override
  public EiffelIssueStatusCategory category() {
    return category;
  }

  /**
   * @return The value of the {@code status} attribute
   */
  @JsonProperty("status")
  @Override
  public String status() {
    return status;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link EiffelIssueStatusModifiedEventData#category() category} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for category
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableEiffelIssueStatusModifiedEventData withCategory(EiffelIssueStatusCategory value) {
    if (this.category == value) return this;
    EiffelIssueStatusCategory newValue = Objects.requireNonNull(value, "category");
    return new ImmutableEiffelIssueStatusModifiedEventData(newValue, this.status);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link EiffelIssueStatusModifiedEventData#status() status} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for status
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableEiffelIssueStatusModifiedEventData withStatus(String value) {
    if (this.status.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "status");
    return new ImmutableEiffelIssueStatusModifiedEventData(this.category, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableEiffelIssueStatusModifiedEventData} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableEiffelIssueStatusModifiedEventData
        && equalTo((ImmutableEiffelIssueStatusModifiedEventData) another);
  }

  private boolean equalTo(ImmutableEiffelIssueStatusModifiedEventData another) {
    return category.equals(another.category)
        && status.equals(another.status);
  }

  /**
   * Computes a hash code from attributes: {@code category}, {@code status}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + category.hashCode();
    h += (h << 5) + status.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code EiffelIssueStatusModifiedEventData} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "EiffelIssueStatusModifiedEventData{"
        + "category=" + category
        + ", status=" + status
        + "}";
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json
      implements EiffelIssueStatusModifiedEventData {
    EiffelIssueStatusCategory category;
    String status;
    @JsonProperty("category")
    public void setCategory(EiffelIssueStatusCategory category) {
      this.category = category;
    }
    @JsonProperty("status")
    public void setStatus(String status) {
      this.status = status;
    }
    @Override
    public EiffelIssueStatusCategory category() { throw new UnsupportedOperationException(); }
    @Override
    public String status() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableEiffelIssueStatusModifiedEventData fromJson(Json json) {
    ImmutableEiffelIssueStatusModifiedEventData.Builder builder = ImmutableEiffelIssueStatusModifiedEventData.builder();
    if (json.category != null) {
      builder.category(json.category);
    }
    if (json.status != null) {
      builder.status(json.status);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link EiffelIssueStatusModifiedEventData} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable EiffelIssueStatusModifiedEventData instance
   */
  public static ImmutableEiffelIssueStatusModifiedEventData copyOf(EiffelIssueStatusModifiedEventData instance) {
    if (instance instanceof ImmutableEiffelIssueStatusModifiedEventData) {
      return (ImmutableEiffelIssueStatusModifiedEventData) instance;
    }
    return ImmutableEiffelIssueStatusModifiedEventData.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableEiffelIssueStatusModifiedEventData ImmutableEiffelIssueStatusModifiedEventData}.
   * @return A new ImmutableEiffelIssueStatusModifiedEventData builder
   */
  public static ImmutableEiffelIssueStatusModifiedEventData.Builder builder() {
    return new ImmutableEiffelIssueStatusModifiedEventData.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableEiffelIssueStatusModifiedEventData ImmutableEiffelIssueStatusModifiedEventData}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private static final long INIT_BIT_CATEGORY = 0x1L;
    private static final long INIT_BIT_STATUS = 0x2L;
    private long initBits = 0x3L;

    private EiffelIssueStatusCategory category;
    private String status;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code EiffelIssueStatusModifiedEventData} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(EiffelIssueStatusModifiedEventData instance) {
      Objects.requireNonNull(instance, "instance");
      category(instance.category());
      status(instance.status());
      return this;
    }

    /**
     * Initializes the value for the {@link EiffelIssueStatusModifiedEventData#category() category} attribute.
     * @param category The value for category 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("category")
    public final Builder category(EiffelIssueStatusCategory category) {
      this.category = Objects.requireNonNull(category, "category");
      initBits &= ~INIT_BIT_CATEGORY;
      return this;
    }

    /**
     * Initializes the value for the {@link EiffelIssueStatusModifiedEventData#status() status} attribute.
     * @param status The value for status 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("status")
    public final Builder status(String status) {
      this.status = Objects.requireNonNull(status, "status");
      initBits &= ~INIT_BIT_STATUS;
      return this;
    }

    /**
     * Builds a new {@link ImmutableEiffelIssueStatusModifiedEventData ImmutableEiffelIssueStatusModifiedEventData}.
     * @return An immutable instance of EiffelIssueStatusModifiedEventData
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableEiffelIssueStatusModifiedEventData build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableEiffelIssueStatusModifiedEventData(category, status);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<String>();
      if ((initBits & INIT_BIT_CATEGORY) != 0) attributes.add("category");
      if ((initBits & INIT_BIT_STATUS) != 0) attributes.add("status");
      return "Cannot build EiffelIssueStatusModifiedEventData, some of required attributes are not set " + attributes;
    }
  }
}
