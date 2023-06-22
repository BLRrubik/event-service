package ru.rubik.lightdigital.event.service;

import ru.rubik.lightdigital.event.entity.Event;
import ru.rubik.lightdigital.event.request.EventCreateRequest;

import java.security.Principal;

public interface EventService {
    Event createEvent(EventCreateRequest request, Principal principal);
}
