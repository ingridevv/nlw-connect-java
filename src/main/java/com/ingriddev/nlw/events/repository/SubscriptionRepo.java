package com.ingriddev.nlw.events.repository;

import com.ingriddev.nlw.events.model.Subscription;
import org.springframework.data.repository.CrudRepository;

public interface SubscriptionRepo extends CrudRepository<Subscription, Integer> {
}
