package com.project.librarybackend.services;

import com.project.librarybackend.models.Author;
import com.project.librarybackend.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServices {

    /**
     * Repositorio de Author utilizado para acceder a la base de datos
     */
    @Autowired
    private AuthorRepository authorRepository;


    /**
     *Método que se encarga de obtener todos los authores de la base de datos
     * @return la lista de los authores
     */
    public List<Author> getAllAuthor(){
        return authorRepository.getAll();
    }

    /**
     * Método que se encarga de obtener un author en específico de la base de datos
     * @param code código del author a obtener
     * @return author en caso de que exista la base de datos, o Optional vacío
     * si no encuentra
     */
    public Optional<Author> getAuthor(int code){
        return authorRepository.getAuthor(code);
    }

    /**
     * Inserta un nuevo Author en la base de datos
     * @param author El objeto Author que se desea insertar en la base de datos
     * @return El objeto Author que se ha insertado en la base de datos. si no se ha podido insertar, se
     * retorna el objeto original sin cambios.
     */
    public Author insertAuthor (Author author){
        //Se valida que el author tenga un código no nulo para poder ser guardado en la base de datos
        //no puedo crear un author sin código, porque no lo creamos con autoincremental
        if(author.getCode() !=null){
            //Se verifica que el código del author no exista ya en la base de datos
            Optional<Author> temp = authorRepository.getAuthor(author.getCode());
            //Si el código no existe en la base de datos, se guarda el author
            if(temp.isEmpty()){
                //Se valida que el author tenga un nombre y un apellido para poder se guardado en la base de datos
                if(author.getName() !=null && author.getLastName() !=null){
                    // Se guarda el author en la base de datos
                    return authorRepository.save(author);
                } else
                    // Si el author no tiene nombre o apellido, no se puede guardar en la base de datos
                    return author;
            } else
                //Si el código ya existe en la base de datos, no se puede guardar el author
                return author;
        } else
            //Si el author no tiene código, no se puede guardar en la base de datos
            return author;
    }

    /**
     * Actualiza un Author en la base de datos con la información proporcionada en el
     * objeto Author
     * @param author la información del author que se desea guardar en la base de datos
     * @return El objeto Author actualizado que se ha guardado en la base de datos, si no se ha podido guardar,
     * se retorna el objeto original sin cambios.
     */
    public Author updateAuthor(Author author){
        // Se valida que el author tenga un código no nulo para poder ser actualizado en la base de datos
        if(author.getCode()!= null){
            //Se busca el author en la base de datos por su código
            Optional<Author> temp = authorRepository.getAuthor(author.getCode());
            //Si el author existe en la base de datos, se actualiza
            if(!temp.isEmpty()){
                //Si el author tiene un nombre, se actualiza el nombre en la base de datos
                //Se valida que la casilla no esté vacia para no guardar un vacio
                if(author.getName()!=null)
                    temp.get().setName(author.getName());
                //Si el author tiene un apellido, se actualiza el apellido en la base de datos
                //Se valida que la casilla no esté vacia para no guardar un vacio
                if(author.getLastName()!=null)
                    temp.get().setLastName(author.getLastName());
                //Se guarda el author actualizado en la base de datos
                return authorRepository.save(temp.get());
            }else
                //Si el author no existe en la base de datos, no se puede actualizar
                return author;
        }else
            //Si el author no tiene el código, no se puede actualizar en la base de datos
            return author;
    }

    /**
     * Eliminar el author con el código especificado de la base de datos
     * @param code El código del author que se desea borrar
     * @return true, si se pudo borrar el author, false en caso contrario
     */
    public Boolean deleteAuthor(int code){
        //Se busca el author en la base de datos y se transforma con map
        Boolean success = authorRepository.getAuthor(code).map(author -> {
            //Si encuentra el author, se elimina de la base de datos
            authorRepository.delete(author);
            //retorna true para indicar que se ha eliminado correctamente
            return true;
            //Si no encuentra el author, se retorna false
        }) .orElse(false);
        //Retorna el booleano de acuerdo al map anterior
        return success;
    }
}
