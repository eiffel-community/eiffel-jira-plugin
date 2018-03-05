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
import java.util.Optional;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link JiraIssueFields}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableJiraIssueFields.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "JiraIssueFields"})
@JsonIgnoreProperties(ignoreUnknown = true)
public final class ImmutableJiraIssueFields
    implements JiraIssueFields {
  private final ImmutableJiraFieldsIssueType issueType;
  private final ImmutableJiraAssignee assignee;
  private final ImmutableJiraIssueStatus status;

  private ImmutableJiraIssueFields(
      ImmutableJiraFieldsIssueType issueType,
      ImmutableJiraAssignee assignee,
      ImmutableJiraIssueStatus status) {
    this.issueType = issueType;
    this.assignee = assignee;
    this.status = status;
  }

  /**
   * @return The value of the {@code issueType} attribute
   */
  @JsonProperty("issuetype")
  @Override
  public ImmutableJiraFieldsIssueType issueType() {
    return issueType;
  }

  /**
   * @return The value of the {@code assignee} attribute
   */
  @JsonProperty("assignee")
  @Override
  public Optional<ImmutableJiraAssignee> assignee() {
    return Optional.ofNullable(assignee);
  }

  /**
   * @return The value of the {@code status} attribute
   */
  @JsonProperty("status")
  @Override
  public ImmutableJiraIssueStatus status() {
    return status;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link JiraIssueFields#issueType() issueType} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for issueType
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableJiraIssueFields withIssueType(ImmutableJiraFieldsIssueType value) {
    if (this.issueType == value) return this;
    ImmutableJiraFieldsIssueType newValue = Objects.requireNonNull(value, "issueType");
    return new ImmutableJiraIssueFields(newValue, this.assignee, this.status);
  }

  /**
   * Copy the current immutable object by setting a <i>present</i> value for the optional {@link JiraIssueFields#assignee() assignee} attribute.
   * @param value The value for assignee
   * @return A modified copy of {@code this} object
   */
  public final ImmutableJiraIssueFields withAssignee(ImmutableJiraAssignee value) {
    ImmutableJiraAssignee newValue = Objects.requireNonNull(value, "assignee");
    if (this.assignee == newValue) return this;
    return new ImmutableJiraIssueFields(this.issueType, newValue, this.status);
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link JiraIssueFields#assignee() assignee} attribute.
   * A shallow reference equality check is used on unboxed optional value to prevent copying of the same value by returning {@code this}.
   * @param optional A value for assignee
   * @return A modified copy of {@code this} object
   */
  public final ImmutableJiraIssueFields withAssignee(Optional<? extends ImmutableJiraAssignee> optional) {
    ImmutableJiraAssignee value = optional.orElse(null);
    if (this.assignee == value) return this;
    return new ImmutableJiraIssueFields(this.issueType, value, this.status);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link JiraIssueFields#status() status} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for status
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableJiraIssueFields withStatus(ImmutableJiraIssueStatus value) {
    if (this.status == value) return this;
    ImmutableJiraIssueStatus newValue = Objects.requireNonNull(value, "status");
    return new ImmutableJiraIssueFields(this.issueType, this.assignee, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableJiraIssueFields} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableJiraIssueFields
        && equalTo((ImmutableJiraIssueFields) another);
  }

  private boolean equalTo(ImmutableJiraIssueFields another) {
    return issueType.equals(another.issueType)
        && Objects.equals(assignee, another.assignee)
        && status.equals(another.status);
  }

  /**
   * Computes a hash code from attributes: {@code issueType}, {@code assignee}, {@code status}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + issueType.hashCode();
    h += (h << 5) + Objects.hashCode(assignee);
    h += (h << 5) + status.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code JiraIssueFields} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder("JiraIssueFields{");
    builder.append("issueType=").append(issueType);
    if (assignee != null) {
      builder.append(", ");
      builder.append("assignee=").append(assignee);
    }
    builder.append(", ");
    builder.append("status=").append(status);
    return builder.append("}").toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements JiraIssueFields {
    ImmutableJiraFieldsIssueType issueType;
    Optional<ImmutableJiraAssignee> assignee = Optional.empty();
    ImmutableJiraIssueStatus status;
    @JsonProperty("issuetype")
    public void setIssueType(ImmutableJiraFieldsIssueType issueType) {
      this.issueType = issueType;
    }
    @JsonProperty("assignee")
    public void setAssignee(Optional<ImmutableJiraAssignee> assignee) {
      this.assignee = assignee;
    }
    @JsonProperty("status")
    public void setStatus(ImmutableJiraIssueStatus status) {
      this.status = status;
    }
    @Override
    public ImmutableJiraFieldsIssueType issueType() { throw new UnsupportedOperationException(); }
    @Override
    public Optional<ImmutableJiraAssignee> assignee() { throw new UnsupportedOperationException(); }
    @Override
    public ImmutableJiraIssueStatus status() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableJiraIssueFields fromJson(Json json) {
    ImmutableJiraIssueFields.Builder builder = ImmutableJiraIssueFields.builder();
    if (json.issueType != null) {
      builder.issueType(json.issueType);
    }
    if (json.assignee != null) {
      builder.assignee(json.assignee);
    }
    if (json.status != null) {
      builder.status(json.status);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link JiraIssueFields} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable JiraIssueFields instance
   */
  public static ImmutableJiraIssueFields copyOf(JiraIssueFields instance) {
    if (instance instanceof ImmutableJiraIssueFields) {
      return (ImmutableJiraIssueFields) instance;
    }
    return ImmutableJiraIssueFields.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableJiraIssueFields ImmutableJiraIssueFields}.
   * @return A new ImmutableJiraIssueFields builder
   */
  public static ImmutableJiraIssueFields.Builder builder() {
    return new ImmutableJiraIssueFields.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableJiraIssueFields ImmutableJiraIssueFields}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private static final long INIT_BIT_ISSUE_TYPE = 0x1L;
    private static final long INIT_BIT_STATUS = 0x2L;
    private long initBits = 0x3L;

    private ImmutableJiraFieldsIssueType issueType;
    private ImmutableJiraAssignee assignee;
    private ImmutableJiraIssueStatus status;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code JiraIssueFields} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(JiraIssueFields instance) {
      Objects.requireNonNull(instance, "instance");
      issueType(instance.issueType());
      Optional<ImmutableJiraAssignee> assigneeOptional = instance.assignee();
      if (assigneeOptional.isPresent()) {
        assignee(assigneeOptional);
      }
      status(instance.status());
      return this;
    }

    /**
     * Initializes the value for the {@link JiraIssueFields#issueType() issueType} attribute.
     * @param issueType The value for issueType 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("issuetype")
    public final Builder issueType(ImmutableJiraFieldsIssueType issueType) {
      this.issueType = Objects.requireNonNull(issueType, "issueType");
      initBits &= ~INIT_BIT_ISSUE_TYPE;
      return this;
    }

    /**
     * Initializes the optional value {@link JiraIssueFields#assignee() assignee} to assignee.
     * @param assignee The value for assignee
     * @return {@code this} builder for chained invocation
     */
    public final Builder assignee(ImmutableJiraAssignee assignee) {
      this.assignee = Objects.requireNonNull(assignee, "assignee");
      return this;
    }

    /**
     * Initializes the optional value {@link JiraIssueFields#assignee() assignee} to assignee.
     * @param assignee The value for assignee
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("assignee")
    public final Builder assignee(Optional<? extends ImmutableJiraAssignee> assignee) {
      this.assignee = assignee.orElse(null);
      return this;
    }

    /**
     * Initializes the value for the {@link JiraIssueFields#status() status} attribute.
     * @param status The value for status 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("status")
    public final Builder status(ImmutableJiraIssueStatus status) {
      this.status = Objects.requireNonNull(status, "status");
      initBits &= ~INIT_BIT_STATUS;
      return this;
    }

    /**
     * Builds a new {@link ImmutableJiraIssueFields ImmutableJiraIssueFields}.
     * @return An immutable instance of JiraIssueFields
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableJiraIssueFields build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableJiraIssueFields(issueType, assignee, status);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<String>();
      if ((initBits & INIT_BIT_ISSUE_TYPE) != 0) attributes.add("issueType");
      if ((initBits & INIT_BIT_STATUS) != 0) attributes.add("status");
      return "Cannot build JiraIssueFields, some of required attributes are not set " + attributes;
    }
  }
}
