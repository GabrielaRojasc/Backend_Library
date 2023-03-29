package com.project.librarybackend.repositories;

import com.project.librarybackend.models.Author;
import org.springframework.data.repository.CrudRepository;

/**
 *Interfaz para acceder a la base de datos y realizar operaciones CRUD sobre la entidad Author
 */
public interface AuthorCRUDRepository extends CrudRepository <Author, Integer> {
}
