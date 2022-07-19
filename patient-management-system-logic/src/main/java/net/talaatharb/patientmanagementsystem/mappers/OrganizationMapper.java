package net.talaatharb.patientmanagementsystem.mappers;

import org.mapstruct.Mapper;

import net.talaatharb.patientmanagementsystem.dtos.OrganizationDto;
import net.talaatharb.patientmanagementsystem.entities.Organization;

@Mapper(componentModel = "spring")
public interface OrganizationMapper extends DefaultMapper<Organization, OrganizationDto> {

}
