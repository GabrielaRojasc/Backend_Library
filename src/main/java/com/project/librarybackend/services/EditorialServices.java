package com.project.librarybackend.services;

import com.project.librarybackend.models.Editorial;
import com.project.librarybackend.repositories.EditorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EditorialServices {

    /**
     *Repositorio de Editorial utilizado para acceder a la base de datos
     */
    @Autowired
    private EditorialRepository editorialRepository;

    /**
     *Método que se encarga de obtener todas las editoriales de la base de datos
     * @return la lista de las editoriales
     */
    public List<Editorial> getAllEditorial(){
        return editorialRepository.getAll();
    }

    /**
     * Método que se encarga de obtener una editorial en específico de la base de datos
     * @param id_editorial código de la editorial a obtener
     * @return editorial en caso de que exista la base de datos, o Optional vacío
     * si no encuentra
     */
    public Optional<Editorial> getEditorial(int id_editorial){
        return editorialRepository.getEditorial(id_editorial);
    }

    /**
     * Inserta una nueva editorial en la base de datos
     * @param editorial El objeto editorial que se desea insertar en la base de datos
     * @return El objeto editorial que se ha insertado en la base de datos. si no se ha podido insertar, se
     * retorna el objeto original sin cambios.
     */
    public Editorial insertEditorial(Editorial editorial){
        //Se valida que el id_editorial esté vacio, ya que se crea por autoincremental
        //Necesito que esté vacio para guardar
        if(editorial.getIdEditorial() == null){
            //Se valida que la editorial tenga un nombre y un país para poder se guardado en la base de datos
            if(editorial.getNameEditorial() != null && editorial.getCountryEditorial() != null){
                // Se guarda la editorial en la base de datos
                return editorialRepository.save(editorial);
            } else
                //Si la editorial no tiene nombre o país, no se puede guardar la editorial
                return editorial;
        } else
            //Si el id_editorial no está vacio, no se puede guardar en la base de datos
            return editorial;
    }

    /**
     * Actualiza una editorial en la base de datos con la información proporcionada en el
     * objeto editorial
     * @param editorial la información de la editorial que se desea guardar en la base de datos
     * @return El objeto editorial actualizado que se ha guardado en la base de datos, si no se ha podido guardar,
     * se retorna el objeto original sin cambios.
     */
    public Editorial updateEditorial(Editorial editorial){
        if(editorial.getIdEditorial() != null){
            Optional<Editorial> temp = editorialRepository.getEditorial(editorial.getIdEditorial());
                if(!temp.isEmpty()){
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

    /**
     * Eliminar la editorial con el código especificado de la base de datos
     * @param id_editorial El código de la editorial que se desea borrar
     * @return true, si se pudo borrar la editorial, false en caso contrario
     */
    public Boolean deleteEditorial(int id_editorial){
        Boolean success = editorialRepository.getEditorial(id_editorial).map(editorial -> {
            editorialRepository.delete(editorial);
            return true;
        }).orElse(false);
        return success;
    }
}
