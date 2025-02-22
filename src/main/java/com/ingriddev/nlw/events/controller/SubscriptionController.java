package com.ingriddev.nlw.events.controller;

import com.ingriddev.nlw.events.model.Subscription;
import com.ingriddev.nlw.events.model.User;
import com.ingriddev.nlw.events.service.SubscriptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @PostMapping("/subscription/{prettyName}")
    public ResponseEntity<Subscription> createSubscription(@PathVariable String prettyName, @RequestBody User subscriber){
            Subscription res = subscriptionService.createNewSubscription(prettyName, subscriber);
            if(res != null) { // resultado diferente de null, inscrição correta
                return ResponseEntity.ok(res); // resultado como corpo da resposta
            }
            return ResponseEntity.badRequest().build(); // não conseguiu incluir
    }

}
