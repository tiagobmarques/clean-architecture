package com.bmarques.cardinsurance.controller.v1.card;

import com.bmarques.cardinsurance.core.card.CardEntity;
import com.bmarques.cardinsurance.core.card.CardService;
import com.bmarques.cardinsurance.utils.PageFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/v1/card")
public class CardController {

    @Autowired
    private CardService service;

//    @Autowired
//    private CardMapper cardMapper;

    @GetMapping
    public Mono<Page<CardEntity>> getListCard(
            @Valid PageFilter pageFilter) {
        return Mono.fromCallable(() -> service.getListCard(pageFilter.toPageable()))
                .subscribeOn(Schedulers.boundedElastic());
    }
}
