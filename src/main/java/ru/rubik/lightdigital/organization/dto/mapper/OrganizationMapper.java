package ru.rubik.lightdigital.organization.dto.mapper;

import ru.rubik.lightdigital.organization.dto.OrganizationDto;
import ru.rubik.lightdigital.organization.entity.Organization;

public class OrganizationMapper {
    public static OrganizationDto toDto(Organization organization) {
        return new OrganizationDto(
                organization.getId(),
                organization.getTitle(),
                organization.getInn()
        );
    }
}
