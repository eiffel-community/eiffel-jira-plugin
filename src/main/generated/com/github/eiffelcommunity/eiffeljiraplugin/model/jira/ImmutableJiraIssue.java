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
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link JiraIssue}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableJiraIssue.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "JiraIssue"})
@JsonIgnoreProperties(ignoreUnknown = true)
public final class ImmutableJiraIssue
    implements JiraIssue {
  private final String id;
  private final URI self;
  private final ImmutableJiraIssueFields fields;

  private ImmutableJiraIssue(
      String id,
      URI self,
      ImmutableJiraIssueFields fields) {
    this.id = id;
    this.self = self;
    this.fields = fields;
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
   * @return The value of the {@code self} attribute
   */
  @JsonProperty("self")
  @Override
  public URI self() {
    return self;
  }

  /**
   * @return The value of the {@code fields} attribute
   */
  @JsonProperty("fields")
  @Override
  public ImmutableJiraIssueFields fields() {
    return fields;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link JiraIssue#id() id} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for id
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableJiraIssue withId(String value) {
    if (this.id.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "id");
    return new ImmutableJiraIssue(newValue, this.self, this.fields);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link JiraIssue#self() self} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for self
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableJiraIssue withSelf(URI value) {
    if (this.self == value) return this;
    URI newValue = Objects.requireNonNull(value, "self");
    return new ImmutableJiraIssue(this.id, newValue, this.fields);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link JiraIssue#fields() fields} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for fields
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableJiraIssue withFields(ImmutableJiraIssueFields value) {
    if (this.fields == value) return this;
    ImmutableJiraIssueFields newValue = Objects.requireNonNull(value, "fields");
    return new ImmutableJiraIssue(this.id, this.self, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableJiraIssue} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableJiraIssue
        && equalTo((ImmutableJiraIssue) another);
  }

  private boolean equalTo(ImmutableJiraIssue another) {
    return id.equals(another.id)
        && self.equals(another.self)
        && fields.equals(another.fields);
  }

  /**
   * Computes a hash code from attributes: {@code id}, {@code self}, {@code fields}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + id.hashCode();
    h += (h << 5) + self.hashCode();
    h += (h << 5) + fields.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code JiraIssue} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "JiraIssue{"
        + "id=" + id
        + ", self=" + self
        + ", fields=" + fields
        + "}";
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements JiraIssue {
    String id;
    URI self;
    ImmutableJiraIssueFields fields;
    @JsonProperty("id")
    public void setId(String id) {
      this.id = id;
    }
    @JsonProperty("self")
    public void setSelf(URI self) {
      this.self = self;
    }
    @JsonProperty("fields")
    public void setFields(ImmutableJiraIssueFields fields) {
      this.fields = fields;
    }
    @Override
    public String id() { throw new UnsupportedOperationException(); }
    @Override
    public URI self() { throw new UnsupportedOperationException(); }
    @Override
    public ImmutableJiraIssueFields fields() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableJiraIssue fromJson(Json json) {
    ImmutableJiraIssue.Builder builder = ImmutableJiraIssue.builder();
    if (json.id != null) {
      builder.id(json.id);
    }
    if (json.self != null) {
      builder.self(json.self);
    }
    if (json.fields != null) {
      builder.fields(json.fields);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link JiraIssue} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable JiraIssue instance
   */
  public static ImmutableJiraIssue copyOf(JiraIssue instance) {
    if (instance instanceof ImmutableJiraIssue) {
      return (ImmutableJiraIssue) instance;
    }
    return ImmutableJiraIssue.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableJiraIssue ImmutableJiraIssue}.
   * @return A new ImmutableJiraIssue builder
   */
  public static ImmutableJiraIssue.Builder builder() {
    return new ImmutableJiraIssue.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableJiraIssue ImmutableJiraIssue}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private static final long INIT_BIT_ID = 0x1L;
    private static final long INIT_BIT_SELF = 0x2L;
    private static final long INIT_BIT_FIELDS = 0x4L;
    private long initBits = 0x7L;

    private String id;
    private URI self;
    private ImmutableJiraIssueFields fields;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code JiraIssue} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(JiraIssue instance) {
      Objects.requireNonNull(instance, "instance");
      id(instance.id());
      self(instance.self());
      fields(instance.fields());
      return this;
    }

    /**
     * Initializes the value for the {@link JiraIssue#id() id} attribute.
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
     * Initializes the value for the {@link JiraIssue#self() self} attribute.
     * @param self The value for self 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("self")
    public final Builder self(URI self) {
      this.self = Objects.requireNonNull(self, "self");
      initBits &= ~INIT_BIT_SELF;
      return this;
    }

    /**
     * Initializes the value for the {@link JiraIssue#fields() fields} attribute.
     * @param fields The value for fields 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("fields")
    public final Builder fields(ImmutableJiraIssueFields fields) {
      this.fields = Objects.requireNonNull(fields, "fields");
      initBits &= ~INIT_BIT_FIELDS;
      return this;
    }

    /**
     * Builds a new {@link ImmutableJiraIssue ImmutableJiraIssue}.
     * @return An immutable instance of JiraIssue
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableJiraIssue build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableJiraIssue(id, self, fields);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<String>();
      if ((initBits & INIT_BIT_ID) != 0) attributes.add("id");
      if ((initBits & INIT_BIT_SELF) != 0) attributes.add("self");
      if ((initBits & INIT_BIT_FIELDS) != 0) attributes.add("fields");
      return "Cannot build JiraIssue, some of required attributes are not set " + attributes;
    }
  }
}
