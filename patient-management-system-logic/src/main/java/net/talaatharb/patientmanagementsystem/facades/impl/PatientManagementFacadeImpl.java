package net.talaatharb.patientmanagementsystem.facades.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.talaatharb.patientmanagementsystem.dtos.MedicalCenterDto;
import net.talaatharb.patientmanagementsystem.dtos.OrganizationDto;
import net.talaatharb.patientmanagementsystem.entities.MedicalCenterEntity;
import net.talaatharb.patientmanagementsystem.entities.OrganizationEntity;
import net.talaatharb.patientmanagementsystem.facades.PatientManagementFacade;
import net.talaatharb.patientmanagementsystem.mappers.MedicalCenterMapper;
import net.talaatharb.patientmanagementsystem.mappers.OrganizationMapper;
import net.talaatharb.patientmanagementsystem.services.PatientManagementService;

@Service
@RequiredArgsConstructor
public class PatientManagementFacadeImpl implements PatientManagementFacade {

	private final OrganizationMapper organizationMapper;

	private final MedicalCenterMapper medicalCenterMapper;

	private final PatientManagementService patientManagementService;

	@Override
	public OrganizationDto createOrganization(OrganizationDto organizationDto) {

		final OrganizationEntity inputOrganization = organizationMapper.fromDtoToEntity(organizationDto);
		final OrganizationEntity outputOrganization = patientManagementService.createOrganization(inputOrganization);

		return organizationMapper.fromEntityToDto(outputOrganization);
	}

	@Override
	public List<OrganizationDto> fetchOrganizations() {
		return organizationMapper.fromEntityToDto(patientManagementService.fetchOrganizations());
	}

	@Override
	public MedicalCenterDto createMedicalCenter(MedicalCenterDto medicalCenterDto) {
		final MedicalCenterEntity inputMedicalCenter = medicalCenterMapper.fromDtoToEntity(medicalCenterDto);
		final MedicalCenterEntity outputMedicalCenter = patientManagementService
				.createMedicalCenter(inputMedicalCenter);
		return medicalCenterMapper.fromEntityToDto(outputMedicalCenter);
	}

	@Override
	public List<MedicalCenterDto> fetchMedicalCenters(UUID organizationId) {
		final OrganizationEntity organization = patientManagementService.fetchOrganization(organizationId);
		if (organization == null) {
			return new ArrayList<>();
		}

		final List<MedicalCenterEntity> medicalCenters = patientManagementService.fetchMedicalCenters(organization);

		return medicalCenterMapper.fromEntityToDto(medicalCenters);
	}
}
