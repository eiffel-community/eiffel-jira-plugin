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
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link EiffelIssueDefinedEventData}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableEiffelIssueDefinedEventData.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "EiffelIssueDefinedEventData"})
public final class ImmutableEiffelIssueDefinedEventData
    implements EiffelIssueDefinedEventData {
  private final EiffelIssueType type;
  private final String tracker;
  private final URI uri;
  private final String id;

  private ImmutableEiffelIssueDefinedEventData(
      EiffelIssueType type,
      String tracker,
      URI uri,
      String id) {
    this.type = type;
    this.tracker = tracker;
    this.uri = uri;
    this.id = id;
  }

  /**
   * @return The value of the {@code type} attribute
   */
  @JsonProperty("type")
  @Override
  public EiffelIssueType type() {
    return type;
  }

  /**
   * @return The value of the {@code tracker} attribute
   */
  @JsonProperty("tracker")
  @Override
  public String tracker() {
    return tracker;
  }

  /**
   * @return The value of the {@code uri} attribute
   */
  @JsonProperty("uri")
  @Override
  public URI uri() {
    return uri;
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
   * Copy the current immutable object by setting a value for the {@link EiffelIssueDefinedEventData#type() type} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for type
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableEiffelIssueDefinedEventData withType(EiffelIssueType value) {
    if (this.type == value) return this;
    EiffelIssueType newValue = Objects.requireNonNull(value, "type");
    return new ImmutableEiffelIssueDefinedEventData(newValue, this.tracker, this.uri, this.id);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link EiffelIssueDefinedEventData#tracker() tracker} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for tracker
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableEiffelIssueDefinedEventData withTracker(String value) {
    if (this.tracker.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "tracker");
    return new ImmutableEiffelIssueDefinedEventData(this.type, newValue, this.uri, this.id);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link EiffelIssueDefinedEventData#uri() uri} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for uri
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableEiffelIssueDefinedEventData withUri(URI value) {
    if (this.uri == value) return this;
    URI newValue = Objects.requireNonNull(value, "uri");
    return new ImmutableEiffelIssueDefinedEventData(this.type, this.tracker, newValue, this.id);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link EiffelIssueDefinedEventData#id() id} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for id
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableEiffelIssueDefinedEventData withId(String value) {
    if (this.id.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "id");
    return new ImmutableEiffelIssueDefinedEventData(this.type, this.tracker, this.uri, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableEiffelIssueDefinedEventData} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableEiffelIssueDefinedEventData
        && equalTo((ImmutableEiffelIssueDefinedEventData) another);
  }

  private boolean equalTo(ImmutableEiffelIssueDefinedEventData another) {
    return type.equals(another.type)
        && tracker.equals(another.tracker)
        && uri.equals(another.uri)
        && id.equals(another.id);
  }

  /**
   * Computes a hash code from attributes: {@code type}, {@code tracker}, {@code uri}, {@code id}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + type.hashCode();
    h += (h << 5) + tracker.hashCode();
    h += (h << 5) + uri.hashCode();
    h += (h << 5) + id.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code EiffelIssueDefinedEventData} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "EiffelIssueDefinedEventData{"
        + "type=" + type
        + ", tracker=" + tracker
        + ", uri=" + uri
        + ", id=" + id
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
      implements EiffelIssueDefinedEventData {
    EiffelIssueType type;
    String tracker;
    URI uri;
    String id;
    @JsonProperty("type")
    public void setType(EiffelIssueType type) {
      this.type = type;
    }
    @JsonProperty("tracker")
    public void setTracker(String tracker) {
      this.tracker = tracker;
    }
    @JsonProperty("uri")
    public void setUri(URI uri) {
      this.uri = uri;
    }
    @JsonProperty("id")
    public void setId(String id) {
      this.id = id;
    }
    @Override
    public EiffelIssueType type() { throw new UnsupportedOperationException(); }
    @Override
    public String tracker() { throw new UnsupportedOperationException(); }
    @Override
    public URI uri() { throw new UnsupportedOperationException(); }
    @Override
    public String id() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableEiffelIssueDefinedEventData fromJson(Json json) {
    ImmutableEiffelIssueDefinedEventData.Builder builder = ImmutableEiffelIssueDefinedEventData.builder();
    if (json.type != null) {
      builder.type(json.type);
    }
    if (json.tracker != null) {
      builder.tracker(json.tracker);
    }
    if (json.uri != null) {
      builder.uri(json.uri);
    }
    if (json.id != null) {
      builder.id(json.id);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link EiffelIssueDefinedEventData} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable EiffelIssueDefinedEventData instance
   */
  public static ImmutableEiffelIssueDefinedEventData copyOf(EiffelIssueDefinedEventData instance) {
    if (instance instanceof ImmutableEiffelIssueDefinedEventData) {
      return (ImmutableEiffelIssueDefinedEventData) instance;
    }
    return ImmutableEiffelIssueDefinedEventData.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableEiffelIssueDefinedEventData ImmutableEiffelIssueDefinedEventData}.
   * @return A new ImmutableEiffelIssueDefinedEventData builder
   */
  public static ImmutableEiffelIssueDefinedEventData.Builder builder() {
    return new ImmutableEiffelIssueDefinedEventData.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableEiffelIssueDefinedEventData ImmutableEiffelIssueDefinedEventData}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private static final long INIT_BIT_TYPE = 0x1L;
    private static final long INIT_BIT_TRACKER = 0x2L;
    private static final long INIT_BIT_URI = 0x4L;
    private static final long INIT_BIT_ID = 0x8L;
    private long initBits = 0xfL;

    private EiffelIssueType type;
    private String tracker;
    private URI uri;
    private String id;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code EiffelIssueDefinedEventData} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(EiffelIssueDefinedEventData instance) {
      Objects.requireNonNull(instance, "instance");
      type(instance.type());
      tracker(instance.tracker());
      uri(instance.uri());
      id(instance.id());
      return this;
    }

    /**
     * Initializes the value for the {@link EiffelIssueDefinedEventData#type() type} attribute.
     * @param type The value for type 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("type")
    public final Builder type(EiffelIssueType type) {
      this.type = Objects.requireNonNull(type, "type");
      initBits &= ~INIT_BIT_TYPE;
      return this;
    }

    /**
     * Initializes the value for the {@link EiffelIssueDefinedEventData#tracker() tracker} attribute.
     * @param tracker The value for tracker 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("tracker")
    public final Builder tracker(String tracker) {
      this.tracker = Objects.requireNonNull(tracker, "tracker");
      initBits &= ~INIT_BIT_TRACKER;
      return this;
    }

    /**
     * Initializes the value for the {@link EiffelIssueDefinedEventData#uri() uri} attribute.
     * @param uri The value for uri 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("uri")
    public final Builder uri(URI uri) {
      this.uri = Objects.requireNonNull(uri, "uri");
      initBits &= ~INIT_BIT_URI;
      return this;
    }

    /**
     * Initializes the value for the {@link EiffelIssueDefinedEventData#id() id} attribute.
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
     * Builds a new {@link ImmutableEiffelIssueDefinedEventData ImmutableEiffelIssueDefinedEventData}.
     * @return An immutable instance of EiffelIssueDefinedEventData
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableEiffelIssueDefinedEventData build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableEiffelIssueDefinedEventData(type, tracker, uri, id);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<String>();
      if ((initBits & INIT_BIT_TYPE) != 0) attributes.add("type");
      if ((initBits & INIT_BIT_TRACKER) != 0) attributes.add("tracker");
      if ((initBits & INIT_BIT_URI) != 0) attributes.add("uri");
      if ((initBits & INIT_BIT_ID) != 0) attributes.add("id");
      return "Cannot build EiffelIssueDefinedEventData, some of required attributes are not set " + attributes;
    }
  }
}
