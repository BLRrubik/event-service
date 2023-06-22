package ru.rubik.lightdigital.documentRequest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rubik.lightdigital.organization.entity.Organization;
import ru.rubik.lightdigital.documentRequest.entity.DocumentRequest;
import ru.rubik.lightdigital.documentRequest.entity.enums.DocumentRequestStatus;

import java.util.List;

public interface DocumentRequestRepository extends JpaRepository<DocumentRequest, Long> {
    List<DocumentRequest> findAllByOrganizationAndStatus(Organization organization, DocumentRequestStatus status);
}
