package net.talaatharb.patientmanagementsystem.dtos;

import java.util.UUID;

import lombok.Data;

@Data
public class PatientDto {
	
	private UUID id;

	private UUID organizationId;

	private UUID medicalCenterId;
	
	private String firstName;
	
	private String lastName;

}
