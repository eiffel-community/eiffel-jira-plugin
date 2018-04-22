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

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EiffelIssueDefinedEventTest {

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void defaultMetaHasEmptyOptionalFields() {
        ImmutableEiffelIssueDefinedEventMeta meta = ImmutableEiffelIssueDefinedEventMeta.builder().build();
        assertFalse(meta.source().isPresent());
        assertFalse(meta.tags().isPresent());
    }

    @Test
    public void jacksonOmitsEmptyOptionalsEntirely() throws Exception {
        ImmutableEiffelIssueDefinedEvent event = ImmutableEiffelIssueDefinedEvent.builder()
                .meta(ImmutableEiffelIssueDefinedEventMeta.builder().source(Optional.empty()).build())
                .data(ImmutableEiffelIssueDefinedEventData.builder()
                        .id("wish")
                        .tracker("you could mock")
                        .type(EiffelIssueType.OTHER)
                        .uri(URI.create("https://final-class.com"))
                        .build())
                .build();
        String json = mapper.writeValueAsString(event);
        JsonNode root = mapper.readTree(json);
        assertThat(root.path("meta").has("source"), is(false));
        assertThat(root.path("meta").has("tags"), is(false));
    }
}
