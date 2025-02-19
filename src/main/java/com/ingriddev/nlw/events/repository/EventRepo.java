package com.ingriddev.nlw.events.repository;

import com.ingriddev.nlw.events.model.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepo extends CrudRepository<Event, Integer> {
    public Event findByPrettyName(String prettyName);
}
