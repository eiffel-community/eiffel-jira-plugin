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

import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.assertFalse;

public class EiffelIssueStatusModifiedEventTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    public void defaultMetaHasEmptyOptionalFields() {
        ImmutableEiffelIssueStatusModifiedEventMeta meta = ImmutableEiffelIssueStatusModifiedEventMeta.builder().build();
        assertFalse(meta.source().isPresent());
        assertFalse(meta.tags().isPresent());
    }
}
