package com.jubiter.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.jubiter.modelo.EmpleadoRRHH;

/**
 * A veces en los servicios REST se olvidan otra serie de requisitos para mejorar el servicio.
 * Spring, a su vez, aporta funcionalidad extra dependiendo de la interfaz que se implemente.
 * Esta incluye paginación y ordenación, se trata de una clase hija de CrudRepository.
 * También hace un uso básico de HATEOAS.
 * 
 * @author nr_alberto
 *
 */
@Repository
public interface EmpleadoRRHHRepository extends PagingAndSortingRepository<EmpleadoRRHH, Integer>{


	public EmpleadoRRHH findById(int id);
	public void deleteById(int id);

}