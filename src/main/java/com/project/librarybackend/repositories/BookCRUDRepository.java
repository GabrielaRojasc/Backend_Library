package com.project.librarybackend.repositories;

import com.project.librarybackend.models.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

/**
 *
 */
public interface BookCRUDRepository extends CrudRepository <Book, Integer> {

    @Query(values = "SELECT * FROM books WHERE year >= ? AND year <= ?")
    public List<Book> findBooksByDates(String startYear, String endYear);


}

