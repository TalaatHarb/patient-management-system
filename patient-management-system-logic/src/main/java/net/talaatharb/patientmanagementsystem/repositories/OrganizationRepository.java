package net.talaatharb.patientmanagementsystem.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import net.talaatharb.patientmanagementsystem.entities.OrganizationEntity;

public interface OrganizationRepository extends JpaRepository<OrganizationEntity, UUID>{

}
