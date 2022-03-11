package net.talaatharb.patientmanagementsystem.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;

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

	@InjectMocks
	private PatientManagementServiceImpl patientManagementService;

	@Mock
	private OrganizationRepository organizationRepository;

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

}
