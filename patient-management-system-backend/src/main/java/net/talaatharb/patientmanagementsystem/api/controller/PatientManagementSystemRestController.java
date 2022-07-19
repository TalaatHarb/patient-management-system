package net.talaatharb.patientmanagementsystem.api.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import net.talaatharb.patientmanagementsystem.api.PatientManagementSystemRestAPI;
import net.talaatharb.patientmanagementsystem.dtos.MedicalCenterDto;
import net.talaatharb.patientmanagementsystem.dtos.OrganizationDto;
import net.talaatharb.patientmanagementsystem.facades.PatientManagementFacade;

@RestController
@RequiredArgsConstructor
public class PatientManagementSystemRestController implements PatientManagementSystemRestAPI {
	
	private final PatientManagementFacade patientManagementFacade;
	
	@Override
	public OrganizationDto createOrganization(OrganizationDto organizationDto) {
		return patientManagementFacade.createOrganization(organizationDto);
	}
	
	@Override
	public MedicalCenterDto createMedicalCenter(MedicalCenterDto medicalCenterDto, String organizationId) {
//		medicalCenterDto.setId(UUID.randomUUID());
		return medicalCenterDto;
	}

	@Override
	public List<OrganizationDto> fetchOrganization() {
		return patientManagementFacade.fetchOrganizations();
	}
}
