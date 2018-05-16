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

package com.github.eiffelcommunity.eiffeljiraplugin.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.eiffelcommunity.eiffeljiraplugin.SharedTestConstants;
import com.github.eiffelcommunity.eiffeljiraplugin.model.eiffel.EiffelIssueType;
import com.github.eiffelcommunity.eiffeljiraplugin.model.eiffel.ImmutableEiffelIssueDefinedEvent;
import com.github.eiffelcommunity.eiffeljiraplugin.model.eiffel.ImmutableEiffelIssueDefinedEventData;
import com.github.eiffelcommunity.eiffeljiraplugin.model.eiffel.ImmutableEiffelIssueDefinedEventMeta;
import com.github.eiffelcommunity.eiffeljiraplugin.model.jira.ImmutableJiraIssueRelatedEvent;
import com.github.eiffelcommunity.eiffeljiraplugin.model.jira.JiraIssueType;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JiraEiffelMappingServiceImplTest {

    private final static String jiraIssueCreatedEventString = SharedTestConstants.jiraIssueCreatedEventString;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private JiraEiffelMappingService jiraEiffelMappingService;

    @After
    public void tearDown() {
    }

    @Test
    public void toEiffelIssueDefinedEventWithGoodInput() throws Exception {
        ImmutableEiffelIssueDefinedEvent expected = ImmutableEiffelIssueDefinedEvent.builder()
                .meta(ImmutableEiffelIssueDefinedEventMeta.builder()
                        .time(1517840805048L)
                        .build())
                .data(ImmutableEiffelIssueDefinedEventData.builder()
                        .tracker("JIRA")
                        .type(EiffelIssueType.OTHER)
                        .uri(URI.create("https://eiffelplugin.atlassian.net/rest/api/2/issue/10032"))
                        .id("10032")
                        .title("Epic summary")
                        .build())
                .links(new ArrayList<>())
                .build();
        ImmutableJiraIssueRelatedEvent jiraEvent = mapper.readValue(jiraIssueCreatedEventString, ImmutableJiraIssueRelatedEvent.class);
        ImmutableEiffelIssueDefinedEvent actual = jiraEiffelMappingService.toEiffelIssueDefinedEvent(jiraEvent);
        assertThat(actual.meta().time(), is(equalTo(expected.meta().time())));
        assertThat(actual.data(), is(equalTo(expected.data())));
    }

    @Test
    public void toEiffelIssueTypeSmokeTest() {
        EiffelIssueType expected = EiffelIssueType.WORK_ITEM;
        EiffelIssueType actual = jiraEiffelMappingService.toEiffelIssueType(JiraIssueType.TASK);
        assertThat(actual, is(equalTo(expected)));
    }
}
