package ru.rubik.lightdigital.eventRequest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.rubik.lightdigital.eventRequest.dto.EventRequestDto;
import ru.rubik.lightdigital.eventRequest.dto.mapper.EventRequestMapper;
import ru.rubik.lightdigital.eventRequest.request.EventJoinRequest;
import ru.rubik.lightdigital.eventRequest.request.EventRequestReply;
import ru.rubik.lightdigital.eventRequest.service.EventRequestServiceImpl;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/event-request")
@RequiredArgsConstructor
public class EventRequestController {
    private final EventRequestServiceImpl eventRequestServiceImpl;

    @GetMapping("/{eventId}")
    @PreAuthorize("hasAuthority('EVENT_ADMIN')")
    public ResponseEntity<List<EventRequestDto>> getRequestsByEvent (
            @PathVariable("eventId") Long eventId,
            Principal principal
    ) {
        return ResponseEntity.ok(
                eventRequestServiceImpl.getRequestsByEvent(eventId, principal).stream()
                        .map(EventRequestMapper::toDto)
                        .toList()
        );
    }

    @PostMapping
    @PreAuthorize("hasAuthority('USER') || hasAuthority('EVENT_ADMIN')")
    public ResponseEntity<EventRequestDto> createRequest (
            @RequestBody EventJoinRequest request,
            Principal principal
    ) {
       return ResponseEntity.ok(
               EventRequestMapper.toDto(eventRequestServiceImpl.createRequest(request, principal))
       );
    }

    @PatchMapping("/{eventId}/{requestId}/")
    @PreAuthorize("hasAuthority('EVENT_ADMIN')")
    public ResponseEntity<EventRequestDto> replyOnRequest (
            @PathVariable("eventId") Long eventId,
            @PathVariable("requestId") Long requestId,
            @RequestBody EventRequestReply request,
            Principal principal
    ) {
        return ResponseEntity.ok(
                EventRequestMapper.toDto(
                        eventRequestServiceImpl.replyOnRequest(
                                eventId, requestId, request, principal
                        )
                )
        );
    }
}
