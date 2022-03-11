package net.talaatharb.patientmanagementsystem.api.controller;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.JsonProcessingException;

import net.talaatharb.patientmanagementsystem.AbstractControllerTest;
import net.talaatharb.patientmanagementsystem.dtos.OrganizationDto;

class PatientManagementSystemRestControllerTest extends AbstractControllerTest {

	private static final String TEST_ORGANIZATION = "Test Organization";
	private static final String ORGANIZATION_URL = "/api/v1/organizations";

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
	void testFetchOrganization() throws JsonProcessingException, Exception {
		// Arrange

		// Act
		final ResultActions result = this.mvc
				.perform(MockMvcRequestBuilders.get(ORGANIZATION_URL).accept(MediaType.APPLICATION_JSON_VALUE));

		// Assert
		result.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
