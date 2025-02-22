package com.ingriddev.nlw.events.service;

import com.ingriddev.nlw.events.model.Event;
import com.ingriddev.nlw.events.model.Subscription;
import com.ingriddev.nlw.events.model.User;
import com.ingriddev.nlw.events.repository.EventRepo;
import com.ingriddev.nlw.events.repository.SubscriptionRepo;
import com.ingriddev.nlw.events.repository.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService {

    private final EventRepo evtRepo;

    private final UserRepo userRepo;

    private final SubscriptionRepo subRepo;

    public SubscriptionService(EventRepo evtRepo, UserRepo userRepo, SubscriptionRepo subRepo) {
        this.evtRepo = evtRepo;
        this.userRepo = userRepo;
        this.subRepo = subRepo;
    }

    // Para saber onde será destinada a inscrição, o evento precisa ser recuperado
    public Subscription createNewSubscription(String eventName, User user) {

        // recuperar evento pelo nome
        Event evt = evtRepo.findByPrettyName(eventName); // buscar o evento pelo pretty name (assumo que o evento existe)
        User userRec = userRepo.findByEmail(user.getEmail());
        if (userRec == null) {
            userRec = userRepo.save(user); // gravo usuário no DB
        }
        // Estrutura de inscrição
        Subscription subs = new Subscription();
        subs.setEvent(evt); // atribuir o evento recuperado na inscrição
        subs.setSubscriber(userRec); // atribuir usuário como subscriber
        Subscription res = subRepo.save(subs);
        return res;
    }

}
