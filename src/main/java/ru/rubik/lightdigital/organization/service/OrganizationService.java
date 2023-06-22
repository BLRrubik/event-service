package ru.rubik.lightdigital.organization.service;

import ru.rubik.lightdigital.document.entity.Document;
import ru.rubik.lightdigital.organization.request.DocumentSignRequest;

public interface OrganizationService {
    Document signDocument(Long organizationId, Long requestId, DocumentSignRequest signRequest);
}
