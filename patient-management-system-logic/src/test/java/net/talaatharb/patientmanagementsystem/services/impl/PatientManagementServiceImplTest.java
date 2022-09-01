package net.talaatharb.patientmanagementsystem.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import net.talaatharb.patientmanagementsystem.dtos.MedicalCenterDto;
import net.talaatharb.patientmanagementsystem.entities.MedicalCenter;
import net.talaatharb.patientmanagementsystem.repositories.MedicalCenterRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import net.talaatharb.patientmanagementsystem.entities.Organization;
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
		final Organization inputOrganization = new Organization();
		inputOrganization.setName(TEST_ORGANIZATION);
		
		final Organization expectedResult = new Organization();
		expectedResult.setId(UUID.randomUUID());
		expectedResult.setName(TEST_ORGANIZATION);
		
		Mockito.when(organizationRepository.save(inputOrganization)).thenReturn(expectedResult);
		
		// Act
		final Organization result = patientManagementService.createOrganization(inputOrganization);
		
		// Assert
		Mockito.verify(organizationRepository).save(Mockito.any(Organization.class));
		assertEquals(expectedResult, result);
	}

	@Test
	void testFetchOrganization() {
		// Arrange
		UUID Id = UUID.randomUUID();
		final Organization organization = new Organization();
		organization.setName(TEST_ORGANIZATION);
		organization.setId(Id);


		Mockito.when(organizationRepository.findById(Id)).thenReturn(Optional.of(organization));


		// Act
		final Organization result = patientManagementService.fetchOrganization(Id);

		// Assert
		assertEquals(organization, result);
	}

	@Test
	void testFetchMedicalCenters() {
		// Arrange
		UUID Id = UUID.randomUUID();
		final Organization organization = new Organization();
		organization.setName(TEST_ORGANIZATION);
		organization.setId(Id);

		final MedicalCenter medicalCenter1 = new MedicalCenter();
		medicalCenter1.setName(TEST_MEDICAL_CENTER);
		medicalCenter1.setOrganization(organization);

		final MedicalCenter medicalCenter2 = new MedicalCenter();
		medicalCenter2.setName(TEST_MEDICAL_CENTER);
		medicalCenter2.setOrganization(organization);

		Mockito.when(medicalCenterRepository.findAllByOrganization(organization))
				.thenReturn(List.of(medicalCenter1, medicalCenter2));
		// Act
		final List<MedicalCenter> result = patientManagementService.fetchMedicalCenters(organization);

		// Assert
		assertEquals(List.of(medicalCenter1, medicalCenter2), result);
	}
}
