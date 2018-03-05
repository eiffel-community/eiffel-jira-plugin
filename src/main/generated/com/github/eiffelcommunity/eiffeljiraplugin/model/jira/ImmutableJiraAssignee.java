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
 * Immutable implementation of {@link JiraAssignee}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableJiraAssignee.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "JiraAssignee"})
@JsonIgnoreProperties(ignoreUnknown = true)
public final class ImmutableJiraAssignee
    implements JiraAssignee {
  private final String emailAddress;
  private final String displayName;
  private final String username;

  private ImmutableJiraAssignee(String emailAddress, String displayName, String username) {
    this.emailAddress = emailAddress;
    this.displayName = displayName;
    this.username = username;
  }

  /**
   * @return The value of the {@code emailAddress} attribute
   */
  @JsonProperty("emailAddress")
  @Override
  public String emailAddress() {
    return emailAddress;
  }

  /**
   * @return The value of the {@code displayName} attribute
   */
  @JsonProperty("displayName")
  @Override
  public String displayName() {
    return displayName;
  }

  /**
   * @return The value of the {@code username} attribute
   */
  @JsonProperty("name")
  @Override
  public String username() {
    return username;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link JiraAssignee#emailAddress() emailAddress} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for emailAddress
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableJiraAssignee withEmailAddress(String value) {
    if (this.emailAddress.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "emailAddress");
    return new ImmutableJiraAssignee(newValue, this.displayName, this.username);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link JiraAssignee#displayName() displayName} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for displayName
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableJiraAssignee withDisplayName(String value) {
    if (this.displayName.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "displayName");
    return new ImmutableJiraAssignee(this.emailAddress, newValue, this.username);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link JiraAssignee#username() username} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for username
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableJiraAssignee withUsername(String value) {
    if (this.username.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "username");
    return new ImmutableJiraAssignee(this.emailAddress, this.displayName, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableJiraAssignee} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableJiraAssignee
        && equalTo((ImmutableJiraAssignee) another);
  }

  private boolean equalTo(ImmutableJiraAssignee another) {
    return emailAddress.equals(another.emailAddress)
        && displayName.equals(another.displayName)
        && username.equals(another.username);
  }

  /**
   * Computes a hash code from attributes: {@code emailAddress}, {@code displayName}, {@code username}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + emailAddress.hashCode();
    h += (h << 5) + displayName.hashCode();
    h += (h << 5) + username.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code JiraAssignee} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "JiraAssignee{"
        + "emailAddress=" + emailAddress
        + ", displayName=" + displayName
        + ", username=" + username
        + "}";
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements JiraAssignee {
    String emailAddress;
    String displayName;
    String username;
    @JsonProperty("emailAddress")
    public void setEmailAddress(String emailAddress) {
      this.emailAddress = emailAddress;
    }
    @JsonProperty("displayName")
    public void setDisplayName(String displayName) {
      this.displayName = displayName;
    }
    @JsonProperty("name")
    public void setUsername(String username) {
      this.username = username;
    }
    @Override
    public String emailAddress() { throw new UnsupportedOperationException(); }
    @Override
    public String displayName() { throw new UnsupportedOperationException(); }
    @Override
    public String username() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableJiraAssignee fromJson(Json json) {
    ImmutableJiraAssignee.Builder builder = ImmutableJiraAssignee.builder();
    if (json.emailAddress != null) {
      builder.emailAddress(json.emailAddress);
    }
    if (json.displayName != null) {
      builder.displayName(json.displayName);
    }
    if (json.username != null) {
      builder.username(json.username);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link JiraAssignee} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable JiraAssignee instance
   */
  public static ImmutableJiraAssignee copyOf(JiraAssignee instance) {
    if (instance instanceof ImmutableJiraAssignee) {
      return (ImmutableJiraAssignee) instance;
    }
    return ImmutableJiraAssignee.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableJiraAssignee ImmutableJiraAssignee}.
   * @return A new ImmutableJiraAssignee builder
   */
  public static ImmutableJiraAssignee.Builder builder() {
    return new ImmutableJiraAssignee.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableJiraAssignee ImmutableJiraAssignee}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private static final long INIT_BIT_EMAIL_ADDRESS = 0x1L;
    private static final long INIT_BIT_DISPLAY_NAME = 0x2L;
    private static final long INIT_BIT_USERNAME = 0x4L;
    private long initBits = 0x7L;

    private String emailAddress;
    private String displayName;
    private String username;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code JiraAssignee} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(JiraAssignee instance) {
      Objects.requireNonNull(instance, "instance");
      emailAddress(instance.emailAddress());
      displayName(instance.displayName());
      username(instance.username());
      return this;
    }

    /**
     * Initializes the value for the {@link JiraAssignee#emailAddress() emailAddress} attribute.
     * @param emailAddress The value for emailAddress 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("emailAddress")
    public final Builder emailAddress(String emailAddress) {
      this.emailAddress = Objects.requireNonNull(emailAddress, "emailAddress");
      initBits &= ~INIT_BIT_EMAIL_ADDRESS;
      return this;
    }

    /**
     * Initializes the value for the {@link JiraAssignee#displayName() displayName} attribute.
     * @param displayName The value for displayName 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("displayName")
    public final Builder displayName(String displayName) {
      this.displayName = Objects.requireNonNull(displayName, "displayName");
      initBits &= ~INIT_BIT_DISPLAY_NAME;
      return this;
    }

    /**
     * Initializes the value for the {@link JiraAssignee#username() username} attribute.
     * @param username The value for username 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("name")
    public final Builder username(String username) {
      this.username = Objects.requireNonNull(username, "username");
      initBits &= ~INIT_BIT_USERNAME;
      return this;
    }

    /**
     * Builds a new {@link ImmutableJiraAssignee ImmutableJiraAssignee}.
     * @return An immutable instance of JiraAssignee
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableJiraAssignee build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableJiraAssignee(emailAddress, displayName, username);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<String>();
      if ((initBits & INIT_BIT_EMAIL_ADDRESS) != 0) attributes.add("emailAddress");
      if ((initBits & INIT_BIT_DISPLAY_NAME) != 0) attributes.add("displayName");
      if ((initBits & INIT_BIT_USERNAME) != 0) attributes.add("username");
      return "Cannot build JiraAssignee, some of required attributes are not set " + attributes;
    }
  }
}
