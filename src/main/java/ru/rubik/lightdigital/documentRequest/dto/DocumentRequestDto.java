package ru.rubik.lightdigital.documentRequest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.rubik.lightdigital.documentRequest.entity.enums.DocumentRequestStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DocumentRequestDto {
    private Long id;
    private DocumentRequestStatus status;
    private String inn;
    private String username;
}
