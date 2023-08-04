package net.talaatharb.patientmanagementsystem.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import net.talaatharb.patientmanagementsystem.entities.MedicalCenterEntity;
import net.talaatharb.patientmanagementsystem.entities.OrganizationEntity;
import net.talaatharb.patientmanagementsystem.entities.PatientEntity;
import net.talaatharb.patientmanagementsystem.repositories.MedicalCenterRepository;
import net.talaatharb.patientmanagementsystem.repositories.OrganizationRepository;
import net.talaatharb.patientmanagementsystem.repositories.PatientRepository;
import net.talaatharb.patientmanagementsystem.services.PatientManagementService;

@Service
@RequiredArgsConstructor
public class PatientManagementServiceImpl implements PatientManagementService{
	
	private final OrganizationRepository organizationRepository;
	
	private final MedicalCenterRepository medicalCenterRepository;
	
	private final PatientRepository patientRepository;

	@Override
	@Transactional(readOnly = false)
	public OrganizationEntity createOrganization(OrganizationEntity organization) {
		organization.setId(UUID.randomUUID());
		return organizationRepository.save(organization);
	}

	@Override
	public List<OrganizationEntity> fetchOrganizations() {
		return organizationRepository.findAll();
	}

	@Override
	public OrganizationEntity fetchOrganization(UUID organizationId) {
		Optional<OrganizationEntity> org = organizationRepository.findById(organizationId);
		return org.isPresent() ? org.get() : null;
	}

	@Override
	public MedicalCenterEntity createMedicalCenter(MedicalCenterEntity inputMedicalCenter) {
		organizationRepository.findById(inputMedicalCenter.getOrganization().getId()).ifPresent(organization -> {			
			inputMedicalCenter.setOrganization(organization);
			inputMedicalCenter.setId(UUID.randomUUID());
		});
		return medicalCenterRepository.save(inputMedicalCenter);
	}

	@Override
	public List<MedicalCenterEntity> fetchMedicalCenters(OrganizationEntity organization) {
		return medicalCenterRepository.findAllByOrganization(organization);
	}

	@Override
	public PatientEntity createPatient(PatientEntity patientEntity) {
		patientEntity.setId(UUID.randomUUID());
		return patientRepository.save(patientEntity);
	}

}
