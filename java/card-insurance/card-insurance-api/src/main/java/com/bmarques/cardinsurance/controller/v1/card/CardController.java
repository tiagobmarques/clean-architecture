package com.bmarques.cardinsurance.controller.v1.card;

import com.bmarques.cardinsurance.core.card.Card;
import com.bmarques.cardinsurance.core.card.CardService;
import com.bmarques.cardinsurance.utils.PageFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/card")
public class CardController {

    @Autowired
    private CardService service;

    @GetMapping
    public Mono<List<Card>> getListCard(
            @Valid PageFilter pageFilter) {
        return Mono.fromCallable(() -> service.getListCard(/*pageFilter.toPageable()*/))
                .subscribeOn(Schedulers.boundedElastic());
    }
}
