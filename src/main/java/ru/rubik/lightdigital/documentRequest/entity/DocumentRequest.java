package ru.rubik.lightdigital.documentRequest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.rubik.lightdigital.organization.entity.Organization;
import ru.rubik.lightdigital.documentRequest.entity.enums.DocumentRequestStatus;
import ru.rubik.lightdigital.user.entity.User;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "document_requests")
public class DocumentRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "document_request_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private DocumentRequestStatus status;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private User customer;

    @OneToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;
}
