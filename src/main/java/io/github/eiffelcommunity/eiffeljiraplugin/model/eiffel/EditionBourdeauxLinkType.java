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

import com.google.common.collect.ImmutableSet;

//TODO: Data entry. Fill out remaining targets.
public enum EditionBourdeauxLinkType implements LinkType {
    CAUSE(true, ImmutableSet.copyOf(EditionBordeauxEventType.values())),
    CONTEXT(false, ImmutableSet.of()),
    FLOW_CONTEXT(false, ImmutableSet.of()),
    ACTIVITY_EXECUTION(false, ImmutableSet.of()),
    PREVIOUS_ACTIVITY_EXECUTION(false, ImmutableSet.of()),
    PREVIOUS_VERSION(true, ImmutableSet.of()),
    COMPOSITION(false, ImmutableSet.of()),
    ENVIRONMENT(false, ImmutableSet.of()),
    ARTIFACT(false, ImmutableSet.of()),
    SUBJECT(true, ImmutableSet.of()),
    ELEMENT(true, ImmutableSet.of()),
    BASE(false, ImmutableSet.of()),
    CHANGE(false, ImmutableSet.of()),
    TEST_SUITE_EXECUTION(false, ImmutableSet.of()),
    TEST_CASE_EXECUTION(false, ImmutableSet.of()),
    IUT(false, ImmutableSet.of()),
    TERC(false, ImmutableSet.of()),
    MODIFIED_ANNOUNCEMENT(false, ImmutableSet.of()),
    SUB_CONFIDENCE_LEVEL(true, ImmutableSet.of()),
    REUSED_ARTIFACT(false, ImmutableSet.of()),
    VERIFICATION_BASIS(true, ImmutableSet.of());


    private final boolean multipleAllowed;
    private final ImmutableSet<EventType> legalTargets;

    EditionBourdeauxLinkType(boolean multipleAllowed, ImmutableSet<EventType> legalTargets) {
        this.multipleAllowed = multipleAllowed;
        this.legalTargets = legalTargets;
    }

    public String getName() {
        return this.name();
    }

    public boolean isMultipleAllowed() {
        return multipleAllowed;
    }

    public ImmutableSet<EventType> getLegalTargets() {
        return legalTargets;
    }
}
