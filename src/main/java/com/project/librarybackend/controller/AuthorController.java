package com.project.librarybackend.controller;

import com.project.librarybackend.models.Author;
import com.project.librarybackend.services.AuthorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("author")
public class AuthorController {

    @Autowired
    private AuthorServices authorServices;

    //get all
    @GetMapping("all")
    public List<Author> getAllAuthor(){
        return authorServices.getAllAuthor();
    }
    //get por id
    @GetMapping("{code}")
    public Optional<Author> getAuthor(@PathVariable("{code}") int code) {
        return authorServices.getAuthor(code);
    }

    //insertar
    @PostMapping("insert")
    public Author insertAuthor (@RequestBody Author author){
        return authorServices.insertAuthor(author);
    }

    //update
    @PutMapping("update")
    public Author updateAuthor(@RequestBody Author author){
        return authorServices.updateAuthor(author);
    }

    //delete
    @DeleteMapping("delete/{code}")
    public boolean deleteAuthor(@PathVariable("code") int code){
        return authorServices.deleteAuthor(code);
    }
}
