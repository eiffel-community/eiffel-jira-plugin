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

import com.github.eiffelcommunity.eiffeljiraplugin.annotations.EiffelStyleImmutable;
import org.immutables.value.Value;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Value.Immutable
@EiffelStyleImmutable
public interface EiffelIssueStatusModifiedEventMeta extends Meta {
    @Value.Default
    default UUID id() {
        return UUID.randomUUID();
    }

    @Value.Default
    default long time() {
        return System.currentTimeMillis();
    }

    @Value.Derived
    default String type() {
        return "EiffelIssueStatusModifiedEvent";
    }

    // TODO: Consider possible solutions to versioning.
    @Value.Derived
    default String version() {
        return "1.0.0";
    }

    Optional<List<String>> tags();

    Optional<ImmutableSource> source();
}
