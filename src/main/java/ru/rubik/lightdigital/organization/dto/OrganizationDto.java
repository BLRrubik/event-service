package ru.rubik.lightdigital.organization.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationDto {
    private Long id;
    private String title;
    private String inn;
}
