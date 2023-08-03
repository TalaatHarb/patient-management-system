package net.talaatharb.patientmanagementsystem.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;

import org.mapstruct.factory.Mappers;

import net.talaatharb.patientmanagementsystem.dtos.OrganizationDto;
import net.talaatharb.patientmanagementsystem.entities.OrganizationEntity;

class OrganizationMapperTest implements DefaultMapperTest<OrganizationEntity, OrganizationDto> {

	private static final String TEST_ORGANIZATION = "Test Organization";

	@Override
	public void assertEqualEntityAndDto(OrganizationEntity e, OrganizationDto d) {
		assertEquals(d.getId(), e.getId());
		assertEquals(d.getName(), e.getName());
	}

	@Override
	public OrganizationDto createDTO() {
		OrganizationDto dto = new OrganizationDto();
		dto.setId(UUID.randomUUID());
		dto.setName(TEST_ORGANIZATION);
		return dto;
	}

	@Override
	public OrganizationEntity createEntity() {
		OrganizationEntity entity = new OrganizationEntity();
		entity.setId(UUID.randomUUID());
		entity.setName(TEST_ORGANIZATION);
		return entity;
	}

	@Override
	public DefaultMapper<OrganizationEntity, OrganizationDto> getMapper() {
		return Mappers.getMapper(OrganizationMapper.class);
	}
}
