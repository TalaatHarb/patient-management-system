package net.talaatharb.patientmanagementsystem.services;

import java.util.List;
import java.util.UUID;

import net.talaatharb.patientmanagementsystem.entities.MedicalCenterEntity;
import net.talaatharb.patientmanagementsystem.entities.OrganizationEntity;
import net.talaatharb.patientmanagementsystem.entities.PatientEntity;

public interface PatientManagementService {

	public OrganizationEntity createOrganization(OrganizationEntity organization);

	public List<OrganizationEntity> fetchOrganizations();


	public OrganizationEntity fetchOrganization(UUID organizationId);

	public MedicalCenterEntity createMedicalCenter(MedicalCenterEntity inputMedicalCenter);


	public abstract List<MedicalCenterEntity> fetchMedicalCenters(OrganizationEntity organization);

	public PatientEntity createPatient(PatientEntity patientEntity);
}
