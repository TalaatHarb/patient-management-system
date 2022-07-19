package net.talaatharb.patientmanagementsystem.entities;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class MedicalCenter {

	@Id
	private UUID id;

	private String name;

	@ManyToOne
	private Organization organization;
}
