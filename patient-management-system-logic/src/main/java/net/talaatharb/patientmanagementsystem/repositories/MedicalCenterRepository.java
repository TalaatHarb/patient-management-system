package net.talaatharb.patientmanagementsystem.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import net.talaatharb.patientmanagementsystem.entities.MedicalCenter;
import net.talaatharb.patientmanagementsystem.entities.Organization;

public interface MedicalCenterRepository extends JpaRepository<MedicalCenter, UUID>{
    public List<MedicalCenter> findAllByOrganization(Organization org);
}
