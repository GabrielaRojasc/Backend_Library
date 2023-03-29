package com.project.librarybackend.repositories;

import com.project.librarybackend.models.Editorial;
import org.springframework.data.repository.CrudRepository;

/**
 *Interfaz para acceder a la base de datos y realizar operaciones CRUD sobre la entidad Editorial
 */
public interface EditorialCRUDRepository extends CrudRepository<Editorial, Integer>{

}
