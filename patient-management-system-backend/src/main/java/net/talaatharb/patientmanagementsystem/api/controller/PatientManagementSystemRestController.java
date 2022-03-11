package net.talaatharb.patientmanagementsystem.api.controller;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import net.talaatharb.patientmanagementsystem.api.PatientManagementSystemRestAPI;
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
}
