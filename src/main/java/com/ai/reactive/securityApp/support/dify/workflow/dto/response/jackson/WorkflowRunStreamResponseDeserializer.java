/*
 * Copyright (c) 2025-2025, fubluesky (fubluesky@foxmail.com)
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
package com.ai.reactive.securityApp.support.dify.workflow.dto.response.jackson;

import com.ai.reactive.securityApp.support.dify.workflow.dto.response.WorkflowRunStreamResponse;
import com.ai.reactive.securityApp.support.dify.workflow.enums.StreamEventEnum;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

/**
 * @author j
 * @version 1.0
 * @since 2025/3/13 11:01
 */
public class WorkflowRunStreamResponseDeserializer
        extends JsonDeserializer<WorkflowRunStreamResponse> {

    @Override
    public WorkflowRunStreamResponse deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException {

        ObjectMapper mapper = (ObjectMapper) p.getCodec();
        JsonNode root = mapper.readTree(p);

        // 解析 event 字段
        JsonNode eventNode = root.get("event");
        if (eventNode == null || !eventNode.isTextual()) {
            return null;
        }
        StreamEventEnum event = StreamEventEnum.valueOf(eventNode.asText());

        // 解析 data 字段
        JsonNode dataNode = root.get("data");
        Object data = null;
        if (dataNode != null && !dataNode.isNull()) {
            Class<?> dataClass = event.getClazz();
            if (dataClass == Map.class) {
                // 处理 Map 类型
                data = mapper.convertValue(dataNode, new TypeReference<Map<String, Object>>() {
                });
            } else {
                // 处理其他类型（BaseWorkflowRunData 子类）
                data = mapper.treeToValue(dataNode, dataClass);
            }
        }

        // 构建响应对象
        WorkflowRunStreamResponse response = new WorkflowRunStreamResponse();
        response.setEvent(event);
        response.setData(data);
        response.setWorkflowRunId(root.get("workflow_run_id").asText());
        response.setTaskId(root.get("task_id").asText());

        return response;
    }
}
