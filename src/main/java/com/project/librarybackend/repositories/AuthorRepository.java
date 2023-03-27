package com.project.librarybackend.repositories;

import com.project.librarybackend.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AuthorRepository {
    @Autowired
    private AuthorCRUDRepository authorCRUDRepository;

    /**
     *
     * @return
     */
    public List<Author> getAll(){

        return (List<Author>) authorCRUDRepository.findAll();
    }

    /**
     *
     * @param code
     * @return
     */
    public Optional<Author> getAuthor(int code){

        return authorCRUDRepository.findById(code);
    }

    /**
     *
     * @param author
     * @return
     */
    public Author save(Author author){

        return authorCRUDRepository.save(author);
    }

    /**
     *
     * @param author
     */
    public void delete(Author author){

        return authorCRUDRepository.delete(author);
    }





}
