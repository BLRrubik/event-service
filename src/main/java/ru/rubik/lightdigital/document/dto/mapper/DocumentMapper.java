package ru.rubik.lightdigital.document.dto.mapper;

import ru.rubik.lightdigital.document.dto.DocumentDto;
import ru.rubik.lightdigital.document.entity.Document;

public class DocumentMapper {
    public static DocumentDto toDto(Document document) {
        return new DocumentDto(
                document.getNumber(),
                document.getStatus()
        );
    }
}
