package com.project.librarybackend.repositories;

import com.project.librarybackend.models.Editorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EditorialRepository {
    @Autowired
    private EditorialCRUDRepository editorialCRUDRepository;

    /**
     *
     * @return
     */
    public List<Editorial> getAll(){
        return (List<Editorial>) editorialCRUDRepository.findAll();
    }

    /**
     *
     * @param id
     * @return
     */
    public Optional<Editorial> getEditorial(int id_editorial){
        return editorialCRUDRepository.findById(id_editorial);
    }

    /**
     *
     * @param editorial
     * @return
     */
    public Editorial save(Editorial editorial){
        return editorialCRUDRepository.save(editorial);
    }

    /**
     *
     * @param editorial
     */
    public void delete(Editorial editorial){
        editorialCRUDRepository.delete(editorial);
    }
}
