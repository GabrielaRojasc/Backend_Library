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
     *Retorna el conjunto de lista de todas las editoriales que hay
     * @return el conjunto de lista de todas las editoriales que hay
     */
    public List<Editorial> getAll(){
        return (List<Editorial>) editorialCRUDRepository.findAll();
    }

    /**
     *Establece de manera opcional para buscar un id de editorial en
     * específfico
     * @param id_editorial establece el id de editorial específico
     * @return retorna el id editorial en específico
     */
    public Optional<Editorial> getEditorial(int id_editorial){
        return editorialCRUDRepository.findById(id_editorial);
    }

    /**
     *Guarda una nueva editorial o actualiza la editorial
     * @param editorial Se establece una editorial de tipo editorial
     * @return  retorna la editorial nueva o actualizada
     */
    public Editorial save(Editorial editorial){
        return editorialCRUDRepository.save(editorial);
    }

    /**
     *Elimina la editorial
     * @param editorial se establece la editorial
     */
    public void delete(Editorial editorial){
        editorialCRUDRepository.delete(editorial);
    }
}
