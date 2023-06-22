package ru.rubik.lightdigital.document.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rubik.lightdigital.document.entity.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}
