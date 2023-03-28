package com.project.librarybackend.controller;

import com.project.librarybackend.models.Book;
import com.project.librarybackend.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookServices bookServices;

    //get all
    @GetMapping("all")
    public List<Book> getAllBook(){
        return bookServices.getAllBook();
    }

    //get por fechas
    @GetMapping("bookByDate")
    public List<Book> getAllBooksByDate(@PathVariable int start, int end){
        return bookServices.getAllBooksByDates(start, end);
    }

    //get por id
    @GetMapping("{isbn}")
    public Optional<Book> getBook (@PathVariable ("{isbn}") int isbn){
        return bookServices.getBook(isbn);
    }

    //insert post
    @PostMapping("insert")
    public Book insertBook (@RequestBody Book book){
        return bookServices.insertBook(book);
    }

    //update put
    @PutMapping("update")
    public Book updateBokk(@RequestBody Book book){
        return bookServices.updateBook(book);
    }

    //delete
    @DeleteMapping("delete/{isbn}")
    public boolean deleteBook(@PathVariable int isbn){
        return bookServices.deleteBook(isbn);
    }

}
