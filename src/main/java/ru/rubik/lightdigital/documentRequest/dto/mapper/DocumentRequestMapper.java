package ru.rubik.lightdigital.documentRequest.dto.mapper;


import ru.rubik.lightdigital.documentRequest.dto.DocumentRequestDto;
import ru.rubik.lightdigital.documentRequest.entity.DocumentRequest;

public class DocumentRequestMapper {
    public static DocumentRequestDto toDto(DocumentRequest request) {
        return new DocumentRequestDto(
                request.getId(),
                request.getStatus(),
                request.getOrganization().getInn(),
                request.getCustomer().getUsername()
        );
    }
}
