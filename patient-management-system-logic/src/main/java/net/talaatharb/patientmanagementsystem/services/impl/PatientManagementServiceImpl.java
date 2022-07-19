package net.talaatharb.patientmanagementsystem.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import net.talaatharb.patientmanagementsystem.entities.MedicalCenter;
import net.talaatharb.patientmanagementsystem.entities.Organization;
import net.talaatharb.patientmanagementsystem.repositories.MedicalCenterRepository;
import net.talaatharb.patientmanagementsystem.repositories.OrganizationRepository;
import net.talaatharb.patientmanagementsystem.services.PatientManagementService;

@Service
@RequiredArgsConstructor
public class PatientManagementServiceImpl implements PatientManagementService{
	
	private final OrganizationRepository organizationRepository;
	
	private final MedicalCenterRepository medicalCenterRepository;

	@Override
	@Transactional(readOnly = false)
	public Organization createOrganization(Organization organization) {
		organization.setId(UUID.randomUUID());
		return organizationRepository.save(organization);
	}

	@Override
	public List<Organization> fetchOrganizations() {
		return organizationRepository.findAll();
	}

	@Override
	public MedicalCenter createMedicalCenter(MedicalCenter inputMedicalCenter) {
		Organization organization = organizationRepository.getById(inputMedicalCenter.getOrganization().getId());
		inputMedicalCenter.setOrganization(organization);
		inputMedicalCenter.setId(UUID.randomUUID());
		final MedicalCenter outputMedicalCenter = medicalCenterRepository.save(inputMedicalCenter);
		return outputMedicalCenter;
	}

}
