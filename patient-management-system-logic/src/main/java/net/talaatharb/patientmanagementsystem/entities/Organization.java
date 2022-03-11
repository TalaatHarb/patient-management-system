package net.talaatharb.patientmanagementsystem.entities;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Organization {

	@Id
	private UUID id;
	
	private String name;
}
