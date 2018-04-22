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

package com.github.eiffelcommunity.eiffeljiraplugin;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Read known to be short input files in as strings once during initialization.
 */
public final class SharedTestConstants {

    public static String jiraIssueCreatedEventString = resourceToString("input/jira-issue-created.json");
    public static String jiraIssueAssignedEventString = resourceToString("input/jira-issue-assigned.json");
    public static String jiraIssueStatusUpdatedToInProgressEventString = resourceToString("input/jira-issue-status-updated-to-in-progress.json");
    public static String jiraIssueStatusUpdatedToCompleteEventString = resourceToString("input/jira-issue-status-updated-to-complete.json");

    private SharedTestConstants() {
    }

    /*
     read in a file under "resources" and return the whole thing as a string
     See https://stackoverflow.com/questions/309424/read-convert-an-inputstream-to-a-string
     for scanner trick. "\\A" is "beginning of input boundry," so the scanner reads
     the whole file in one go.
    */
    private static String resourceToString(String resourcePath) {
        InputStream inputStream = SharedTestConstants.class.getClassLoader().getResourceAsStream(resourcePath);
        try (Scanner s = new Scanner(inputStream).useDelimiter("\\A")) {
            return s.hasNext() ? s.next() : "";
        }
    }
}
