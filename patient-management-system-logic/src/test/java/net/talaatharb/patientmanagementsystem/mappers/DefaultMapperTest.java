package net.talaatharb.patientmanagementsystem.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

public interface DefaultMapperTest<E, D> {
	public abstract void assertEqualEntityAndDto(E e, D d);

	default void assertEqualEntityListAndDtoList(List<E> eList, List<D> dtoList) {
		int dtosSize = dtoList.size();
		assertEquals(dtosSize, eList.size());

		for (int i = 0; i < dtosSize; i++) {
			assertEqualEntityAndDto(eList.get(i), dtoList.get(i));
		}
	}

	public abstract D createDTO();

	public abstract E createEntity();

	public abstract DefaultMapper<E, D> getMapper();

	@Test
	default void testDTOMappingIsBidirectional() {
		D dto = createDTO();
		D mappedDto = getMapper().fromEntityToDto(getMapper().fromDtoToEntity(dto));
		assertEquals(dto, mappedDto);
		assertEquals(dto.hashCode(), mappedDto.hashCode());
	}

	@Test
	default void testFromDTOToEntity() {
		D dto = createDTO();

		E entity = getMapper().fromDtoToEntity(dto);
		assertEqualEntityAndDto(entity, dto);
	}

	@Test
	default void testFromEntityListToDTOList() {
		List<E> entities = Arrays.asList(createEntity(), createEntity());
		List<D> dtos = getMapper().fromEntityToDto(entities);

		assertEqualEntityListAndDtoList(entities, dtos);
	}

	@Test
	default void testFromEntityPageToDTOPage() {
		Page<E> entityPage = new PageImpl<>(Arrays.asList(createEntity(), createEntity()));
		Page<D> dtoPage = getMapper().fromEntityToDto(entityPage);

		assertEquals(entityPage.getNumber(), dtoPage.getNumber());
		assertEquals(entityPage.getNumberOfElements(), dtoPage.getNumberOfElements());

		assertEqualEntityListAndDtoList(entityPage.getContent(), dtoPage.getContent());
	}

	@Test
	default void testFromEntityToDTO() {
		E entity = createEntity();

		D dto = getMapper().fromEntityToDto(entity);
		assertEqualEntityAndDto(entity, dto);
	}
}
