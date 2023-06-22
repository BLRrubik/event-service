package ru.rubik.lightdigital.document.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.rubik.lightdigital.document.entity.enums.DocumentStatus;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DocumentDto {
    private UUID number;
    private DocumentStatus status;
}
