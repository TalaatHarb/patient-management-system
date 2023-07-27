package net.talaatharb.patientmanagementsystem.api.controller;

import java.util.UUID;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;

import net.talaatharb.patientmanagementsystem.AbstractControllerTest;
import net.talaatharb.patientmanagementsystem.dtos.MedicalCenterDto;
import net.talaatharb.patientmanagementsystem.dtos.OrganizationDto;
import net.talaatharb.patientmanagementsystem.entities.MedicalCenter;
import net.talaatharb.patientmanagementsystem.entities.Organization;
import net.talaatharb.patientmanagementsystem.repositories.OrganizationRepository;

class PatientManagementSystemRestControllerTest extends AbstractControllerTest {

	private static final String TEST_ORGANIZATION = "Test Organization";
	private static final String ORGANIZATION_URL = "/api/v1/organizations";
	private static final String TEST_MEDICAL_CENTER = "Test Medical Center";
	private static final UUID TEST_ORGANIZTION_ID = UUID.fromString("0de753f6-5b1b-4e60-8834-521c06dfafb4");
	private static final String MEDICAL_CENTER_URL_SEGEMENT = "/medical-centers";

	@Autowired
	private OrganizationRepository organizationRepository;
	
	@Test
	void testCreateOrganization() throws JsonProcessingException, Exception {
		// Arrange
		final OrganizationDto inputOrganization = new OrganizationDto();
		inputOrganization.setName(TEST_ORGANIZATION);

		// Act
		final ResultActions result = this.mvc
				.perform(MockMvcRequestBuilders.post(ORGANIZATION_URL).contentType(MediaType.APPLICATION_JSON_VALUE)
						.content(this.objectMapper.writeValueAsString(inputOrganization)));

		// Assert
		result.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(MockMvcResultMatchers.jsonPath("$.name", CoreMatchers.is(TEST_ORGANIZATION)))
				.andExpect(MockMvcResultMatchers.jsonPath("$.id", CoreMatchers.notNullValue()));
	}

	@Test
	@Transactional(readOnly = false)
	void testCreateMedicalCenter() throws JsonProcessingException, Exception {
		// Arrange
		Organization organization = new Organization();
		organization.setId(TEST_ORGANIZTION_ID);
		organization.setName(TEST_ORGANIZATION);
		organizationRepository.save(organization);
		
		final MedicalCenterDto inputMedicalCenter = new MedicalCenterDto();
		inputMedicalCenter.setName(TEST_MEDICAL_CENTER);
		inputMedicalCenter.setOrganizationId(TEST_ORGANIZTION_ID);
		String medicalCenterURL = ORGANIZATION_URL + "/" + TEST_ORGANIZTION_ID.toString() + MEDICAL_CENTER_URL_SEGEMENT;

		// Act
		final ResultActions result = this.mvc
				.perform(MockMvcRequestBuilders.post(medicalCenterURL).contentType(MediaType.APPLICATION_JSON_VALUE)
						.content(this.objectMapper.writeValueAsString(inputMedicalCenter)));

		// Assert
		result.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(MockMvcResultMatchers.jsonPath("$.name", CoreMatchers.is(TEST_MEDICAL_CENTER)))
				.andExpect(MockMvcResultMatchers.jsonPath("$.organizationId", CoreMatchers.is(TEST_ORGANIZTION_ID.toString())))
				.andExpect(MockMvcResultMatchers.jsonPath("$.id", CoreMatchers.notNullValue()));
	}

	@Test
	void testFetchOrganization() throws JsonProcessingException, Exception {
		// Arrange

		// Act
		final ResultActions result = this.mvc
				.perform(MockMvcRequestBuilders.get(ORGANIZATION_URL).accept(MediaType.APPLICATION_JSON_VALUE));

		// Assert
		result.andExpect(MockMvcResultMatchers.status().isOk());
	}


	@Test
	void testFetchMedicalCenters() throws JsonProcessingException, Exception {
		// Arrange
		Organization organization = new Organization();
		organization.setId(TEST_ORGANIZTION_ID);
		organization.setName(TEST_ORGANIZATION);
		organization = organizationRepository.save(organization);

		MedicalCenter medicalCenter = new MedicalCenter();
		medicalCenter.setName(TEST_MEDICAL_CENTER);
		medicalCenter.setOrganization(organization);


		String medicalCentersURL = ORGANIZATION_URL + "/" + TEST_ORGANIZTION_ID.toString() + MEDICAL_CENTER_URL_SEGEMENT;

		// Act
		final ResultActions result = this.mvc
				.perform(MockMvcRequestBuilders.get(medicalCentersURL).accept(MediaType.APPLICATION_JSON_VALUE));

		// Assert
		result.andExpect(MockMvcResultMatchers.status().isOk());
	}
}
