package com.project.librarybackend.services;

import com.project.librarybackend.models.Editorial;
import com.project.librarybackend.repositories.EditorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EditorialServices {

    @Autowired
    private EditorialRepository editorialRepository;

    public List<Editorial> getAll(){
        return editorialRepository.getAll();
    }

    public Optional<Editorial> getEditorial(int id){
        return editorialRepository.getEditorial(id);
    }

    public Editorial save(){

    }

    public Editorial update(){

    }

    public void delete(){

    }
}
