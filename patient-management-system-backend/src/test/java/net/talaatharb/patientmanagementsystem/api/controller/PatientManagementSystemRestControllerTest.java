package net.talaatharb.patientmanagementsystem.api.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.JsonProcessingException;

import net.talaatharb.patientmanagementsystem.AbstractControllerTest;
import net.talaatharb.patientmanagementsystem.dtos.OrganizationDto;

class PatientManagementSystemRestControllerTest extends AbstractControllerTest {

	private static final String CREATE_ORGANIZATION_URL = "/api/v1/organizations";

	@Test
	void testCreateOrganization() throws JsonProcessingException, Exception {
		// Arrange
		final OrganizationDto inputOrganization = new OrganizationDto();
		inputOrganization.setName("Test Organization");
		
		// Act
		final ResultActions result = this.mvc.perform(MockMvcRequestBuilders.post(CREATE_ORGANIZATION_URL).contentType(MediaType.APPLICATION_JSON_VALUE).content(this.objectMapper.writeValueAsString(inputOrganization)));
		
		// Assert
		result.andExpect(MockMvcResultMatchers.status().isCreated());
	}

}
