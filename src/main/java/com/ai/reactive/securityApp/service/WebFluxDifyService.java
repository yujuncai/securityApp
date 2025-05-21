package com.ai.reactive.securityApp.service;

import com.ai.reactive.securityApp.support.dify.chat.DifyChat;
import com.ai.reactive.securityApp.support.dify.chat.dto.request.ChatMessageSendRequest;
import com.ai.reactive.securityApp.support.dify.chat.dto.response.ChatMessageSendCompletionResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.HashMap;
import java.util.Map;


@Service
@Slf4j
@RequiredArgsConstructor
public class WebFluxDifyService {


    private final DifyChat dfyChat;



    public Flux<ChatMessageSendCompletionResponse> chatMessage(String m, String cid) {

        ChatMessageSendRequest request=new ChatMessageSendRequest();
        request.setContent(m);
        request.setApiKey("app-XaUaSEBHe67ELVnbYOaXrlXf");
        request.setConversationId(cid);
        request.setUserId("user-1");
        Map<String, Object> map = new HashMap<>();
        map.put("key","v");
        request.setInputs(map);
        return dfyChat.sendChatMessageStream(request);

    }




}
