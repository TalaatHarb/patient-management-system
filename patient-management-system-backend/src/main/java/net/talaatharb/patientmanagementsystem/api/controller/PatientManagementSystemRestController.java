package net.talaatharb.patientmanagementsystem.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.micrometer.core.instrument.util.StringUtils;
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
		if(medicalCenterDto.getOrganizationId() == null || !medicalCenterDto.getOrganizationId().toString().equals(organizationId)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "organization id is invalid");
		}
		if(StringUtils.isBlank(medicalCenterDto.getName())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "name has to contain value");
		}
		return patientManagementFacade.createMedicalCenter(medicalCenterDto);
	}

	@Override
	public List<OrganizationDto> fetchOrganization() {
		return patientManagementFacade.fetchOrganizations();
	}
}
