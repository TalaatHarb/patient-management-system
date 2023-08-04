package net.talaatharb.patientmanagementsystem.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class PatientEntity {

	@Id
	private UUID id;
	
	private String firstName;
	
	private String lastName;
	
	@ManyToOne
	private OrganizationEntity organization = new OrganizationEntity();
	
	@ManyToOne
	private MedicalCenterEntity medicalCenter = new MedicalCenterEntity();
}
