package com.project.librarybackend.controller;

import com.project.librarybackend.models.Editorial;
import com.project.librarybackend.services.EditorialServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("editorial")
public class EditorialController {

    /**
     *Inyección de dependencia de la clase EditorialServices para acceder a sus métodos
     */
    @Autowired
    private EditorialServices editorialServices;

    /** Endpoint para obtener todas las editoriales
     * @return una lista de todas las editoriales
     */
    @GetMapping("all")
    public List<Editorial> getAllEditorial(){
        return editorialServices.getAllEditorial();
    }

    /**
     *Endpoint que permite obtener la información de una editorial específica identificada
     * por su ID.
     * @param id_editorial el ID de la editorial a obtener.
     * @return un Optional que contiene la editorial correspondiente al ID proporcionado, si existe.
     * Si no existe una editorial con ese ID, el Optional estará vacío.
     */
    @GetMapping("{id_editorial}")
    public Optional<Editorial> getEditorial(@PathVariable ("id_editorial") int id_editorial){
        return editorialServices.getEditorial(id_editorial);
    }

    /**
     *Endopint que recibe una solicitud POST para insertar una nueva Editorial en la base de datos.
     * @param editorial la editorial que se desea insertar en la base de datos.
     * @return la editorial insertada en la base de datos,la respuesta HTTP que se enviará de
     * vuelta al cliente tendrá el estado 201 Created.
     */
    @PostMapping("insert")
    @ResponseStatus(HttpStatus.CREATED)
    public Editorial insertEditorial(@RequestBody Editorial editorial){
        return editorialServices.insertEditorial(editorial);
    }

    /**
     *Endpoint que recibe una solicitud PUT para actualizar una editorial
     * por existente en la basede datos.
     * @param editorial La editorial a actualizar.
     * @return La editorial actualizada,la respuesta HTTP que se enviará de vuelta
     * al cliente tendrá el estado 201 Created.
     */
    @PutMapping("update")
    @ResponseStatus(HttpStatus.CREATED)
    public Editorial updateEditorial (@RequestBody Editorial editorial){
        return editorialServices.updateEditorial(editorial);
    }

    /**
     *Endpoint que permite eliminar una editorial existente en la base de datos
     * @param id_editorial el id de la editorial a eliminar
     * @return true si se ha eliminado correctamente,tendrá un código de estado
     * HTTP 204 (No Content) para indicar que se ha eliminado correctamente la editorial.
     * false si no se ha encontrado la editorial con ese id
     */
    @DeleteMapping("delete/{id_editorial}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean deleteEditorial (@PathVariable ("id_editorial")int id_editorial){
        return editorialServices.deleteEditorial(id_editorial);
    }

}
