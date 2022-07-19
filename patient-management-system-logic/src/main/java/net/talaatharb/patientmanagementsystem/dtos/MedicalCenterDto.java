package net.talaatharb.patientmanagementsystem.dtos;

import java.util.UUID;

import lombok.Data;

@Data
public class MedicalCenterDto {
	
	private UUID id;

	private String name;
	
	private UUID organizationId;
}
