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

    //getAll con una list
    public List<Author> getAllAuthor(){
        return authorRepository.getAll();
    }

   //get por id en especifico con optional
    public Optional<Author> getAuthor(int code){
        return authorRepository.getAuthor(code);
    }

   //save, llamando insertar y validaciones
    public Author insertAuthor (Author author){ //necesitamos que el id si exista para poder guardar, no puedo crear un author sin codigo, porque no lo creamos autoincremental
        if(author.getCode() !=null){    //distinto de vacio, o sea que sí necesito id,el id de editorial no se pide porque se genera solo, a cambio aqui si lo necesitamos
            Optional<Author> temp = authorRepository.getAuthor(author.getCode());//validar que el codigo no exista en la base de datos con un optional,porque si existe este codigo, no podemos guardarlo
            if(temp.isEmpty()){  // significa que no existe en la base de datos, porque está vacio
                if(author.getName() !=null && author.getLastName() !=null){
                    return authorRepository.save(author);
                } else
                    return author;
            } else
                return author;
        } else
            return author;
    }

        //update
    public Author updateAuthor(Author author){
        if(author.getCode()!= null){ //validar que el id no está vacio
            Optional<Author> temp = authorRepository.getAuthor(author.getCode());  //validar que el id exista en la base de datos con un optional para luego llamar un empty
            if(!temp.isEmpty()){  // y decir que no esté vacio la variable temp, significa que si está vacio es porque no existe en la base de datos
                if(author.getName()!=null) //validar que las demás casillas no estén vacias para que no vaya a guardar un vacio
                    temp.get().setName(author.getName());
                if(author.getLastName()!=null)
                    temp.get().setLastName(author.getLastName());
                return authorRepository.save(temp.get());
            }else
                return author;
        }else
            return author;
    }

    //delete
    public Boolean deleteAuthor(int code){
        Boolean success = authorRepository.getAuthor(code).map(author -> {
            authorRepository.delete(author);
            return true;
        }) .orElse(false);
        return success;
    }
}
