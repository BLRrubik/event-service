package ru.rubik.lightdigital.organization.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.rubik.lightdigital.document.entity.enums.DocumentStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DocumentSignRequest {
    private DocumentStatus status;
}
