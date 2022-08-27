package net.talaatharb.patientmanagementsystem.facades.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import net.talaatharb.patientmanagementsystem.dtos.MedicalCenterDto;
import net.talaatharb.patientmanagementsystem.entities.MedicalCenter;
import net.talaatharb.patientmanagementsystem.mappers.MedicalCenterMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import net.talaatharb.patientmanagementsystem.dtos.OrganizationDto;
import net.talaatharb.patientmanagementsystem.entities.Organization;
import net.talaatharb.patientmanagementsystem.mappers.OrganizationMapper;
import net.talaatharb.patientmanagementsystem.services.PatientManagementService;

@ExtendWith(MockitoExtension.class)
class PatientManagementFacadeImplTest {

	private static final String TEST_ORGANIZATION = "Test Organization";
	private static final String TEST_MEDICAL_CENTER = "Test Medical Center";

	@InjectMocks
	private PatientManagementFacadeImpl patientManagementFacade;

	@Mock
	private OrganizationMapper organizationMapper;

	@Mock
	private MedicalCenterMapper medicalCenterMapper;
	@Mock
	private PatientManagementService patientManagementService;

	@Test
	void testCreateOrganization() {
		// Arrange
		final OrganizationDto inputOrganization = new OrganizationDto();
		inputOrganization.setName(TEST_ORGANIZATION);
		
		final OrganizationDto expectedResult = new OrganizationDto();
		expectedResult.setId(UUID.randomUUID());
		expectedResult.setName(TEST_ORGANIZATION);
		
		Mockito.when(organizationMapper.fromDTOToEntity(inputOrganization)).thenReturn(new Organization());
		Mockito.when(patientManagementService.createOrganization(Mockito.any(Organization.class))).thenReturn(new Organization());
		Mockito.when(organizationMapper.fromEntityToDTO(Mockito.any(Organization.class))).thenReturn(expectedResult);
		
		// Act
		final OrganizationDto result = patientManagementFacade.createOrganization(inputOrganization);
		
		// Assert
		Mockito.verify(organizationMapper).fromDTOToEntity(inputOrganization);
		Mockito.verify(patientManagementService).createOrganization(Mockito.any(Organization.class));
		Mockito.verify(organizationMapper).fromEntityToDTO(Mockito.any(Organization.class));
		assertEquals(expectedResult, result);
	}
	
	@Test
	void testFetchOrganizations() {
		// Arrange
		final OrganizationDto organizationDto = new OrganizationDto();
		organizationDto.setName(TEST_ORGANIZATION);
		organizationDto.setId(UUID.randomUUID());
		
		final Organization organization = new Organization();
		organization.setName(TEST_ORGANIZATION);
		organization.setId(organizationDto.getId());
		
		final List<Organization> orgs = new ArrayList<>();
		orgs.add(organization);
		
		final List<OrganizationDto> orgDtos = new ArrayList<>();
		orgDtos.add(organizationDto);
		
		Mockito.when(patientManagementService.fetchOrganizations()).thenReturn(orgs);
		Mockito.when(organizationMapper.fromEntityToDTO(Mockito.anyList())).thenReturn(orgDtos);
		
		// Act
		List<OrganizationDto> result = patientManagementFacade.fetchOrganizations();
		
		// Assert
		assertEquals(1, result.size());
		assertEquals(orgDtos.get(0), result.get(0));
		
		Mockito.verify(patientManagementService).fetchOrganizations();
		Mockito.verify(organizationMapper).fromEntityToDTO(Mockito.anyList());
	}

	@Test
	void testFetchMedicalCenters() throws Exception {
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

		MedicalCenterDto medicalCenterDto = new MedicalCenterDto();
		medicalCenterDto.setName(TEST_MEDICAL_CENTER);
		medicalCenterDto.setOrganizationId(Id);

		// TODO: Replace this with a mock for mapper, when you understand how it works.
		// start
		List <MedicalCenterDto> medicalCenterDtos = new ArrayList<>();
		Mockito.when(medicalCenterMapper.fromEntityToDTO(medicalCenter1)).thenReturn(medicalCenterDto);
		Mockito.when(medicalCenterMapper.fromEntityToDTO(medicalCenter2)).thenReturn(medicalCenterDto);

		medicalCenterDtos.add(medicalCenterDto);
		medicalCenterDtos.add(medicalCenterDto);
		// end

		Mockito.when(patientManagementService.fetchOrganization(Id)).thenReturn(organization);
		Mockito.when(patientManagementService.fetchMedicalCenters(organization)).thenReturn(List.of(medicalCenter1, medicalCenter2));


		// Act
		List<MedicalCenterDto> result = patientManagementFacade.fetchMedicalCenters(Id);

		// Assert
		assertEquals(2, result.size());
		assertEquals(medicalCenterDto, result.get(0));
		assertEquals(medicalCenterDto, result.get(1));

		Mockito.verify(patientManagementService).fetchMedicalCenters(organization);
		Mockito.verify(patientManagementService).fetchOrganization(Id);
	}
}
