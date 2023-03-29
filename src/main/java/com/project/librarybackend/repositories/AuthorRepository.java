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
     *Retorna todos los authores en un conjunto de lista
     * @return la lista de todos los libros
     */
    public List<Author> getAll(){
        return (List<Author>) authorCRUDRepository.findAll();
    }

    /**
     *Establece de manera opcional para buscar por un código de author
     * en específico
     * @param code establece el código por el cual se va a buscar
     * @return retorna el código del author específico
     */
    public Optional<Author> getAuthor(int code){
        return authorCRUDRepository.findById(code);
    }

    /**
     *Guarda un nuevo author o actualiza el author
     * @param author Se establece el author de tipo author
     * @return retorna el author nuevo o actualizado
     */
    public Author save(Author author){
        return authorCRUDRepository.save(author);
    }

    /**
     *Elimina el author
     * @param author se establece el author
     */
    public void delete(Author author){
        authorCRUDRepository.delete(author);
    }





}
