package ru.rubik.lightdigital.documentRequest.service;

import ru.rubik.lightdigital.documentRequest.entity.DocumentRequest;
import ru.rubik.lightdigital.documentRequest.requests.DocumentRequestCreate;

import java.security.Principal;
import java.util.List;

public interface DocumentRequestService {
    DocumentRequest createRequest(DocumentRequestCreate createRequest, Principal principal);
    List<DocumentRequest> getPendingRequestsByOrganization(Long organizationId);
}
