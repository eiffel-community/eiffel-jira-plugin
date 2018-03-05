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
 * Immutable implementation of {@link JiraIssueStatusCategory}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableJiraIssueStatusCategory.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "JiraIssueStatusCategory"})
@JsonIgnoreProperties(ignoreUnknown = true)
public final class ImmutableJiraIssueStatusCategory
    implements JiraIssueStatusCategory {
  private final JiraIssueStatusCategoryName name;

  private ImmutableJiraIssueStatusCategory(JiraIssueStatusCategoryName name) {
    this.name = name;
  }

  /**
   * @return The value of the {@code name} attribute
   */
  @JsonProperty("name")
  @Override
  public JiraIssueStatusCategoryName name() {
    return name;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link JiraIssueStatusCategory#name() name} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for name
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableJiraIssueStatusCategory withName(JiraIssueStatusCategoryName value) {
    if (this.name == value) return this;
    JiraIssueStatusCategoryName newValue = Objects.requireNonNull(value, "name");
    return new ImmutableJiraIssueStatusCategory(newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableJiraIssueStatusCategory} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableJiraIssueStatusCategory
        && equalTo((ImmutableJiraIssueStatusCategory) another);
  }

  private boolean equalTo(ImmutableJiraIssueStatusCategory another) {
    return name.equals(another.name);
  }

  /**
   * Computes a hash code from attributes: {@code name}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + name.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code JiraIssueStatusCategory} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "JiraIssueStatusCategory{"
        + "name=" + name
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
      implements JiraIssueStatusCategory {
    JiraIssueStatusCategoryName name;
    @JsonProperty("name")
    public void setName(JiraIssueStatusCategoryName name) {
      this.name = name;
    }
    @Override
    public JiraIssueStatusCategoryName name() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableJiraIssueStatusCategory fromJson(Json json) {
    ImmutableJiraIssueStatusCategory.Builder builder = ImmutableJiraIssueStatusCategory.builder();
    if (json.name != null) {
      builder.name(json.name);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link JiraIssueStatusCategory} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable JiraIssueStatusCategory instance
   */
  public static ImmutableJiraIssueStatusCategory copyOf(JiraIssueStatusCategory instance) {
    if (instance instanceof ImmutableJiraIssueStatusCategory) {
      return (ImmutableJiraIssueStatusCategory) instance;
    }
    return ImmutableJiraIssueStatusCategory.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableJiraIssueStatusCategory ImmutableJiraIssueStatusCategory}.
   * @return A new ImmutableJiraIssueStatusCategory builder
   */
  public static ImmutableJiraIssueStatusCategory.Builder builder() {
    return new ImmutableJiraIssueStatusCategory.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableJiraIssueStatusCategory ImmutableJiraIssueStatusCategory}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private static final long INIT_BIT_NAME = 0x1L;
    private long initBits = 0x1L;

    private JiraIssueStatusCategoryName name;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code JiraIssueStatusCategory} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(JiraIssueStatusCategory instance) {
      Objects.requireNonNull(instance, "instance");
      name(instance.name());
      return this;
    }

    /**
     * Initializes the value for the {@link JiraIssueStatusCategory#name() name} attribute.
     * @param name The value for name 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("name")
    public final Builder name(JiraIssueStatusCategoryName name) {
      this.name = Objects.requireNonNull(name, "name");
      initBits &= ~INIT_BIT_NAME;
      return this;
    }

    /**
     * Builds a new {@link ImmutableJiraIssueStatusCategory ImmutableJiraIssueStatusCategory}.
     * @return An immutable instance of JiraIssueStatusCategory
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableJiraIssueStatusCategory build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableJiraIssueStatusCategory(name);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<String>();
      if ((initBits & INIT_BIT_NAME) != 0) attributes.add("name");
      return "Cannot build JiraIssueStatusCategory, some of required attributes are not set " + attributes;
    }
  }
}
