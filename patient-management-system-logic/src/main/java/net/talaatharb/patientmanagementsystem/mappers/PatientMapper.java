package net.talaatharb.patientmanagementsystem.mappers;

import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import net.talaatharb.patientmanagementsystem.dtos.PatientDto;
import net.talaatharb.patientmanagementsystem.entities.MedicalCenterEntity;
import net.talaatharb.patientmanagementsystem.entities.OrganizationEntity;
import net.talaatharb.patientmanagementsystem.entities.PatientEntity;

@Mapper
public interface PatientMapper extends DefaultMapper<PatientEntity, PatientDto> {

	@Mapping(source = "organizationId", target = "organization", qualifiedByName = "setOrganization")
	@Mapping(source = "medicalCenterId", target = "medicalCenter", qualifiedByName = "setMedicalCenter")
	PatientEntity fromDtoToEntity(PatientDto dto);

	@Mapping(source = "organization", target = "organizationId", qualifiedByName = "setOrganizationId")
	@Mapping(source = "medicalCenter", target = "medicalCenterId", qualifiedByName = "setMedicalCenterId")
	PatientDto fromEntityToDto(PatientEntity entity);

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

	@Named("setMedicalCenter")
	default MedicalCenterEntity setMedicalCenter(UUID medicalCenterId) {
		MedicalCenterEntity medicalCenter = new MedicalCenterEntity();
		medicalCenter.setId(medicalCenterId);
		return medicalCenter;
	}

	@Named("setMedicalCenterId")
	default UUID setOrganizationId(MedicalCenterEntity medicalCenter) {
		return medicalCenter.getId();
	}
}
