package net.talaatharb.patientmanagementsystem.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import net.talaatharb.patientmanagementsystem.dtos.MedicalCenterDto;
import net.talaatharb.patientmanagementsystem.dtos.OrganizationDto;

@CrossOrigin
@RequestMapping(path = "/api/v1")
public interface PatientManagementSystemRestAPI {
	
	@PostMapping(path = "/organizations", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public OrganizationDto createOrganization(@RequestBody OrganizationDto organizationDto);
	
	@GetMapping(path = "/organizations", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public List<OrganizationDto> fetchOrganization();
	
	@PostMapping(path = "/organizations/{organizationId}/medical-centers", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public MedicalCenterDto createMedicalCenter(@RequestBody MedicalCenterDto medicalCenterDto, @PathVariable String organizationId);


	@GetMapping(path = "/organizations/{organizationId}/medical-centers", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public List<MedicalCenterDto> fetchMedicalCenters(@PathVariable UUID organizationId);
}
