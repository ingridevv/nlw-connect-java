package com.ingriddev.nlw.events.service;

import com.ingriddev.nlw.events.model.Event;
import com.ingriddev.nlw.events.repository.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepo eventrepo;

    public Event addNewEvent(Event event){
        // Pretty name gerar
        event.setPrettyName(event.getTitle().toLowerCase().replaceAll(" ", "-"));
        // Cadastrar novo evento
        return eventrepo.save(event);

    }

    public List<Event> getAllEvents(){
        return (List<Event>) eventrepo.findAll();
    }

    public Event getByPrettyName(String prettyName){
        return eventrepo.findByPrettyName(prettyName);
    }

}
