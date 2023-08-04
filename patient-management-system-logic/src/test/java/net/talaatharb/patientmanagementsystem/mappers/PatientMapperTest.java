package net.talaatharb.patientmanagementsystem.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.mapstruct.factory.Mappers;

import net.talaatharb.patientmanagementsystem.dtos.PatientDto;
import net.talaatharb.patientmanagementsystem.entities.PatientEntity;

class PatientMapperTest implements DefaultMapperTest<PatientEntity, PatientDto>{

	@Override
	public void assertEqualEntityAndDto(PatientEntity e, PatientDto d) {
		assertEquals(e.getFirstName(), d.getFirstName());
		assertEquals(e.getLastName(), d.getLastName());
	}

	@Override
	public PatientDto createDTO() {
		PatientDto patientDto = new PatientDto();
		patientDto.setFirstName("Mohamed");
		patientDto.setLastName("Ahmed");
		return patientDto;
	}

	@Override
	public PatientEntity createEntity() {
		PatientEntity patientEntity = new PatientEntity();
		patientEntity.setFirstName("Mohamed");
		patientEntity.setLastName("Ahmed");
		return patientEntity;
	}

	@Override
	public DefaultMapper<PatientEntity, PatientDto> getMapper() {
		return Mappers.getMapper(PatientMapper.class);
	}
}
