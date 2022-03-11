package net.talaatharb.patientmanagementsystem.services.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import net.talaatharb.patientmanagementsystem.entities.Organization;
import net.talaatharb.patientmanagementsystem.repositories.OrganizationRepository;
import net.talaatharb.patientmanagementsystem.services.PatientManagementService;

@Service
@RequiredArgsConstructor
public class PatientManagementServiceImpl implements PatientManagementService{
	
	private final OrganizationRepository organizationRepository;

	@Override
	@Transactional(readOnly = false)
	public Organization createOrganization(Organization organization) {
		organization.setId(UUID.randomUUID());
		return organizationRepository.save(organization);
	}

}
