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

package com.github.eiffelcommunity.eiffeljiraplugin.model.jira;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link JiraIssueStatus}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableJiraIssueStatus.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "JiraIssueStatus"})
@JsonIgnoreProperties(ignoreUnknown = true)
public final class ImmutableJiraIssueStatus
    implements JiraIssueStatus {
  private final ImmutableJiraIssueStatusCategory category;
  private final String name;

  private ImmutableJiraIssueStatus(
      ImmutableJiraIssueStatusCategory category,
      String name) {
    this.category = category;
    this.name = name;
  }

  /**
   * @return The value of the {@code category} attribute
   */
  @JsonProperty("statusCategory")
  @Override
  public ImmutableJiraIssueStatusCategory category() {
    return category;
  }

  /**
   * @return The value of the {@code name} attribute
   */
  @JsonProperty("name")
  @Override
  public String name() {
    return name;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link JiraIssueStatus#category() category} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for category
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableJiraIssueStatus withCategory(ImmutableJiraIssueStatusCategory value) {
    if (this.category == value) return this;
    ImmutableJiraIssueStatusCategory newValue = Objects.requireNonNull(value, "category");
    return new ImmutableJiraIssueStatus(newValue, this.name);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link JiraIssueStatus#name() name} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for name
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableJiraIssueStatus withName(String value) {
    if (this.name.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "name");
    return new ImmutableJiraIssueStatus(this.category, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableJiraIssueStatus} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableJiraIssueStatus
        && equalTo((ImmutableJiraIssueStatus) another);
  }

  private boolean equalTo(ImmutableJiraIssueStatus another) {
    return category.equals(another.category)
        && name.equals(another.name);
  }

  /**
   * Computes a hash code from attributes: {@code category}, {@code name}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + category.hashCode();
    h += (h << 5) + name.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code JiraIssueStatus} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "JiraIssueStatus{"
        + "category=" + category
        + ", name=" + name
        + "}";
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements JiraIssueStatus {
    ImmutableJiraIssueStatusCategory category;
    String name;
    @JsonProperty("statusCategory")
    public void setCategory(ImmutableJiraIssueStatusCategory category) {
      this.category = category;
    }
    @JsonProperty("name")
    public void setName(String name) {
      this.name = name;
    }
    @Override
    public ImmutableJiraIssueStatusCategory category() { throw new UnsupportedOperationException(); }
    @Override
    public String name() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableJiraIssueStatus fromJson(Json json) {
    ImmutableJiraIssueStatus.Builder builder = ImmutableJiraIssueStatus.builder();
    if (json.category != null) {
      builder.category(json.category);
    }
    if (json.name != null) {
      builder.name(json.name);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link JiraIssueStatus} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable JiraIssueStatus instance
   */
  public static ImmutableJiraIssueStatus copyOf(JiraIssueStatus instance) {
    if (instance instanceof ImmutableJiraIssueStatus) {
      return (ImmutableJiraIssueStatus) instance;
    }
    return ImmutableJiraIssueStatus.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableJiraIssueStatus ImmutableJiraIssueStatus}.
   * @return A new ImmutableJiraIssueStatus builder
   */
  public static ImmutableJiraIssueStatus.Builder builder() {
    return new ImmutableJiraIssueStatus.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableJiraIssueStatus ImmutableJiraIssueStatus}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private static final long INIT_BIT_CATEGORY = 0x1L;
    private static final long INIT_BIT_NAME = 0x2L;
    private long initBits = 0x3L;

    private ImmutableJiraIssueStatusCategory category;
    private String name;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code JiraIssueStatus} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(JiraIssueStatus instance) {
      Objects.requireNonNull(instance, "instance");
      category(instance.category());
      name(instance.name());
      return this;
    }

    /**
     * Initializes the value for the {@link JiraIssueStatus#category() category} attribute.
     * @param category The value for category 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("statusCategory")
    public final Builder category(ImmutableJiraIssueStatusCategory category) {
      this.category = Objects.requireNonNull(category, "category");
      initBits &= ~INIT_BIT_CATEGORY;
      return this;
    }

    /**
     * Initializes the value for the {@link JiraIssueStatus#name() name} attribute.
     * @param name The value for name 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("name")
    public final Builder name(String name) {
      this.name = Objects.requireNonNull(name, "name");
      initBits &= ~INIT_BIT_NAME;
      return this;
    }

    /**
     * Builds a new {@link ImmutableJiraIssueStatus ImmutableJiraIssueStatus}.
     * @return An immutable instance of JiraIssueStatus
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableJiraIssueStatus build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableJiraIssueStatus(category, name);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<String>();
      if ((initBits & INIT_BIT_CATEGORY) != 0) attributes.add("category");
      if ((initBits & INIT_BIT_NAME) != 0) attributes.add("name");
      return "Cannot build JiraIssueStatus, some of required attributes are not set " + attributes;
    }
  }
}
