package net.talaatharb.patientmanagementsystem.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.talaatharb.patientmanagementsystem.entities.MedicalCenter;

@Repository
public interface MedicalCenterRepository extends JpaRepository<MedicalCenter, UUID>{

}
