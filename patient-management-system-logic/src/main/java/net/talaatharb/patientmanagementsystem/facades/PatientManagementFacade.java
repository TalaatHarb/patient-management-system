package net.talaatharb.patientmanagementsystem.facades;

import net.talaatharb.patientmanagementsystem.dtos.OrganizationDto;

public interface PatientManagementFacade {

	public abstract OrganizationDto createOrganization(OrganizationDto organizationDto);
}
