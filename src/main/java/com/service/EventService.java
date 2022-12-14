package com.service;

import com.model.Event;
import com.repository.EventRepo;
import com.repository.hibernate.HibernateEventRepoImpl;

import java.util.List;

public class EventService {

    private final EventRepo eventRepo = new HibernateEventRepoImpl();

    public Event getById(Long id) {
        return eventRepo.getById(id);
    }

    public List<Event> getAllEvents() {return eventRepo.getAll();}

    public Event updateEvent(Event event) {return eventRepo.update(event);}

    public Event createEvent(Event event) {return eventRepo.insert(event);}

    public void deleteById(Long id) {eventRepo.deleteById(id);}

}
