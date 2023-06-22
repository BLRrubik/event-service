package ru.rubik.lightdigital.organization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rubik.lightdigital.organization.entity.Organization;

import java.util.Optional;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    Optional<Organization> findByInn(String inn);
}
