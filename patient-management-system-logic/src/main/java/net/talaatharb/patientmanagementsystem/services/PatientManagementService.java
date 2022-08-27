package net.talaatharb.patientmanagementsystem.services;

import java.util.List;
import java.util.UUID;

import net.talaatharb.patientmanagementsystem.dtos.MedicalCenterDto;
import net.talaatharb.patientmanagementsystem.entities.MedicalCenter;
import net.talaatharb.patientmanagementsystem.entities.Organization;

public interface PatientManagementService {

	public Organization createOrganization(Organization organization);

	public List<Organization> fetchOrganizations();


	public Organization fetchOrganization(UUID organizationId);

	public MedicalCenter createMedicalCenter(MedicalCenter inputMedicalCenter);


	public abstract List<MedicalCenter> fetchMedicalCenters(Organization organization);
}
