package net.talaatharb.patientmanagementsystem.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class OrganizationEntity {

	@Id
	private UUID id;
	
	private String name;
}
