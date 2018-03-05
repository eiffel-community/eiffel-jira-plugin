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
 * Immutable implementation of {@link Assignee}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableAssignee.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "Assignee"})
public final class ImmutableAssignee
    implements Assignee {
  private final String name;
  private final String email;
  private final String id;
  private final String group;

  private ImmutableAssignee(String name, String email, String id, String group) {
    this.name = name;
    this.email = email;
    this.id = id;
    this.group = group;
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
   * @return The value of the {@code email} attribute
   */
  @JsonProperty("email")
  @Override
  public String email() {
    return email;
  }

  /**
   * @return The value of the {@code id} attribute
   */
  @JsonProperty("id")
  @Override
  public String id() {
    return id;
  }

  /**
   * @return The value of the {@code group} attribute
   */
  @JsonProperty("group")
  @Override
  public String group() {
    return group;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Assignee#name() name} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for name
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableAssignee withName(String value) {
    if (this.name.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "name");
    return new ImmutableAssignee(newValue, this.email, this.id, this.group);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Assignee#email() email} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for email
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableAssignee withEmail(String value) {
    if (this.email.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "email");
    return new ImmutableAssignee(this.name, newValue, this.id, this.group);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Assignee#id() id} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for id
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableAssignee withId(String value) {
    if (this.id.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "id");
    return new ImmutableAssignee(this.name, this.email, newValue, this.group);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Assignee#group() group} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for group
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableAssignee withGroup(String value) {
    if (this.group.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "group");
    return new ImmutableAssignee(this.name, this.email, this.id, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableAssignee} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableAssignee
        && equalTo((ImmutableAssignee) another);
  }

  private boolean equalTo(ImmutableAssignee another) {
    return name.equals(another.name)
        && email.equals(another.email)
        && id.equals(another.id)
        && group.equals(another.group);
  }

  /**
   * Computes a hash code from attributes: {@code name}, {@code email}, {@code id}, {@code group}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + name.hashCode();
    h += (h << 5) + email.hashCode();
    h += (h << 5) + id.hashCode();
    h += (h << 5) + group.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code Assignee} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "Assignee{"
        + "name=" + name
        + ", email=" + email
        + ", id=" + id
        + ", group=" + group
        + "}";
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements Assignee {
    String name;
    String email;
    String id;
    String group;
    @JsonProperty("name")
    public void setName(String name) {
      this.name = name;
    }
    @JsonProperty("email")
    public void setEmail(String email) {
      this.email = email;
    }
    @JsonProperty("id")
    public void setId(String id) {
      this.id = id;
    }
    @JsonProperty("group")
    public void setGroup(String group) {
      this.group = group;
    }
    @Override
    public String name() { throw new UnsupportedOperationException(); }
    @Override
    public String email() { throw new UnsupportedOperationException(); }
    @Override
    public String id() { throw new UnsupportedOperationException(); }
    @Override
    public String group() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableAssignee fromJson(Json json) {
    ImmutableAssignee.Builder builder = ImmutableAssignee.builder();
    if (json.name != null) {
      builder.name(json.name);
    }
    if (json.email != null) {
      builder.email(json.email);
    }
    if (json.id != null) {
      builder.id(json.id);
    }
    if (json.group != null) {
      builder.group(json.group);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link Assignee} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Assignee instance
   */
  public static ImmutableAssignee copyOf(Assignee instance) {
    if (instance instanceof ImmutableAssignee) {
      return (ImmutableAssignee) instance;
    }
    return ImmutableAssignee.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableAssignee ImmutableAssignee}.
   * @return A new ImmutableAssignee builder
   */
  public static ImmutableAssignee.Builder builder() {
    return new ImmutableAssignee.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableAssignee ImmutableAssignee}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private static final long INIT_BIT_NAME = 0x1L;
    private static final long INIT_BIT_EMAIL = 0x2L;
    private static final long INIT_BIT_ID = 0x4L;
    private static final long INIT_BIT_GROUP = 0x8L;
    private long initBits = 0xfL;

    private String name;
    private String email;
    private String id;
    private String group;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code Assignee} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(Assignee instance) {
      Objects.requireNonNull(instance, "instance");
      name(instance.name());
      email(instance.email());
      id(instance.id());
      group(instance.group());
      return this;
    }

    /**
     * Initializes the value for the {@link Assignee#name() name} attribute.
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
     * Initializes the value for the {@link Assignee#email() email} attribute.
     * @param email The value for email 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("email")
    public final Builder email(String email) {
      this.email = Objects.requireNonNull(email, "email");
      initBits &= ~INIT_BIT_EMAIL;
      return this;
    }

    /**
     * Initializes the value for the {@link Assignee#id() id} attribute.
     * @param id The value for id 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("id")
    public final Builder id(String id) {
      this.id = Objects.requireNonNull(id, "id");
      initBits &= ~INIT_BIT_ID;
      return this;
    }

    /**
     * Initializes the value for the {@link Assignee#group() group} attribute.
     * @param group The value for group 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("group")
    public final Builder group(String group) {
      this.group = Objects.requireNonNull(group, "group");
      initBits &= ~INIT_BIT_GROUP;
      return this;
    }

    /**
     * Builds a new {@link ImmutableAssignee ImmutableAssignee}.
     * @return An immutable instance of Assignee
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableAssignee build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableAssignee(name, email, id, group);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<String>();
      if ((initBits & INIT_BIT_NAME) != 0) attributes.add("name");
      if ((initBits & INIT_BIT_EMAIL) != 0) attributes.add("email");
      if ((initBits & INIT_BIT_ID) != 0) attributes.add("id");
      if ((initBits & INIT_BIT_GROUP) != 0) attributes.add("group");
      return "Cannot build Assignee, some of required attributes are not set " + attributes;
    }
  }
}
