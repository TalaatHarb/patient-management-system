package net.talaatharb.patientmanagementsystem.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import net.talaatharb.patientmanagementsystem.entities.MedicalCenterEntity;
import net.talaatharb.patientmanagementsystem.entities.OrganizationEntity;
import net.talaatharb.patientmanagementsystem.repositories.MedicalCenterRepository;
import net.talaatharb.patientmanagementsystem.repositories.OrganizationRepository;

@ExtendWith(MockitoExtension.class)
class PatientManagementServiceImplTest {

	private static final String TEST_ORGANIZATION = "Test Organization";

	private static final String TEST_MEDICAL_CENTER = "Test Medical Center";
	@InjectMocks
	private PatientManagementServiceImpl patientManagementService;

	@Mock
	private OrganizationRepository organizationRepository;

	@Mock
	private MedicalCenterRepository medicalCenterRepository;

	@Test
	void testCreateOrganization() {
		// Arrange
		final OrganizationEntity inputOrganization = new OrganizationEntity();
		inputOrganization.setName(TEST_ORGANIZATION);

		final OrganizationEntity expectedResult = new OrganizationEntity();
		expectedResult.setId(UUID.randomUUID());
		expectedResult.setName(TEST_ORGANIZATION);

		Mockito.when(organizationRepository.save(inputOrganization)).thenReturn(expectedResult);

		// Act
		final OrganizationEntity result = patientManagementService.createOrganization(inputOrganization);

		// Assert
		Mockito.verify(organizationRepository).save(Mockito.any(OrganizationEntity.class));
		assertEquals(expectedResult, result);
	}

	@Test
	void testCreateMedicalCenter() {
		// Arrange
		OrganizationEntity organization = createOrgainization(UUID.randomUUID());
		MedicalCenterEntity medicalCenter = createMedicalCenter(organization);

		Mockito.when(organizationRepository.findById(Mockito.any(UUID.class))).thenReturn(Optional.of(organization));
		Mockito.when(medicalCenterRepository.save(medicalCenter)).thenReturn(medicalCenter);

		// Act
		final MedicalCenterEntity result = patientManagementService.createMedicalCenter(medicalCenter);

		// Assert
		Mockito.verify(medicalCenterRepository).save(Mockito.any(MedicalCenterEntity.class));
		assertEquals(medicalCenter, result);
	}

	@Test
	void testFetchOrganization() {
		// Arrange
		UUID Id = UUID.randomUUID();
		final OrganizationEntity organization = createOrgainization(Id);

		Mockito.when(organizationRepository.findById(Id)).thenReturn(Optional.of(organization));

		// Act
		final OrganizationEntity result = patientManagementService.fetchOrganization(Id);

		// Assert
		assertEquals(organization, result);
	}

	@Test
	void testFetchMedicalCenters() {
		// Arrange
		UUID id = UUID.randomUUID();
		final OrganizationEntity organization = createOrgainization(id);

		final MedicalCenterEntity medicalCenter1 = createMedicalCenter(organization);

		final MedicalCenterEntity medicalCenter2 = createMedicalCenter(organization);

		Mockito.when(medicalCenterRepository.findAllByOrganization(organization))
				.thenReturn(List.of(medicalCenter1, medicalCenter2));
		// Act
		final List<MedicalCenterEntity> result = patientManagementService.fetchMedicalCenters(organization);

		// Assert
		assertEquals(List.of(medicalCenter1, medicalCenter2), result);
	}

	private MedicalCenterEntity createMedicalCenter(final OrganizationEntity organization) {
		final MedicalCenterEntity medicalCenter1 = new MedicalCenterEntity();
		medicalCenter1.setName(TEST_MEDICAL_CENTER);
		medicalCenter1.setOrganization(organization);
		return medicalCenter1;
	}

	private OrganizationEntity createOrgainization(UUID id) {
		final OrganizationEntity organization = new OrganizationEntity();
		organization.setName(TEST_ORGANIZATION);
		organization.setId(id);
		return organization;
	}
}
