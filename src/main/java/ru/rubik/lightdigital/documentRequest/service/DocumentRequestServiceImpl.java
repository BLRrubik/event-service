package ru.rubik.lightdigital.documentRequest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rubik.lightdigital.exception.NotFoundException;
import ru.rubik.lightdigital.organization.repository.OrganizationRepository;
import ru.rubik.lightdigital.documentRequest.entity.DocumentRequest;
import ru.rubik.lightdigital.documentRequest.entity.enums.DocumentRequestStatus;
import ru.rubik.lightdigital.documentRequest.repository.DocumentRequestRepository;
import ru.rubik.lightdigital.documentRequest.requests.DocumentRequestCreate;
import ru.rubik.lightdigital.user.repository.UserRepository;

import java.security.Principal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentRequestServiceImpl implements DocumentRequestService {
    private final DocumentRequestRepository requestRepository;
    private final OrganizationRepository organizationRepository;
    private final UserRepository userRepository;

    public DocumentRequest createRequest(DocumentRequestCreate createRequest, Principal principal) {
        var organization = organizationRepository.findByInn(createRequest.getInn())
                .orElseThrow(() -> new NotFoundException(
                        "Organization with inn " + createRequest.getInn() + " is not found")
                );

        var user = userRepository.findByUsername(principal.getName())
                .orElseThrow(() -> new NotFoundException(
                        "User with username " + principal.getName() + " is not found")
                );

        var documentRequest = new DocumentRequest();

        documentRequest.setOrganization(organization);
        documentRequest.setCustomer(user);
        documentRequest.setStatus(DocumentRequestStatus.PENDING);

        return requestRepository.save(documentRequest);
    }

    public List<DocumentRequest> getPendingRequestsByOrganization(Long organizationId) {
        var organization = organizationRepository.findById(organizationId)
                .orElseThrow(() -> new NotFoundException(
                        "Organization with id " + organizationId + " is not found")
                );

        return requestRepository.findAllByOrganizationAndStatus(organization, DocumentRequestStatus.PENDING);
    }
}
