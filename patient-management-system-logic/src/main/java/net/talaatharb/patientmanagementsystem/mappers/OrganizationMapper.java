package net.talaatharb.patientmanagementsystem.mappers;

import org.mapstruct.Mapper;

import net.talaatharb.patientmanagementsystem.dtos.OrganizationDto;
import net.talaatharb.patientmanagementsystem.entities.OrganizationEntity;

@Mapper
public interface OrganizationMapper extends DefaultMapper<OrganizationEntity, OrganizationDto> {

}
