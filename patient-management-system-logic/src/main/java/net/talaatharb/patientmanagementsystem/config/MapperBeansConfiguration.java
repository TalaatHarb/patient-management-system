package net.talaatharb.patientmanagementsystem.config;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.talaatharb.patientmanagementsystem.mappers.MedicalCenterMapper;
import net.talaatharb.patientmanagementsystem.mappers.OrganizationMapper;
import net.talaatharb.patientmanagementsystem.mappers.PatientMapper;

@Configuration
public class MapperBeansConfiguration {

	@Bean
	OrganizationMapper organizationMapper() {
		return Mappers.getMapper(OrganizationMapper.class);
	}

	@Bean
	MedicalCenterMapper centerMapper() {
		return Mappers.getMapper(MedicalCenterMapper.class);
	}
	
	@Bean
	PatientMapper patientMapper() {
		return Mappers.getMapper(PatientMapper.class);
	}
}
