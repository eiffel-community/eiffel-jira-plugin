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

package com.github.eiffelcommunity.eiffeljiraplugin.annotations;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;


/*
    Having @JsonInclude(JsonInclude.Include.NON_ABSENT) should make jackson ignore
    absent fields, but it doesn't. Even manually specifying on the generated implementation
    class, jackson still ignores the annotation. In this application we're relying on configuring
    the ObjectMapper directly to ignore absent fields.
 */
@JsonSerialize
@JsonDeserialize
@Value.Style(
        additionalJsonAnnotations = {JsonInclude.class}
)
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public @interface EiffelStyleImmutable {
}
