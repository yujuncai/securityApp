package com.ai.reactive.securityApp.api;

import com.ai.reactive.securityApp.service.WebFluxDifyService;
import com.ai.reactive.securityApp.support.dify.chat.dto.response.ChatMessageSendCompletionResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@RestController
@RequestMapping(path = "/dify/test", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@RequiredArgsConstructor
public class DifyController {




    private final WebFluxDifyService  webFluxdifyService;


    @GetMapping(value = "/chat", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public  Flux<ChatMessageSendCompletionResponse> chatMessage(@RequestParam (value = "m",required = true) String m, @RequestParam (value = "cid",required = false) String cid)  {

        return  Flux.defer(() -> webFluxdifyService.chatMessage(m,cid)) .subscribeOn(Schedulers.boundedElastic());

    }



}
