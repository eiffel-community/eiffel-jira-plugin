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
 * Immutable implementation of {@link JiraFieldsIssueType}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableJiraFieldsIssueType.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "JiraFieldsIssueType"})
@JsonIgnoreProperties(ignoreUnknown = true)
public final class ImmutableJiraFieldsIssueType
    implements JiraFieldsIssueType {
  private final JiraIssueType issueType;

  private ImmutableJiraFieldsIssueType(JiraIssueType issueType) {
    this.issueType = issueType;
  }

  /**
   * @return The value of the {@code issueType} attribute
   */
  @JsonProperty("name")
  @Override
  public JiraIssueType issueType() {
    return issueType;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link JiraFieldsIssueType#issueType() issueType} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for issueType
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableJiraFieldsIssueType withIssueType(JiraIssueType value) {
    if (this.issueType == value) return this;
    JiraIssueType newValue = Objects.requireNonNull(value, "issueType");
    return new ImmutableJiraFieldsIssueType(newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableJiraFieldsIssueType} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableJiraFieldsIssueType
        && equalTo((ImmutableJiraFieldsIssueType) another);
  }

  private boolean equalTo(ImmutableJiraFieldsIssueType another) {
    return issueType.equals(another.issueType);
  }

  /**
   * Computes a hash code from attributes: {@code issueType}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + issueType.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code JiraFieldsIssueType} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "JiraFieldsIssueType{"
        + "issueType=" + issueType
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
      implements JiraFieldsIssueType {
    JiraIssueType issueType;
    @JsonProperty("name")
    public void setIssueType(JiraIssueType issueType) {
      this.issueType = issueType;
    }
    @Override
    public JiraIssueType issueType() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableJiraFieldsIssueType fromJson(Json json) {
    ImmutableJiraFieldsIssueType.Builder builder = ImmutableJiraFieldsIssueType.builder();
    if (json.issueType != null) {
      builder.issueType(json.issueType);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link JiraFieldsIssueType} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable JiraFieldsIssueType instance
   */
  public static ImmutableJiraFieldsIssueType copyOf(JiraFieldsIssueType instance) {
    if (instance instanceof ImmutableJiraFieldsIssueType) {
      return (ImmutableJiraFieldsIssueType) instance;
    }
    return ImmutableJiraFieldsIssueType.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableJiraFieldsIssueType ImmutableJiraFieldsIssueType}.
   * @return A new ImmutableJiraFieldsIssueType builder
   */
  public static ImmutableJiraFieldsIssueType.Builder builder() {
    return new ImmutableJiraFieldsIssueType.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableJiraFieldsIssueType ImmutableJiraFieldsIssueType}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private static final long INIT_BIT_ISSUE_TYPE = 0x1L;
    private long initBits = 0x1L;

    private JiraIssueType issueType;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code JiraFieldsIssueType} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(JiraFieldsIssueType instance) {
      Objects.requireNonNull(instance, "instance");
      issueType(instance.issueType());
      return this;
    }

    /**
     * Initializes the value for the {@link JiraFieldsIssueType#issueType() issueType} attribute.
     * @param issueType The value for issueType 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("name")
    public final Builder issueType(JiraIssueType issueType) {
      this.issueType = Objects.requireNonNull(issueType, "issueType");
      initBits &= ~INIT_BIT_ISSUE_TYPE;
      return this;
    }

    /**
     * Builds a new {@link ImmutableJiraFieldsIssueType ImmutableJiraFieldsIssueType}.
     * @return An immutable instance of JiraFieldsIssueType
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableJiraFieldsIssueType build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableJiraFieldsIssueType(issueType);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<String>();
      if ((initBits & INIT_BIT_ISSUE_TYPE) != 0) attributes.add("issueType");
      return "Cannot build JiraFieldsIssueType, some of required attributes are not set " + attributes;
    }
  }
}
