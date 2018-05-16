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

import com.github.eiffelcommunity.eiffeljiraplugin.model.eiffel.EiffelIssueDefinedEvent;
import org.springframework.stereotype.Repository;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class HashMapEiffelEventRepository implements EiffelEventRepository {
    private final Map<URI, UUID> repo;

    public HashMapEiffelEventRepository() {
        this.repo = new HashMap<>();
    }

    @Override
    public void saveIssueDefinedEvent(EiffelIssueDefinedEvent event) {
        repo.put(event.data().uri(), event.meta().id());
    }

    @Override
    public UUID getIssueDefinedEventID(URI uri) {
        return repo.get(uri);
    }
}
