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

    //getAll
    public List<Book> getAllBook(){
        return bookRepository.getAll();
    }

    //get por fecha, como ya hicimos el query en el crud, aquí solo se llama

    public List<Book> getAllBooksByDates(int start, int end){
        return bookRepository.getByDates(start, end);
    }

    //get por id
    public Optional<Book> getBook(int isbn){
        return bookRepository.getBook(isbn);
    }

    //insert
    public Book insertBook (Book book){
        if(book.getIsbn() != null){ //ingresar un isb distinto de vacio
        Optional<Book> temp = bookRepository.getBook(book.getIsbn()); // que ese isbn no exista en la base de datos
        if(!temp.isEmpty()){ // si no está vacio, prosigue
            if(book.getTitle()!= null && book.getRegisterDate() != null){
                return bookRepository.save(book);
            }else
                return book;
        } else
            return book;
        } else
            return book;
    }

    //update
    public Book updateBook (Book book){
        if(book.getIsbn()!= null){
            Optional<Book> temp = bookRepository.getBook(book.getIsbn());
            if(!temp.isEmpty()){
                if(book.getYear()!= null)
                    temp.get().setYear(book.getYear());
                if(book.getAuthors()!= null)
                    temp.get().setAuthors(book.getAuthors());
                return bookRepository.save(temp.get());
            }else
                return book;
        }else
            return book;
    }

    //delete
    public Boolean deleteBook(int isbn){
        Boolean success = bookRepository.getBook(isbn).map(book -> {
            bookRepository.delete(book);
            return true;
        }) .orElse(false);
        return success;
    }
}