package net.talaatharb.patientmanagementsystem.mappers;

import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import net.talaatharb.patientmanagementsystem.dtos.MedicalCenterDto;
import net.talaatharb.patientmanagementsystem.entities.MedicalCenter;
import net.talaatharb.patientmanagementsystem.entities.Organization;

@Mapper(componentModel = "spring")
public interface MedicalCenterMapper extends DefaultMapper<MedicalCenter, MedicalCenterDto> {

	@Mapping(source = "organizationId", target = "organization", qualifiedByName = "setOrganization")
	public abstract MedicalCenter fromDTOToEntity(MedicalCenterDto dto);

	@Mapping(source = "organization", target = "organizationId", qualifiedByName = "setOrganizationId")
	public abstract MedicalCenterDto fromEntityToDTO(MedicalCenter entity);

	@Named("setOrganization")
	default Organization setOrganization(UUID organizationId) {
		Organization organization = new Organization();
		organization.setId(organizationId);
		return organization;
	}

	@Named("setOrganizationId")
	default UUID setOrganizationId(Organization organization) {
		return organization.getId();
	}
}
