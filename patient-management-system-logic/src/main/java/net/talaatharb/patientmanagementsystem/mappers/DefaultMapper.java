package net.talaatharb.patientmanagementsystem.mappers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

public interface DefaultMapper<E, D> {

	/**
	 * Convert a dto to an entity
	 * 
	 * @param dto the dto to be converted
	 * @return The entity resulting from converting the given dto
	 */
	public abstract E fromDtoToEntity(D dto);

	/**
	 * Convert an entity to a dto
	 * 
	 * @param entity the entity to be converted
	 * @return the dto resulting from converting the given entity
	 */
	public abstract D fromEntityToDto(E entity);

	/**
	 * Convert a list of entities to a list of dtos
	 * 
	 * @param entityList the list of entities to convert
	 * @return the resulting dto list from converting the entity list
	 */
	public abstract List<D> fromEntityToDto(List<E> entityList);

	/**
	 * Convert a list of Dtos to a list of entities
	 * 
	 * @param entityDtos the list of dtos to convert
	 * @return the resulting entity list from converting the entity list
	 */
	public abstract List<E> fromDtoToEntity(List<D> entityDtos);

	/**
	 * Convert a page of entities to a page of dtos
	 * 
	 * @param entityPage the page of entities to convert
	 * @return the resulting dto page from converting the entity page
	 */
	public default Page<D> fromEntityToDto(Page<E> entityPage) {
		List<D> dtos = this.fromEntityToDto(entityPage.getContent());
		return new PageImpl<>(dtos, entityPage.getPageable(), entityPage.getTotalElements());
	}
}
