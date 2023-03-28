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

    //get all
    public List<Editorial> getAllEditorial(){
        return editorialRepository.getAll();
    }

    //get por id
    public Optional<Editorial> getEditorial(int id_editorial){
        return editorialRepository.getEditorial(id_editorial);
    }

    //insert
    public Editorial insertEditorial(Editorial editorial){
        if(editorial.getIdEditorial() == null){ // como el id editorial se crea por autoincremental, significa que se crea id solo, necesito que esté vacio para guardar
            if(editorial.getNameEditorial() != null && editorial.getCountryEditorial() != null){
                return editorialRepository.save(editorial);
            } else
                return editorial;
        } else
            return editorial;
    }

    //update
    public Editorial updateEditorial(Editorial editorial){
        if(editorial.getIdEditorial() != null){ // necesito que el id no esté vacio para poder actualizar
            Optional<Editorial> temp = editorialRepository.getEditorial(editorial.getIdEditorial());
                if(!temp.isEmpty()){ //si está vacio, no se puede actualizar
                    if(editorial.getNameEditorial() != null)
                        temp.get().setNameEditorial(editorial.getNameEditorial());
                    if(editorial.getCountryEditorial() != null)
                        temp.get().setCountryEditorial(editorial.getCountryEditorial());
                    return editorialRepository.save(temp.get());
                } else
                    return editorial;
        }else
            return editorial;
    }

    //delete
    public Boolean deleteEditorial(int id_editorial){
        Boolean success = editorialRepository.getEditorial(id_editorial).map(editorial -> {
            editorialRepository.delete(editorial);
            return true;
        }).orElse(false);
        return success;
    }
}
