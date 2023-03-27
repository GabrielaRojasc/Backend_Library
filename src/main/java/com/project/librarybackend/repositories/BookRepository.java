package com.project.librarybackend.repositories;

import com.project.librarybackend.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public class BookRepository {
    @Autowired
    private BookCRUDRepository bookCRUDRepository;

    /**
     *
     * @return
     */
    public List<Book> getAll(){
        return (List<Book>) bookCRUDRepository.findAll();
    }

    /**
     *
     * @param startYear
     * @param endYear
     * @return
     */
    public List<Book> getByDates(String startYear, String endYear){
        return (List<Book>) bookCRUDRepository.findBooksByDates(startYear, endYear);
    }
    /**
     *
     * @param isbn
     * @return
     */
    public Optional<Book> getBook(int isbn){
        return bookCRUDRepository.findById(isbn);
    }

    /**
     *
     * @param book
     * @return
     */
    public Book save(Book book){
        return bookCRUDRepository.save(book);
    }

    /**
     *
     * @param book
     * @return
     */
    public Book delete(Book book){
        return bookCRUDRepository.delete(book);
    }
}
