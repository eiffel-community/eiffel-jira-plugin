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
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.github.eiffelcommunity.eiffeljiraplugin.model.eiffel.EiffelIssueType;
import com.github.eiffelcommunity.eiffeljiraplugin.model.eiffel.ImmutableEiffelIssueDefinedEvent;
import com.github.eiffelcommunity.eiffeljiraplugin.model.eiffel.ImmutableEiffelIssueDefinedEventData;
import com.github.eiffelcommunity.eiffeljiraplugin.model.eiffel.ImmutableEiffelIssueDefinedEventMeta;
import com.github.eiffelcommunity.eiffeljiraplugin.model.jira.ImmutableJiraIssueRelatedEvent;
import com.github.eiffelcommunity.eiffeljiraplugin.model.jira.JiraIssueType;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class JiraEiffelMappingServiceImplTest {

    private static String jiraIssueCreatedEventString;

    private JiraEiffelMappingService jiraEiffelMappingService;
    private ObjectMapper mapper;

    /*
     read in a file under "resources" and return the whole thing as a string
     See https://stackoverflow.com/questions/309424/read-convert-an-inputstream-to-a-string
     for scanner trick. "\\A" is "beginning of input boundry," so the scanner reads
     the whole file in one go.
    */
    private static String resourceToString(String resourcePath) {
        InputStream inputStream = JiraEiffelMappingServiceImplTest.class.getClassLoader().getResourceAsStream(resourcePath);
        try (Scanner s = new Scanner(inputStream).useDelimiter("\\A")) {
            return s.hasNext() ? s.next() : "";
        }
    }

    @BeforeClass
    public static void initCache() {
        jiraIssueCreatedEventString = resourceToString("input/jira-issue-created.json");
    }

    @Before
    public void setUp() {
        jiraEiffelMappingService = new JiraEiffelMappingServiceImpl();
        mapper = new ObjectMapper();
        /*
            Spring automatically registers Jdk 8 types since jackson-datatype-jdk8 is on the class path,
            but we don't want to bring in all of spring just for these tests.
         */
        mapper.registerModule(new Jdk8Module());
    }

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
