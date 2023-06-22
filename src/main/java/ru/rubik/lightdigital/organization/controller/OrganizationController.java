package ru.rubik.lightdigital.organization.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.rubik.lightdigital.document.dto.DocumentDto;
import ru.rubik.lightdigital.document.dto.mapper.DocumentMapper;
import ru.rubik.lightdigital.organization.request.DocumentSignRequest;
import ru.rubik.lightdigital.organization.service.OrganizationServiceImpl;
import ru.rubik.lightdigital.documentRequest.dto.DocumentRequestDto;
import ru.rubik.lightdigital.documentRequest.dto.mapper.DocumentRequestMapper;
import ru.rubik.lightdigital.documentRequest.service.DocumentRequestServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/v1/organizations/{organizationId}")
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ORGANIZATION_ADMIN')")
public class OrganizationController {
    private final OrganizationServiceImpl organizationServiceImpl;
    private final DocumentRequestServiceImpl documentRequestServiceImpl;

    @PostMapping("/sign/{requestId}")
    public ResponseEntity<DocumentDto> signDocument(
            @PathVariable("organizationId") Long organizationId,
            @PathVariable("requestId") Long requestId,
            @RequestBody DocumentSignRequest request
    ) {
        return ResponseEntity.ok(
                DocumentMapper.toDto(organizationServiceImpl.signDocument(organizationId, requestId, request))
        );
    }

    @GetMapping
    public ResponseEntity<List<DocumentRequestDto>> getPendingRequests(
            @PathVariable("organizationId") Long organizationId
    ) {
        return ResponseEntity.ok(
                documentRequestServiceImpl.getPendingRequestsByOrganization(organizationId)
                        .stream()
                        .map(DocumentRequestMapper::toDto)
                        .toList()
        );
    }
}
