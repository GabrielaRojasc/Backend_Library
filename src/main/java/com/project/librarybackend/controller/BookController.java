package com.project.librarybackend.controller;

import com.project.librarybackend.models.Book;
import com.project.librarybackend.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("book")
public class BookController {

    /**
     *Inyección de dependencia de la clase BookServices para acceder a sus métodos
     */
    @Autowired
    private BookServices bookServices;

    /** Endpoint para obtener todos los libros
     * @return una lista de todos los libros
     */
    @GetMapping("all")
    public List<Book> getAllBook(){
        return bookServices.getAllBook();
    }

    /**
     * Endpoint para obtener todos los libros por rango de fecha.
     * @param start año de inicio del rango.
     * @param end año final del rango.
     * @return Lista de libros que cumplen con el rango de fecha.
     */
    @GetMapping("all/{start}/{end}")
    public List<Book> getAllBooksByDate(@PathVariable ("start") int start,@PathVariable("end") int end){
        return bookServices.getAllBooksByDates(start, end);
    }

    /**
     * Endpoint para obtener un libro por su ISBN.
     * @param isbn El ISBN del libro a obtener.
     * @return Un objeto Optional que contiene el libro si existe, o un valor vacío si no existe.
     */
    @GetMapping("{isbn}")
    public Optional<Book> getBook (@PathVariable ("isbn") int isbn){
        return bookServices.getBook(isbn);
    }

    /**
     *Endopint que recibe una solicitud POST para insertar un nuevo libro en la base de datos.
     * @param book el libro que se desea insertar en la base de datos.
     * @return el libro insertado en la base de datos,la respuesta HTTP que se enviará de
     * vuelta al cliente tendrá el estado 201 Created.
     */
    @PostMapping("insert")
    @ResponseStatus(HttpStatus.CREATED)
    public Book insertBook (@RequestBody Book book){
        return bookServices.insertBook(book);
    }

    /**
     *Endpoint que recibe una solicitud PUT para actualizar un libro
     * por existente en la basede datos.
     * @param book el libro a actualizar.
     * @return el libro actualizado,la respuesta HTTP que se enviará de vuelta
     * al cliente tendrá el estado 201 Created.
     */
    @PutMapping("update")
    @ResponseStatus(HttpStatus.CREATED)
    public Book updateBokk(@RequestBody Book book){
        return bookServices.updateBook(book);
    }

    /**
     *Endpoint que permite eliminar un libro existente en la base de datos
     * @param isbn el ISBN del libro a eliminar
     * @return true si se ha eliminado correctamente,tendrá un código de estado
     * HTTP 204 (No Content) para indicar que se ha eliminado correctamente la editorial.
     * false si no se ha encontrado el libro con ese isbn
     */
    @DeleteMapping("delete/{isbn}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteBook(@PathVariable("isbn") int isbn){
        return bookServices.deleteBook(isbn);
    }

}
