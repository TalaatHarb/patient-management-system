package net.talaatharb.patientmanagementsystem.services;

import java.util.List;

import net.talaatharb.patientmanagementsystem.entities.MedicalCenter;
import net.talaatharb.patientmanagementsystem.entities.Organization;

public interface PatientManagementService {

	public Organization createOrganization(Organization organization);

	public List<Organization> fetchOrganizations();

	public MedicalCenter createMedicalCenter(MedicalCenter inputMedicalCenter);
}
