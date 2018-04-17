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

import com.github.eiffelcommunity.eiffeljiraplugin.model.eiffel.*;
import com.github.eiffelcommunity.eiffeljiraplugin.model.jira.ImmutableJiraIssue;
import com.github.eiffelcommunity.eiffeljiraplugin.model.jira.ImmutableJiraIssueRelatedEvent;
import com.github.eiffelcommunity.eiffeljiraplugin.model.jira.JiraIssueType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JiraEiffelMappingServiceImpl implements JiraEiffelMappingService {
    private static final String JIRA_TRACKER = "JIRA";
    // TODO: Consider ways to support versioning of the event.

    @Override
    public ImmutableEiffelIssueDefinedEvent toEiffelIssueDefinedEvent(ImmutableJiraIssueRelatedEvent jiraEvent) {
        ImmutableJiraIssue jiraIssue = jiraEvent.issue();

        ImmutableEiffelIssueDefinedEventMeta meta = ImmutableEiffelIssueDefinedEventMeta.builder()
                .time(jiraEvent.timestamp()).build();

        ImmutableEiffelIssueDefinedEventData data = ImmutableEiffelIssueDefinedEventData.builder()
                .id(jiraIssue.id())
                .uri(jiraIssue.self())
                .tracker(JIRA_TRACKER)
                .type(toEiffelIssueType(jiraIssue.fields().issueType().issueType()))
                .build();

        List<ImmutableLink> links = new ArrayList<>();

        return ImmutableEiffelIssueDefinedEvent.builder()
                .meta(meta)
                .data(data)
                .links(links)
                .build();
    }

    @Override
    public EiffelIssueType toEiffelIssueType(JiraIssueType jiraType) {
        switch (jiraType) {
            case TASK:
            case SUB_TASK: // fall through
                return EiffelIssueType.WORK_ITEM;
            case STORY:
                return EiffelIssueType.REQUIREMENT;
            case BUG:
                return EiffelIssueType.BUG;
            case FEATURE:
                return EiffelIssueType.FEATURE;
            case IMPROVEMENT:
                return EiffelIssueType.IMPROVEMENT;
            case EPIC:
                return EiffelIssueType.OTHER;
            default:
                return EiffelIssueType.OTHER;
        }
    }
}

