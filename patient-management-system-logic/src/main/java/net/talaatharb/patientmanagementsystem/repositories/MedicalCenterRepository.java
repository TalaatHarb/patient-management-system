package net.talaatharb.patientmanagementsystem.repositories;

import java.util.List;
import java.util.UUID;

import net.talaatharb.patientmanagementsystem.entities.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.talaatharb.patientmanagementsystem.entities.MedicalCenter;

@Repository
public interface MedicalCenterRepository extends JpaRepository<MedicalCenter, UUID>{
    public List<MedicalCenter> findAllByOrganization(Organization org);
}
