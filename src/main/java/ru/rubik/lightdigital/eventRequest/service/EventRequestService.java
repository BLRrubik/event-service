package ru.rubik.lightdigital.eventRequest.service;

import ru.rubik.lightdigital.eventRequest.entity.EventRequest;
import ru.rubik.lightdigital.eventRequest.request.EventJoinRequest;
import ru.rubik.lightdigital.eventRequest.request.EventRequestReply;

import java.security.Principal;
import java.util.List;

public interface EventRequestService {
    EventRequest createRequest(EventJoinRequest joinRequest, Principal principal);
    EventRequest replyOnRequest(Long eventId, Long requestId, EventRequestReply reply, Principal principal);
    List<EventRequest> getRequestsByEvent(Long eventId, Principal principal);
}
