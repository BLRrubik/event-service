package ru.rubik.lightdigital.organization.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rubik.lightdigital.document.entity.Document;
import ru.rubik.lightdigital.document.entity.enums.DocumentStatus;
import ru.rubik.lightdigital.document.repository.DocumentRepository;
import ru.rubik.lightdigital.exception.ConflictException;
import ru.rubik.lightdigital.exception.NotFoundException;
import ru.rubik.lightdigital.organization.repository.OrganizationRepository;
import ru.rubik.lightdigital.organization.request.DocumentSignRequest;
import ru.rubik.lightdigital.documentRequest.repository.DocumentRequestRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements  OrganizationService{
    private final OrganizationRepository organizationRepository;
    private final DocumentRepository documentRepository;
    private final DocumentRequestRepository documentRequestRepository;

    @Transactional
    public Document signDocument(Long organizationId, Long requestId, DocumentSignRequest signRequest) {
        var request = documentRequestRepository.findById(requestId)
                .orElseThrow(() -> new NotFoundException(
                        "Request with id " + requestId + " is not found")
                );

        var organization = organizationRepository.findById(organizationId)
                .orElseThrow(() -> new NotFoundException(
                        "Organization with id " + organizationId + " is not found")
                );

        if (!organization.getId().equals(request.getId())) {
            throw new ConflictException(
                    "Request with id " + request.getId() + " not for organization with id " + organization.getId()
            );
        }

        Document document = new Document();

        document.setOrganization(organization);
        document.setCustomer(request.getCustomer());
        document.setNumber(UUID.randomUUID());
        document.setStatus(signRequest.getStatus());

        if (document.getStatus() == DocumentStatus.APPROVED) {
            organization.getEventAdmins().add(request.getCustomer());
        }

        return documentRepository.save(document);
    }
}
