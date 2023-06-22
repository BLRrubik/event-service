package ru.rubik.lightdigital.documentRequest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rubik.lightdigital.documentRequest.dto.DocumentRequestDto;
import ru.rubik.lightdigital.documentRequest.dto.mapper.DocumentRequestMapper;
import ru.rubik.lightdigital.documentRequest.requests.DocumentRequestCreate;
import ru.rubik.lightdigital.documentRequest.service.DocumentRequestServiceImpl;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/document-requests")
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('EVENT_ADMIN')")
public class DocumentRequestController {
    private final DocumentRequestServiceImpl service;

    @PostMapping
    public ResponseEntity<DocumentRequestDto> createRequest (
            @RequestBody DocumentRequestCreate requestCreate,
            Principal principal
    ) {
        return ResponseEntity.ok(DocumentRequestMapper.toDto(service.createRequest(requestCreate, principal)));
    }
}
