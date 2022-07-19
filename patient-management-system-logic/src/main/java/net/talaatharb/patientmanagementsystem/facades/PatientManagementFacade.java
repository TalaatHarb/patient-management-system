package net.talaatharb.patientmanagementsystem.facades;

import java.util.List;

import net.talaatharb.patientmanagementsystem.dtos.MedicalCenterDto;
import net.talaatharb.patientmanagementsystem.dtos.OrganizationDto;

public interface PatientManagementFacade {

	public abstract OrganizationDto createOrganization(OrganizationDto organizationDto);

	public abstract List<OrganizationDto> fetchOrganizations();

	public abstract MedicalCenterDto createMedicalCenter(MedicalCenterDto medicalCenterDto);
}
