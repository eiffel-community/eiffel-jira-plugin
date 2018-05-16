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
import com.github.eiffelcommunity.eiffeljiraplugin.model.jira.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class JiraEiffelMappingServiceImpl implements JiraEiffelMappingService {
    private static final String JIRA_TRACKER = "JIRA";
    private final EiffelEventRepository eventRepository;

    @Autowired
    public JiraEiffelMappingServiceImpl(EiffelEventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

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
                .title(jiraIssue.fields().title())
                .build();

        List<ImmutableLink> links = new ArrayList<>();

        ImmutableEiffelIssueDefinedEvent event = ImmutableEiffelIssueDefinedEvent.builder()
                .meta(meta)
                .data(data)
                .links(links)
                .build();
        eventRepository.saveIssueDefinedEvent(event);
        return event;
    }

    @Override
    public ImmutableEiffelIssueAssignedEvent toEiffelIssueAssignedEvent(ImmutableJiraIssueRelatedEvent jiraEvent) {
        ImmutableJiraIssue jiraIssue = jiraEvent.issue();

        ImmutableEiffelIssueAssignedEventMeta meta = ImmutableEiffelIssueAssignedEventMeta.builder()
                .time(jiraEvent.timestamp()).build();


        ImmutableEiffelIssueAssignedEventData data = ImmutableEiffelIssueAssignedEventData.builder()
                .addAssignees(toEiffelAssignee(jiraIssue.fields().assignee().orElseThrow(IllegalStateException::new)))
                .build();

        UUID uuid = eventRepository.getIssueDefinedEventID(jiraIssue.self());

        return ImmutableEiffelIssueAssignedEvent.builder()
                .meta(meta)
                .data(data)
                .addLinks(ImmutableLink.builder().target(uuid).type("ISSUE").build())
                .build();
    }

    @Override
    public ImmutableEiffelIssueStatusModifiedEvent toEiffelIssueStatusModifiedEvent(ImmutableJiraIssueRelatedEvent jiraEvent) {
        ImmutableJiraIssue jiraIssue = jiraEvent.issue();

        ImmutableEiffelIssueStatusModifiedEventMeta meta = ImmutableEiffelIssueStatusModifiedEventMeta.builder()
                .time(jiraEvent.timestamp()).build();


        ImmutableEiffelIssueStatusModifiedEventData data = ImmutableEiffelIssueStatusModifiedEventData.builder()
                .category(toEiffelIssueStatusCategory(jiraIssue.fields().status().category().name()))
                .status(jiraIssue.fields().status().name())
                .build();

        UUID uuid = eventRepository.getIssueDefinedEventID(jiraIssue.self());

        return ImmutableEiffelIssueStatusModifiedEvent.builder()
                .meta(meta)
                .data(data)
                .addLinks(ImmutableLink.builder().target(uuid).type("ISSUE").build())
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

    @Override
    public ImmutableEiffelAssignee toEiffelAssignee(ImmutableJiraAssignee jiraAssignee) {
        return ImmutableEiffelAssignee.builder()
                .email(jiraAssignee.emailAddress())
                .name(jiraAssignee.displayName())
                .id(jiraAssignee.username())
                .build();
    }

    @Override
    public EiffelIssueStatusCategory toEiffelIssueStatusCategory(JiraIssueStatusCategoryName jiraCategoryName) {
        switch (jiraCategoryName) {
            case NEW:
                return EiffelIssueStatusCategory.OPEN;
            case IN_PROGRESS:
                return EiffelIssueStatusCategory.ACTIVE;
            case COMPLETE:
                return EiffelIssueStatusCategory.RESOLVED;
            default:
                return EiffelIssueStatusCategory.OPEN;
        }
    }
}

