package ru.rubik.lightdigital.eventRequest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rubik.lightdigital.event.repository.EventRepository;
import ru.rubik.lightdigital.eventRequest.entity.EventRequest;
import ru.rubik.lightdigital.eventRequest.entity.enums.EventRequestStatus;
import ru.rubik.lightdigital.eventRequest.repository.EventRequestRepository;
import ru.rubik.lightdigital.eventRequest.request.EventJoinRequest;
import ru.rubik.lightdigital.eventRequest.request.EventRequestReply;
import ru.rubik.lightdigital.exception.ConflictException;
import ru.rubik.lightdigital.exception.NotFoundException;
import ru.rubik.lightdigital.user.repository.UserRepository;

import java.security.Principal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventRequestServiceImpl implements EventRequestService{
    private final EventRequestRepository eventRequestRepository;
    private final UserRepository userRepository;
    private final EventRepository eventRepository;

    public EventRequest createRequest(EventJoinRequest joinRequest, Principal principal) {
        var user = userRepository.findByUsername(principal.getName())
                .orElseThrow(() -> new NotFoundException(
                        "User with username " + principal.getName() + " is not found")
                );

        var event = eventRepository.findById(joinRequest.getEventId())
                .orElseThrow(() -> new NotFoundException(
                        "Event with id " + joinRequest.getEventId() + " is not found")
                );

        if (event.getAuthor().getId().equals(user.getId())) {
            throw new ConflictException("Cannot send request to your own event");
        }

        EventRequest eventRequest = new EventRequest();

        eventRequest.setEvent(event);
        eventRequest.setPcr(joinRequest.getPcr());
        eventRequest.setAuthor(user);
        eventRequest.setAge(joinRequest.getAge());
        eventRequest.setFullname(joinRequest.getFullname());
        eventRequest.setStatus(EventRequestStatus.PENDING);

        return eventRequestRepository.save(eventRequest);
    }

    public EventRequest replyOnRequest(Long eventId, Long requestId, EventRequestReply reply, Principal principal) {
        var user = userRepository.findByUsername(principal.getName())
                .orElseThrow(() -> new NotFoundException(
                        "User with username " + principal.getName() + " is not found")
                );

        var event = eventRepository.findById(eventId)
                .orElseThrow(() -> new NotFoundException(
                        "Event with id " + eventId + " is not found")
                );

        var request = eventRequestRepository.findById(requestId)
                .orElseThrow(() -> new NotFoundException(
                        "Request with id " + requestId + " is not found")
                );

        if (!request.getEvent().getId().equals(event.getId())) {
            throw new ConflictException("This request not for that event");
        }

        if (!event.getAuthor().getId().equals(user.getId())) {
            throw new ConflictException("You not owner of this event");
        }

        request.setStatus(reply.getStatus());

        return eventRequestRepository.save(request);
    }

    public List<EventRequest> getRequestsByEvent(Long eventId, Principal principal) {
        var user = userRepository.findByUsername(principal.getName())
                .orElseThrow(() -> new NotFoundException(
                        "User with username " + principal.getName() + " is not found")
                );

        var event = eventRepository.findById(eventId)
                .orElseThrow(() -> new NotFoundException(
                        "Event with id " + eventId + " is not found")
                );

        if (!event.getAuthor().getId().equals(user.getId())) {
            throw new ConflictException("You not owner of this event");
        }

        return eventRequestRepository.findAllByEvent(event);
    }
}
