package net.talaatharb.patientmanagementsystem.facades;

import java.util.List;
import java.util.UUID;

import net.talaatharb.patientmanagementsystem.dtos.MedicalCenterDto;
import net.talaatharb.patientmanagementsystem.dtos.OrganizationDto;

public interface PatientManagementFacade {

	public abstract OrganizationDto createOrganization(OrganizationDto organizationDto);

	public abstract List<OrganizationDto> fetchOrganizations();

	public abstract MedicalCenterDto createMedicalCenter(MedicalCenterDto medicalCenterDto);

	public abstract List<MedicalCenterDto> fetchMedicalCenters(UUID organizationId);
}
