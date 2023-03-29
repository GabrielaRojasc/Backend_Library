package com.project.librarybackend.controller;

import com.project.librarybackend.models.Author;
import com.project.librarybackend.services.AuthorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("author")
public class AuthorController {

    /**
     * Inyección de dependencia de la clase AuthorServices para acceder a sus métodos
     */
    @Autowired
    private AuthorServices authorServices;

    /**
     *Endpoint para obtener todos los authores
     * @return una lista de todos los authores
     */
    @GetMapping("all")
    public List<Author> getAllAuthor(){
        return authorServices.getAllAuthor();
    }

    /**
     *Endpoint que permite obtener la información de un author específico indetificado
     * por su código
     * @param code el código del author a obtener
     * @return un Optional que contiene el author correspondiente al código proporcionado, si existe.
     *Si no existe un author con ese código, el Optional estará vacío.
     */
    @GetMapping("{code}")
    public Optional<Author> getAuthor(@PathVariable("code") int code) {
        return authorServices.getAuthor(code);
    }

    /**
     *Endopint que recibe una solicitud POST para insertar un nuevo author en la base de datos.
     *@param author el author que se desea insertar en la base de datos.
     *@return el author insertado en la base de datos,la respuesta HTTP que se enviará de
     *vuelta al cliente tendrá el estado 201 Created.
     */
    @PostMapping("insert")
    @ResponseStatus(HttpStatus.CREATED)
    public Author insertAuthor (@RequestBody Author author){
        return authorServices.insertAuthor(author);
    }

    /**
     *Endpoint que recibe una solicitud PUT para actualizar un author
     * por existente en la basede datos.
     * @param author El author a actualizar.
     * @return el author actualizada,la respuesta HTTP que se enviará de vuelta
     * al cliente tendrá el estado 201 Created.
     */
    @PutMapping("update")
    @ResponseStatus(HttpStatus.CREATED)
    public Author updateAuthor(@RequestBody Author author){
        return authorServices.updateAuthor(author);
    }

    /**
     *Endpoint que permite eliminar un author existente en la base de datos
     * @param code el código del author a eliminar
     * @return true si se ha eliminado correctamente,tendrá un código de estado
     * HTTP 204 (No Content) para indicar que se ha eliminado correctamente el author.
     * false si no se ha encontrado el author con ese código
     */
    @DeleteMapping("delete/{code}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteAuthor(@PathVariable("code") int code){
        return authorServices.deleteAuthor(code);
    }
}
