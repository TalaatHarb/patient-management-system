package net.talaatharb.patientmanagementsystem.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import net.talaatharb.patientmanagementsystem.dtos.OrganizationDto;
import net.talaatharb.patientmanagementsystem.entities.Organization;

class OrganizationMapperTest {
	
	private static final String TEST_ORGANIZATION = "Test Organization";
	private OrganizationMapper organizationMapper = Mappers.getMapper(OrganizationMapper.class);
	
	private void assertEqualEntityAndDto(Organization organization, OrganizationDto organizationDto) {
		assertEquals(organizationDto.getId(), organization.getId());
		assertEquals(organizationDto.getName(), organization.getName());
	}
	
	private void assertEqualOrganizationListAndDtoList(List<Organization> organizations, List<OrganizationDto> organizationDtos) {
		int dtosSize = organizationDtos.size();
		assertEquals(dtosSize, organizations.size());

		for (int i = 0; i < dtosSize; i++) {
			assertEqualEntityAndDto(organizations.get(i), organizationDtos.get(i));
		}
	}

	private OrganizationDto createDto() {
		OrganizationDto dto = new OrganizationDto();
		dto.setId(UUID.randomUUID());
		dto.setName(TEST_ORGANIZATION);
		return dto;
	}

	private Organization createEntity() {
		Organization entity = new Organization();
		entity.setId(UUID.randomUUID());
		entity.setName(TEST_ORGANIZATION);
		return entity;
	}

	@Test
	void testFromDTOToEntity() {
		OrganizationDto dto = createDto();
		
		Organization entity = organizationMapper.fromDTOToEntity(dto);
		assertEqualEntityAndDto(entity, dto);
	}

	@Test
	void testFromEntityListToDTOList() {
		List<Organization> entities = Arrays
				.asList(new Organization[] { createEntity(), createEntity() });
		List<OrganizationDto> dtos = organizationMapper.fromEntityToDTO(entities);

		assertEqualOrganizationListAndDtoList(entities, dtos);
	}

	@Test
	void testFromEntityPageToDtoPage() {
		Page<Organization> entityPage = new PageImpl<>(
				Arrays.asList(new Organization[] { createEntity(), createEntity() }));
		Page<OrganizationDto> dtoPage = organizationMapper.fromEntityToDTO(entityPage);

		assertEquals(entityPage.getNumber(), dtoPage.getNumber());
		assertEquals(entityPage.getNumberOfElements(), dtoPage.getNumberOfElements());

		assertEqualOrganizationListAndDtoList(entityPage.getContent(), dtoPage.getContent());
	}

	@Test
	void testFromEntityToDTO() {
		Organization entity = createEntity();
		
		OrganizationDto dto = organizationMapper.fromEntityToDTO(entity);
		assertEqualEntityAndDto(entity, dto);
	}

}
