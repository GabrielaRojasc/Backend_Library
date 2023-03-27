package com.project.librarybackend.repositories;

import com.project.librarybackend.models.Author;
import org.springframework.data.repository.CrudRepository;

/**
 *
 */
public interface AuthorCRUDRepository extends CrudRepository <Author, Integer> {
}
