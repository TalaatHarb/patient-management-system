package net.talaatharb.patientmanagementsystem.mappers;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import net.talaatharb.patientmanagementsystem.dtos.OrganizationDto;
import net.talaatharb.patientmanagementsystem.entities.Organization;

@Mapper(componentModel = "spring")
@Component
public interface OrganizationMapper extends DefaultMapper<Organization, OrganizationDto> {

}
