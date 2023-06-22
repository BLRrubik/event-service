package ru.rubik.lightdigital.event.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rubik.lightdigital.event.dto.EventDto;
import ru.rubik.lightdigital.event.dto.mapper.EventMapper;
import ru.rubik.lightdigital.event.request.EventCreateRequest;
import ru.rubik.lightdigital.event.service.EventServiceImpl;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/events")
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('EVENT_ADMIN')")
public class EventController {
    private final EventServiceImpl eventServiceImpl;

    @PostMapping
    public ResponseEntity<EventDto> createEvent(EventCreateRequest request, Principal principal) {
        return ResponseEntity.ok(EventMapper.toDto(eventServiceImpl.createEvent(request, principal)));
    }
}
