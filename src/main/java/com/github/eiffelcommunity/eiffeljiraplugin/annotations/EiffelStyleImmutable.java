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

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/*
    Jackson JsonInclude(Include = INCLUDE.NON_ABSENT ) SHOULD make it so that empty Optional
    fields are totally ignored when serializing, but instead they keep getting serialized as
    null. Giving up for now, we can go with all fields being present during serialization but
    possibly nullable.
 */
@JsonSerialize
@JsonDeserialize
public @interface EiffelStyleImmutable {
}
