package net.talaatharb.patientmanagementsystem.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import net.talaatharb.patientmanagementsystem.entities.MedicalCenterEntity;
import net.talaatharb.patientmanagementsystem.entities.OrganizationEntity;

public interface MedicalCenterRepository extends JpaRepository<MedicalCenterEntity, UUID>{
    public List<MedicalCenterEntity> findAllByOrganization(OrganizationEntity org);
}
