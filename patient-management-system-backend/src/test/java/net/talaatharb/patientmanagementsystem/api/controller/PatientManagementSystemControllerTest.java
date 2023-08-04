package net.talaatharb.patientmanagementsystem.api.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import net.talaatharb.patientmanagementsystem.dtos.MedicalCenterDto;
import net.talaatharb.patientmanagementsystem.dtos.PatientDto;
import net.talaatharb.patientmanagementsystem.facades.PatientManagementFacade;

@ExtendWith(MockitoExtension.class)
class PatientManagementSystemControllerTest {
	
	private static final String TEST_MEDICAL_CENTER = "Test Medical Center";
	
	private static final UUID TEST_ORGANIZTION_ID = UUID.fromString("0de753f6-5b1b-4e60-8834-521c06dfafb4");
	private static final UUID TEST_MEDICAL_CENTER_ID = UUID.fromString("0de753f6-5b1b-4e60-8344-521c06dfafb4");
	
	
	@InjectMocks
	PatientManagementSystemRestController patientManagementApi;
	
	@Mock
	PatientManagementFacade patientManagementFacade;
	
	@Test
	void testCreateMedicalCenterWithInvalidOrganization() {
		final MedicalCenterDto inputMedicalCenter = new MedicalCenterDto();
		inputMedicalCenter.setName(TEST_MEDICAL_CENTER);
		inputMedicalCenter.setOrganizationId(null);
		
		Executable action = () -> patientManagementApi.createMedicalCenter(inputMedicalCenter, null);
		
		assertThrows(ResponseStatusException.class, action);
	}
	
	@Test
	void testCreateMedicalCenterWithInvalidName() {
		final MedicalCenterDto inputMedicalCenter = new MedicalCenterDto();
		inputMedicalCenter.setName("");
		UUID randomUUID = UUID.randomUUID();
		inputMedicalCenter.setOrganizationId(randomUUID);
		
		Executable action = () -> patientManagementApi.createMedicalCenter(inputMedicalCenter, randomUUID.toString());
		
		assertThrows(ResponseStatusException.class, action);
	}
	
	@Test
	void testFetchMedicalCentersWithInvalidOrganization() {
		when(patientManagementFacade.fetchMedicalCenters(any(UUID.class))).thenReturn(null);
		Executable action = () -> patientManagementApi.fetchMedicalCenters(UUID.randomUUID());
		
		assertThrows(ResponseStatusException.class, action);
	}
	
	@Test
	void testCreatePatientCallsFacade() {
		// Given
		final PatientDto patientDto = new PatientDto();
		patientDto.setOrganizationId(TEST_ORGANIZTION_ID);
		patientDto.setMedicalCenterId(TEST_MEDICAL_CENTER_ID);
		patientDto.setFirstName("Mohamed");
		patientDto.setLastName("Ahmed");
		
		// When
		patientManagementApi.createPatient(patientDto);
		
		// Then
		verify(patientManagementFacade).createPatient(patientDto);
		
	}

}
