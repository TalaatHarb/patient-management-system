package net.talaatharb.patientmanagementsystem.facades.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.talaatharb.patientmanagementsystem.dtos.MedicalCenterDto;
import net.talaatharb.patientmanagementsystem.dtos.OrganizationDto;
import net.talaatharb.patientmanagementsystem.entities.MedicalCenter;
import net.talaatharb.patientmanagementsystem.entities.Organization;
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
		
		final Organization inputOrganization = organizationMapper.fromDTOToEntity(organizationDto);
		final Organization outputOrganization = patientManagementService.createOrganization(inputOrganization);
		
		return organizationMapper.fromEntityToDTO(outputOrganization);
	}

	@Override
	public List<OrganizationDto> fetchOrganizations() {
		return organizationMapper.fromEntityToDTO(patientManagementService.fetchOrganizations());
	}

	@Override
	public MedicalCenterDto createMedicalCenter(MedicalCenterDto medicalCenterDto) {
		final MedicalCenter inputMedicalCenter = medicalCenterMapper.fromDTOToEntity(medicalCenterDto);
		final MedicalCenter outputMedicalCenter = patientManagementService.createMedicalCenter(inputMedicalCenter);
		return medicalCenterMapper.fromEntityToDTO(outputMedicalCenter);
	}

	@Override
	public List<MedicalCenterDto> fetchMedicalCenters(UUID organizationId) {
		final Organization organization = patientManagementService.fetchOrganization(organizationId);
		if(organization == null) {
			return null;
		}

		final List<MedicalCenter> medicalCenters = patientManagementService.fetchMedicalCenters(organization);
		// TODO: learn how mappers work and make a function that maps a list of entities to DTOs.
		List <MedicalCenterDto> result = new ArrayList<>();
		for(MedicalCenter medicalCenter : medicalCenters) {
			result.add(medicalCenterMapper.fromEntityToDTO(medicalCenter));
		}
		return result;
	}
}
