package com.project.librarybackend.services;

import com.project.librarybackend.models.Author;
import com.project.librarybackend.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServices {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAll(){
        return authorRepository.getAll();
    }

    public Optional<Author> getAuthor(int id){
        return authorRepository.getAuthor(id);
    }

    public Author save(){

    }

    public Author update(){

    }

    public void delete(){

    }


}
