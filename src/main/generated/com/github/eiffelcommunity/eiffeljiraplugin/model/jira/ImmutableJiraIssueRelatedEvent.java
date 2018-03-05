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
 * Immutable implementation of {@link JiraIssueRelatedEvent}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableJiraIssueRelatedEvent.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "JiraIssueRelatedEvent"})
@JsonIgnoreProperties(ignoreUnknown = true)
public final class ImmutableJiraIssueRelatedEvent
    implements JiraIssueRelatedEvent {
  private final JiraWebhookEventType webhookEventType;
  private final String issueEventType;
  private final ImmutableJiraIssue issue;

  private ImmutableJiraIssueRelatedEvent(
      JiraWebhookEventType webhookEventType,
      String issueEventType,
      ImmutableJiraIssue issue) {
    this.webhookEventType = webhookEventType;
    this.issueEventType = issueEventType;
    this.issue = issue;
  }

  /**
   * @return The value of the {@code webhookEventType} attribute
   */
  @JsonProperty("webhookEvent")
  @Override
  public JiraWebhookEventType webhookEventType() {
    return webhookEventType;
  }

  /**
   * @return The value of the {@code issueEventType} attribute
   */
  @JsonProperty("issue_event_type_name")
  @Override
  public String issueEventType() {
    return issueEventType;
  }

  /**
   * @return The value of the {@code issue} attribute
   */
  @JsonProperty("issue")
  @Override
  public ImmutableJiraIssue issue() {
    return issue;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link JiraIssueRelatedEvent#webhookEventType() webhookEventType} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for webhookEventType
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableJiraIssueRelatedEvent withWebhookEventType(JiraWebhookEventType value) {
    if (this.webhookEventType == value) return this;
    JiraWebhookEventType newValue = Objects.requireNonNull(value, "webhookEventType");
    return new ImmutableJiraIssueRelatedEvent(newValue, this.issueEventType, this.issue);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link JiraIssueRelatedEvent#issueEventType() issueEventType} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for issueEventType
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableJiraIssueRelatedEvent withIssueEventType(String value) {
    if (this.issueEventType.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "issueEventType");
    return new ImmutableJiraIssueRelatedEvent(this.webhookEventType, newValue, this.issue);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link JiraIssueRelatedEvent#issue() issue} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for issue
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableJiraIssueRelatedEvent withIssue(ImmutableJiraIssue value) {
    if (this.issue == value) return this;
    ImmutableJiraIssue newValue = Objects.requireNonNull(value, "issue");
    return new ImmutableJiraIssueRelatedEvent(this.webhookEventType, this.issueEventType, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableJiraIssueRelatedEvent} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableJiraIssueRelatedEvent
        && equalTo((ImmutableJiraIssueRelatedEvent) another);
  }

  private boolean equalTo(ImmutableJiraIssueRelatedEvent another) {
    return webhookEventType.equals(another.webhookEventType)
        && issueEventType.equals(another.issueEventType)
        && issue.equals(another.issue);
  }

  /**
   * Computes a hash code from attributes: {@code webhookEventType}, {@code issueEventType}, {@code issue}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + webhookEventType.hashCode();
    h += (h << 5) + issueEventType.hashCode();
    h += (h << 5) + issue.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code JiraIssueRelatedEvent} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "JiraIssueRelatedEvent{"
        + "webhookEventType=" + webhookEventType
        + ", issueEventType=" + issueEventType
        + ", issue=" + issue
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
      implements JiraIssueRelatedEvent {
    JiraWebhookEventType webhookEventType;
    String issueEventType;
    ImmutableJiraIssue issue;
    @JsonProperty("webhookEvent")
    public void setWebhookEventType(JiraWebhookEventType webhookEventType) {
      this.webhookEventType = webhookEventType;
    }
    @JsonProperty("issue_event_type_name")
    public void setIssueEventType(String issueEventType) {
      this.issueEventType = issueEventType;
    }
    @JsonProperty("issue")
    public void setIssue(ImmutableJiraIssue issue) {
      this.issue = issue;
    }
    @Override
    public JiraWebhookEventType webhookEventType() { throw new UnsupportedOperationException(); }
    @Override
    public String issueEventType() { throw new UnsupportedOperationException(); }
    @Override
    public ImmutableJiraIssue issue() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableJiraIssueRelatedEvent fromJson(Json json) {
    ImmutableJiraIssueRelatedEvent.Builder builder = ImmutableJiraIssueRelatedEvent.builder();
    if (json.webhookEventType != null) {
      builder.webhookEventType(json.webhookEventType);
    }
    if (json.issueEventType != null) {
      builder.issueEventType(json.issueEventType);
    }
    if (json.issue != null) {
      builder.issue(json.issue);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link JiraIssueRelatedEvent} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable JiraIssueRelatedEvent instance
   */
  public static ImmutableJiraIssueRelatedEvent copyOf(JiraIssueRelatedEvent instance) {
    if (instance instanceof ImmutableJiraIssueRelatedEvent) {
      return (ImmutableJiraIssueRelatedEvent) instance;
    }
    return ImmutableJiraIssueRelatedEvent.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableJiraIssueRelatedEvent ImmutableJiraIssueRelatedEvent}.
   * @return A new ImmutableJiraIssueRelatedEvent builder
   */
  public static ImmutableJiraIssueRelatedEvent.Builder builder() {
    return new ImmutableJiraIssueRelatedEvent.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableJiraIssueRelatedEvent ImmutableJiraIssueRelatedEvent}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private static final long INIT_BIT_WEBHOOK_EVENT_TYPE = 0x1L;
    private static final long INIT_BIT_ISSUE_EVENT_TYPE = 0x2L;
    private static final long INIT_BIT_ISSUE = 0x4L;
    private long initBits = 0x7L;

    private JiraWebhookEventType webhookEventType;
    private String issueEventType;
    private ImmutableJiraIssue issue;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code JiraIssueRelatedEvent} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(JiraIssueRelatedEvent instance) {
      Objects.requireNonNull(instance, "instance");
      webhookEventType(instance.webhookEventType());
      issueEventType(instance.issueEventType());
      issue(instance.issue());
      return this;
    }

    /**
     * Initializes the value for the {@link JiraIssueRelatedEvent#webhookEventType() webhookEventType} attribute.
     * @param webhookEventType The value for webhookEventType 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("webhookEvent")
    public final Builder webhookEventType(JiraWebhookEventType webhookEventType) {
      this.webhookEventType = Objects.requireNonNull(webhookEventType, "webhookEventType");
      initBits &= ~INIT_BIT_WEBHOOK_EVENT_TYPE;
      return this;
    }

    /**
     * Initializes the value for the {@link JiraIssueRelatedEvent#issueEventType() issueEventType} attribute.
     * @param issueEventType The value for issueEventType 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("issue_event_type_name")
    public final Builder issueEventType(String issueEventType) {
      this.issueEventType = Objects.requireNonNull(issueEventType, "issueEventType");
      initBits &= ~INIT_BIT_ISSUE_EVENT_TYPE;
      return this;
    }

    /**
     * Initializes the value for the {@link JiraIssueRelatedEvent#issue() issue} attribute.
     * @param issue The value for issue 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("issue")
    public final Builder issue(ImmutableJiraIssue issue) {
      this.issue = Objects.requireNonNull(issue, "issue");
      initBits &= ~INIT_BIT_ISSUE;
      return this;
    }

    /**
     * Builds a new {@link ImmutableJiraIssueRelatedEvent ImmutableJiraIssueRelatedEvent}.
     * @return An immutable instance of JiraIssueRelatedEvent
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableJiraIssueRelatedEvent build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableJiraIssueRelatedEvent(webhookEventType, issueEventType, issue);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<String>();
      if ((initBits & INIT_BIT_WEBHOOK_EVENT_TYPE) != 0) attributes.add("webhookEventType");
      if ((initBits & INIT_BIT_ISSUE_EVENT_TYPE) != 0) attributes.add("issueEventType");
      if ((initBits & INIT_BIT_ISSUE) != 0) attributes.add("issue");
      return "Cannot build JiraIssueRelatedEvent, some of required attributes are not set " + attributes;
    }
  }
}
