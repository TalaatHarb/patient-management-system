package net.talaatharb.patientmanagementsystem.dtos;

import java.util.UUID;

import lombok.Data;

@Data
public class OrganizationDto {
	
	private UUID id;

	private String name;
}
