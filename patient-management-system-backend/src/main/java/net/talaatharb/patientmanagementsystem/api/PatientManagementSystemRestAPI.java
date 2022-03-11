package net.talaatharb.patientmanagementsystem.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import net.talaatharb.patientmanagementsystem.dtos.OrganizationDto;

@CrossOrigin
@RequestMapping(path = "/api/v1")
public interface PatientManagementSystemRestAPI {
	
	@PostMapping(path = "/organizations", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public OrganizationDto createOrganization(OrganizationDto organizationDto);
	
	@GetMapping(path = "/organizations", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public List<OrganizationDto> fetchOrganization();
}
