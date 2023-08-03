package net.talaatharb.patientmanagementsystem.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;

import org.mapstruct.factory.Mappers;

import net.talaatharb.patientmanagementsystem.dtos.MedicalCenterDto;
import net.talaatharb.patientmanagementsystem.entities.MedicalCenterEntity;
import net.talaatharb.patientmanagementsystem.entities.OrganizationEntity;

public class MedicalCenterMapperTest implements DefaultMapperTest<MedicalCenterEntity, MedicalCenterDto> {
	
	private static final String MEDICAL_CENTER_NAME = "Test Center";
	private static final UUID ORGANIZATION_ID = UUID.fromString("1d889e47-6a9c-4e9b-966c-3573097f0aa9");

	@Override
	public void assertEqualEntityAndDto(MedicalCenterEntity e, MedicalCenterDto d) {
		assertEquals(e.getName(), d.getName());
		assertEquals(e.getOrganization().getId(), d.getOrganizationId());
	}

	@Override
	public MedicalCenterDto createDTO() {
		MedicalCenterDto medicalCenterDto = new MedicalCenterDto();
		medicalCenterDto.setName(MEDICAL_CENTER_NAME);
		medicalCenterDto.setOrganizationId(ORGANIZATION_ID);
		
		return medicalCenterDto;
	}

	@Override
	public MedicalCenterEntity createEntity() {
		MedicalCenterEntity medicalCenterEntity = new MedicalCenterEntity();
		medicalCenterEntity.setName(MEDICAL_CENTER_NAME);
		
		OrganizationEntity organizationEntity = new OrganizationEntity();
		organizationEntity.setId(ORGANIZATION_ID);
		
		medicalCenterEntity.setOrganization(organizationEntity);
		
		return medicalCenterEntity;
	}

	@Override
	public DefaultMapper<MedicalCenterEntity, MedicalCenterDto> getMapper() {
		return Mappers.getMapper(MedicalCenterMapper.class);
	}

}
