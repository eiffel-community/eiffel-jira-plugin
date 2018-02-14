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

public enum UnofficialLinkType implements LinkType {
    ISSUE(true, UnofficialEventType.EIFFEL_ISSUE_DEFINED_EVENT);


    private final boolean multipleAllowed;
    private final ImmutableSet<EventType> legalTargets;

    UnofficialLinkType(boolean multipleAllowed, ImmutableSet<EventType> legalTargets) {
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
