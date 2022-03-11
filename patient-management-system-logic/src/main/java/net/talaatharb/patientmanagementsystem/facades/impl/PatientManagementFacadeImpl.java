package net.talaatharb.patientmanagementsystem.facades.impl;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.talaatharb.patientmanagementsystem.dtos.OrganizationDto;
import net.talaatharb.patientmanagementsystem.entities.Organization;
import net.talaatharb.patientmanagementsystem.facades.PatientManagementFacade;
import net.talaatharb.patientmanagementsystem.mappers.OrganizationMapper;
import net.talaatharb.patientmanagementsystem.services.PatientManagementService;

@Service
@RequiredArgsConstructor
public class PatientManagementFacadeImpl implements PatientManagementFacade {
	
	private final OrganizationMapper organizationMapper;
	
	private final PatientManagementService patientManagementService;

	@Override
	public OrganizationDto createOrganization(OrganizationDto organizationDto) {
		
		final Organization inputOrganization = organizationMapper.fromDTOToEntity(organizationDto);
		final Organization outputOrganization = patientManagementService.createOrganization(inputOrganization);
		
		return organizationMapper.fromEntityToDTO(outputOrganization);
	}

}
