package net.talaatharb.patientmanagementsystem.facades.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import net.talaatharb.patientmanagementsystem.dtos.MedicalCenterDto;
import net.talaatharb.patientmanagementsystem.dtos.OrganizationDto;
import net.talaatharb.patientmanagementsystem.entities.MedicalCenterEntity;
import net.talaatharb.patientmanagementsystem.entities.OrganizationEntity;
import net.talaatharb.patientmanagementsystem.mappers.MedicalCenterMapper;
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

		Mockito.when(organizationMapper.fromDtoToEntity(inputOrganization)).thenReturn(new OrganizationEntity());
		Mockito.when(patientManagementService.createOrganization(Mockito.any(OrganizationEntity.class)))
				.thenReturn(new OrganizationEntity());
		Mockito.when(organizationMapper.fromEntityToDto(Mockito.any(OrganizationEntity.class)))
				.thenReturn(expectedResult);

		// Act
		final OrganizationDto result = patientManagementFacade.createOrganization(inputOrganization);

		// Assert
		Mockito.verify(organizationMapper).fromDtoToEntity(inputOrganization);
		Mockito.verify(patientManagementService).createOrganization(Mockito.any(OrganizationEntity.class));
		Mockito.verify(organizationMapper).fromEntityToDto(Mockito.any(OrganizationEntity.class));
		assertEquals(expectedResult, result);
	}

	@Test
	void testFetchOrganizations() {
		// Arrange
		final OrganizationDto organizationDto = new OrganizationDto();
		organizationDto.setName(TEST_ORGANIZATION);
		organizationDto.setId(UUID.randomUUID());

		final OrganizationEntity organization = new OrganizationEntity();
		organization.setName(TEST_ORGANIZATION);
		organization.setId(organizationDto.getId());

		final List<OrganizationEntity> orgs = new ArrayList<>();
		orgs.add(organization);

		final List<OrganizationDto> orgDtos = new ArrayList<>();
		orgDtos.add(organizationDto);

		Mockito.when(patientManagementService.fetchOrganizations()).thenReturn(orgs);
		Mockito.when(organizationMapper.fromEntityToDto(Mockito.anyList())).thenReturn(orgDtos);

		// Act
		List<OrganizationDto> result = patientManagementFacade.fetchOrganizations();

		// Assert
		assertEquals(1, result.size());
		assertEquals(orgDtos.get(0), result.get(0));

		Mockito.verify(patientManagementService).fetchOrganizations();
		Mockito.verify(organizationMapper).fromEntityToDto(Mockito.anyList());
	}

	@Test
	void testFetchMedicalCenters() throws Exception {
		// Arrange
		UUID Id = UUID.randomUUID();
		final OrganizationEntity organization = createOrgainization(Id);

		List<MedicalCenterDto> medicalCenterDtos = List.of(createMedicalCenterDto(Id), createMedicalCenterDto(Id));
		
		Mockito.when(medicalCenterMapper.fromEntityToDto(ArgumentMatchers.<List<MedicalCenterEntity>>any()))
				.thenReturn(medicalCenterDtos);

		// end

		Mockito.when(patientManagementService.fetchOrganization(Id)).thenReturn(organization);
		Mockito.when(patientManagementService.fetchMedicalCenters(organization))
				.thenReturn(List.of(createMedicalCenter(organization), createMedicalCenter(organization)));

		// Act
		List<MedicalCenterDto> result = patientManagementFacade.fetchMedicalCenters(Id);

		// Assert
		assertEquals(2, result.size());

		Mockito.verify(patientManagementService).fetchMedicalCenters(organization);
		Mockito.verify(patientManagementService).fetchOrganization(Id);
	}

	private MedicalCenterDto createMedicalCenterDto(UUID id) {
		MedicalCenterDto medicalCenterDto = new MedicalCenterDto();
		medicalCenterDto.setName(TEST_MEDICAL_CENTER);
		medicalCenterDto.setOrganizationId(id);
		return medicalCenterDto;
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
	
	@Test
	void testCreateMedicalCenter() {
		MedicalCenterDto medicalCenterDto = createMedicalCenterDto(UUID.randomUUID());
		
		patientManagementFacade.createMedicalCenter(medicalCenterDto);
		
		Mockito.verify(patientManagementService).createMedicalCenter(ArgumentMatchers.any());
	
	}
	
	@Test
	void testFetchMedicalCentersWithInvalidOrganizationId() {
		when(patientManagementService.fetchOrganization(any(UUID.class))).thenReturn(null);
		
		 List<MedicalCenterDto> centers = patientManagementFacade.fetchMedicalCenters(UUID.randomUUID());
		
		assertEquals(0, centers.size());
	}
}
