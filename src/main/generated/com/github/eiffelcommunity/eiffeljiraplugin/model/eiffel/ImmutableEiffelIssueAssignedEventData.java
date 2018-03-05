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
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link EiffelIssueAssignedEventData}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableEiffelIssueAssignedEventData.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "EiffelIssueAssignedEventData"})
public final class ImmutableEiffelIssueAssignedEventData
    implements EiffelIssueAssignedEventData {
  private final List<Assignee> assignees;

  private ImmutableEiffelIssueAssignedEventData(List<Assignee> assignees) {
    this.assignees = assignees;
  }

  /**
   * @return The value of the {@code assignees} attribute
   */
  @JsonProperty("assignees")
  @Override
  public List<Assignee> assignees() {
    return assignees;
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link EiffelIssueAssignedEventData#assignees() assignees}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableEiffelIssueAssignedEventData withAssignees(Assignee... elements) {
    List<Assignee> newValue = createUnmodifiableList(false, createSafeList(Arrays.asList(elements), true, false));
    return new ImmutableEiffelIssueAssignedEventData(newValue);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link EiffelIssueAssignedEventData#assignees() assignees}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of assignees elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableEiffelIssueAssignedEventData withAssignees(Iterable<? extends Assignee> elements) {
    if (this.assignees == elements) return this;
    List<Assignee> newValue = createUnmodifiableList(false, createSafeList(elements, true, false));
    return new ImmutableEiffelIssueAssignedEventData(newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableEiffelIssueAssignedEventData} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableEiffelIssueAssignedEventData
        && equalTo((ImmutableEiffelIssueAssignedEventData) another);
  }

  private boolean equalTo(ImmutableEiffelIssueAssignedEventData another) {
    return assignees.equals(another.assignees);
  }

  /**
   * Computes a hash code from attributes: {@code assignees}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + assignees.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code EiffelIssueAssignedEventData} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "EiffelIssueAssignedEventData{"
        + "assignees=" + assignees
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
      implements EiffelIssueAssignedEventData {
    List<Assignee> assignees = Collections.emptyList();
    @JsonProperty("assignees")
    public void setAssignees(List<Assignee> assignees) {
      this.assignees = assignees;
    }
    @Override
    public List<Assignee> assignees() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableEiffelIssueAssignedEventData fromJson(Json json) {
    ImmutableEiffelIssueAssignedEventData.Builder builder = ImmutableEiffelIssueAssignedEventData.builder();
    if (json.assignees != null) {
      builder.addAllAssignees(json.assignees);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link EiffelIssueAssignedEventData} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable EiffelIssueAssignedEventData instance
   */
  public static ImmutableEiffelIssueAssignedEventData copyOf(EiffelIssueAssignedEventData instance) {
    if (instance instanceof ImmutableEiffelIssueAssignedEventData) {
      return (ImmutableEiffelIssueAssignedEventData) instance;
    }
    return ImmutableEiffelIssueAssignedEventData.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableEiffelIssueAssignedEventData ImmutableEiffelIssueAssignedEventData}.
   * @return A new ImmutableEiffelIssueAssignedEventData builder
   */
  public static ImmutableEiffelIssueAssignedEventData.Builder builder() {
    return new ImmutableEiffelIssueAssignedEventData.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableEiffelIssueAssignedEventData ImmutableEiffelIssueAssignedEventData}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private List<Assignee> assignees = new ArrayList<Assignee>();

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code EiffelIssueAssignedEventData} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(EiffelIssueAssignedEventData instance) {
      Objects.requireNonNull(instance, "instance");
      addAllAssignees(instance.assignees());
      return this;
    }

    /**
     * Adds one element to {@link EiffelIssueAssignedEventData#assignees() assignees} list.
     * @param element A assignees element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAssignees(Assignee element) {
      this.assignees.add(Objects.requireNonNull(element, "assignees element"));
      return this;
    }

    /**
     * Adds elements to {@link EiffelIssueAssignedEventData#assignees() assignees} list.
     * @param elements An array of assignees elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAssignees(Assignee... elements) {
      for (Assignee element : elements) {
        this.assignees.add(Objects.requireNonNull(element, "assignees element"));
      }
      return this;
    }

    /**
     * Sets or replaces all elements for {@link EiffelIssueAssignedEventData#assignees() assignees} list.
     * @param elements An iterable of assignees elements
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("assignees")
    public final Builder assignees(Iterable<? extends Assignee> elements) {
      this.assignees.clear();
      return addAllAssignees(elements);
    }

    /**
     * Adds elements to {@link EiffelIssueAssignedEventData#assignees() assignees} list.
     * @param elements An iterable of assignees elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllAssignees(Iterable<? extends Assignee> elements) {
      for (Assignee element : elements) {
        this.assignees.add(Objects.requireNonNull(element, "assignees element"));
      }
      return this;
    }

    /**
     * Builds a new {@link ImmutableEiffelIssueAssignedEventData ImmutableEiffelIssueAssignedEventData}.
     * @return An immutable instance of EiffelIssueAssignedEventData
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableEiffelIssueAssignedEventData build() {
      return new ImmutableEiffelIssueAssignedEventData(createUnmodifiableList(true, assignees));
    }
  }

  private static <T> List<T> createSafeList(Iterable<? extends T> iterable, boolean checkNulls, boolean skipNulls) {
    ArrayList<T> list;
    if (iterable instanceof Collection<?>) {
      int size = ((Collection<?>) iterable).size();
      if (size == 0) return Collections.emptyList();
      list = new ArrayList<T>();
    } else {
      list = new ArrayList<T>();
    }
    for (T element : iterable) {
      if (skipNulls && element == null) continue;
      if (checkNulls) Objects.requireNonNull(element, "element");
      list.add(element);
    }
    return list;
  }

  private static <T> List<T> createUnmodifiableList(boolean clone, List<T> list) {
    switch(list.size()) {
    case 0: return Collections.emptyList();
    case 1: return Collections.singletonList(list.get(0));
    default:
      if (clone) {
        return Collections.unmodifiableList(new ArrayList<T>(list));
      } else {
        if (list instanceof ArrayList<?>) {
          ((ArrayList<?>) list).trimToSize();
        }
        return Collections.unmodifiableList(list);
      }
    }
  }
}
