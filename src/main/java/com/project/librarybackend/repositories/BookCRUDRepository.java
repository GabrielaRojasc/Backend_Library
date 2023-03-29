package com.project.librarybackend.repositories;

import com.project.librarybackend.models.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

/**
 * Interfaz para acceder a la base de datos y realizar operaciones CRUD sobre la entidad libro
 */
public interface BookCRUDRepository extends CrudRepository <Book, Integer> {
    /**
     * Retorna una lista de libros cuyo año de publicación está dentro del rango
     * especificado
     * @param startYear El año de inicio del rango
     * @param endYear EL año de fin del rango
     * @return Una lista de libros que cumplen con el criterio de búsqueda
     */
    @Query(value ="SELECT * FROM books WHERE year >= ? AND year <= ?")
    public List<Book> findBooksByDates(int startYear, int endYear);


}

