package net.talaatharb.patientmanagementsystem.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class MedicalCenterEntity {

	@Id
	private UUID id;

	private String name;

	@ManyToOne
	private OrganizationEntity organization;
}
