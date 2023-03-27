package com.project.librarybackend.services;

import com.project.librarybackend.models.Book;
import com.project.librarybackend.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServices {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAll(){
        return bookRepository.getAll();
    }

    public Optional<Book> getBook(int isbn){
        return bookRepository.getBook(isbn);
    }

    public Book save(){

    }

    public Book update(){

    }

    public void delete(){

    }
}
