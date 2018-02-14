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

package io.github.eiffelcommunity.eiffeljiraplugin.controller;

import io.github.eiffelcommunity.eiffeljiraplugin.service.JiraEiffelMappingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(JiraWebhookController.class)
public class JiraWebhookControllerTest {

    @MockBean
    JiraEiffelMappingService mappingService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getRequestIsNotAllowed() throws Exception {
        mockMvc
                .perform(
                        get("/webhooks/jira"))
                .andExpect(status().isMethodNotAllowed());
    }

    @Test
    public void malformedJsonIsBadRequest() throws Exception {
        mockMvc
                .perform(
                        post("/webhooks/jira")
                                .contentType("application/json")
                                .content("{\"shouldBe\": \"rejected\"}"))
                .andExpect(status().isBadRequest());
    }
}
