package ru.rubik.lightdigital.event.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rubik.lightdigital.event.entity.Event;
import ru.rubik.lightdigital.event.repository.EventRepository;
import ru.rubik.lightdigital.event.request.EventCreateRequest;
import ru.rubik.lightdigital.exception.ConflictException;
import ru.rubik.lightdigital.exception.NotFoundException;
import ru.rubik.lightdigital.organization.repository.OrganizationRepository;
import ru.rubik.lightdigital.user.repository.UserRepository;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService{
    private final EventRepository eventRepository;
    private final UserRepository userRepository;
    private final OrganizationRepository organizationRepository;

    public Event createEvent(EventCreateRequest request, Principal principal) {
        var user = userRepository.findByUsername(principal.getName())
                .orElseThrow(() -> new NotFoundException(
                        "User with username " + principal.getName() + " is not found")
                );

        var organization = organizationRepository.findByInn(request.getInn())
                .orElseThrow(() -> new NotFoundException(
                        "Organization with inn " + request.getInn() + " is not found")
                );

        if (!organization.getEventAdmins().contains(user)) {
            throw new ConflictException("No active documents with this organization");
        }

        Event event = new Event();

        event.setAuthor(user);
        event.setTitle(request.getTitle());
        event.setPrice(request.getPrice());
        event.setMinAge(request.getMinAge());

       return eventRepository.save(event);
    }
}
