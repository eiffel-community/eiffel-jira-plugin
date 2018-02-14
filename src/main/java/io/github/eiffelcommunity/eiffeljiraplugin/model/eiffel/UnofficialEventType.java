/*
 * Copyright 2018 Jaden Young
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.eiffelcommunity.eiffeljiraplugin.model.eiffel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableSet;
import com.google.errorprone.annotations.Immutable;

import java.util.Set;

@Immutable
public enum UnofficialEventType implements EventType {
    @JsonProperty("EiffelIssueDefinedEvent")
    EIFFEL_ISSUE_DEFINED_EVENT("EiffelIssueDefinedEvent", ImmutableSet.of(), ImmutableSet.of());

    private final String name;
    private final ImmutableSet requiredLinkTypes;
    private final ImmutableSet optionalLinkTypes;


    UnofficialEventType(String name, Set<LinkType> requiredLinkTypes, Set<LinkType> optionalLinkTypes) {
        this.name = name;
        this.requiredLinkTypes = ImmutableSet.copyOf(requiredLinkTypes);
        this.optionalLinkTypes = ImmutableSet.copyOf(optionalLinkTypes);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ImmutableSet<LinkType> getRequiredLinkTypes() {
        return requiredLinkTypes;
    }

    @Override
    public ImmutableSet<LinkType> getOptionalLinkTypes() {
        return optionalLinkTypes;
    }
}
