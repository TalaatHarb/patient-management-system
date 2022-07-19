package net.talaatharb.patientmanagementsystem.facades.impl;

import java.util.List;

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

}
