package ru.rubik.lightdigital.document.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.rubik.lightdigital.document.entity.enums.DocumentStatus;
import ru.rubik.lightdigital.organization.entity.Organization;
import ru.rubik.lightdigital.user.entity.User;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "documents")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "document_id")
    private Long id;

    @Column(name = "number")
    private UUID number;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private DocumentStatus status;

    @OneToOne
    private Organization organization;

    @OneToOne
    private User customer;
}
