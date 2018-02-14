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

package io.github.eiffelcommunity.eiffeljiraplugin.service;

import io.github.eiffelcommunity.eiffeljiraplugin.model.eiffel.*;
import io.github.eiffelcommunity.eiffeljiraplugin.model.jira.ImmutableJiraIssue;
import io.github.eiffelcommunity.eiffeljiraplugin.model.jira.JiraIssueType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JiraEiffelMappingServiceImpl implements JiraEiffelMappingService {
    private static final String JIRA_TRACKER = "JIRA";
    // TODO: Consider ways to support versioning of the event.
    private static final String EIFFEL_ISSUE_DEFINED_EVENT_VERSION = "1.0.0";

    @Override
    public ImmutableEiffelIssueDefinedEvent toEiffelIssueDefinedEvent(ImmutableJiraIssue jiraIssue) {
        ImmutableEiffelIssueDefinedEventMeta meta = ImmutableEiffelIssueDefinedEventMeta.builder().build();

        ImmutableEiffelIssueDefinedEventData data = ImmutableEiffelIssueDefinedEventData.builder()
                .id(jiraIssue.id())
                .uri(jiraIssue.self())
                .tracker(JIRA_TRACKER)
                .type(toEiffelIssueType(jiraIssue.fields().issueType().issueType()))
                .build();

        List<Link> links = new ArrayList<>();

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
