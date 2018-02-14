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

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import com.vdurmont.semver4j.Semver;
import io.github.eiffelcommunity.eiffeljiraplugin.model.EiffelStyleImmutable;
import org.immutables.value.Value;


@Value.Immutable
@EiffelStyleImmutable
@JsonSerialize(as = ImmutableEiffelIssueDefinedEvent100Meta.class)
@JsonDeserialize(builder = EiffelIssueDefinedEvent100Meta.Builder.class)
public abstract class EiffelIssueDefinedEvent100Meta implements Meta100 {
    private final static EventType type = UnofficialEventType.EIFFEL_ISSUE_DEFINED_EVENT;
    private final static Semver version = new Semver("1.0.0");

    @Override
    @Value.Default
    public EventType getType() {
        return type;
    }

    @Override
    @Value.Default
    public Semver getVersion() {
        return version;
    }

    @Value.Check
    protected void check() {
        Preconditions.checkState(type.equals(getType()));
        Preconditions.checkState(version.equals(getVersion()));
    }

    public static class Builder extends ImmutableEiffelIssueDefinedEvent100Meta.Builder {
    }
}
