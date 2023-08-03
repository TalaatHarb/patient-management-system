package net.talaatharb.patientmanagementsystem.mappers;

import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import net.talaatharb.patientmanagementsystem.dtos.MedicalCenterDto;
import net.talaatharb.patientmanagementsystem.entities.MedicalCenterEntity;
import net.talaatharb.patientmanagementsystem.entities.OrganizationEntity;

@Mapper
public interface MedicalCenterMapper extends DefaultMapper<MedicalCenterEntity, MedicalCenterDto> {

	@Mapping(source = "organizationId", target = "organization", qualifiedByName = "setOrganization")
	public abstract MedicalCenterEntity fromDtoToEntity(MedicalCenterDto dto);

	@Mapping(source = "organization", target = "organizationId", qualifiedByName = "setOrganizationId")
	public abstract MedicalCenterDto fromEntityToDto(MedicalCenterEntity entity);

	@Named("setOrganization")
	default OrganizationEntity setOrganization(UUID organizationId) {
		OrganizationEntity organization = new OrganizationEntity();
		organization.setId(organizationId);
		return organization;
	}

	@Named("setOrganizationId")
	default UUID setOrganizationId(OrganizationEntity organization) {
		return organization.getId();
	}
}
