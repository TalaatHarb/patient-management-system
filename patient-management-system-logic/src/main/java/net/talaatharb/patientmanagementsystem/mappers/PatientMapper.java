package net.talaatharb.patientmanagementsystem.mappers;

import org.mapstruct.Mapper;

import net.talaatharb.patientmanagementsystem.dtos.PatientDto;
import net.talaatharb.patientmanagementsystem.entities.PatientEntity;

@Mapper
public interface PatientMapper extends DefaultMapper<PatientEntity, PatientDto> {

}
