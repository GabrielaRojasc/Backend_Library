package com.project.librarybackend.services;

import com.project.librarybackend.models.Book;
import com.project.librarybackend.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServices {

    /**
     * Repositorio de Book utilizado para acceder a la base de datos
     */
    @Autowired
    private BookRepository bookRepository;

    /**
     *Método que se encarga de obtener todos los libros de la base de datos
     * @return la lista de los libros
     */
    public List<Book> getAllBook(){
        return bookRepository.getAll();
    }

    /**
     * Retorna una lista de todos los libros cuyo año de publicación está dentro del rango especificado.
     * @param start El año de inicio del rango.
     * @param end El año de fin del rango.
     * @return Una lista de todos los libros que cumplen con el criterio de búsqueda.
     */
    public List<Book> getBooksByDate(int start, int end){
        return bookRepository.getBooksByDate(start, end);
    }
git
    /**
     * Método que se encarga de obtener un libro en específico de la base de datos
     * @param isbn ISBN del libro a obtener
     * @return book en caso de que exista la base de datos, o Optional vacío
     * si no encuentra
     */
    public Optional<Book> getBook(int isbn){
        return bookRepository.getBook(isbn);
    }

    /**
     * Inserta un nuevo libro en la base de datos
     * @param book EL objeto libro que se desea insertar en la base de datos
     * @return El objeto libro que se ha insertado en la base de datos. si no se ha podido insertar,
     * se retorna el objeto original sin cambios.
     */
    public Book insertBook (Book book){
        //Se valida que el libro tenga un código no nulo para poder ser guardado en la base de datos
        //no puedo crear un libro sin ISBN, porque no lo creamos con autoincremental
        if(book.getIsbn() != null){
            //Se verifica que el ISBN del libro no exista ya en la base de datos
            Optional<Book> temp = bookRepository.getBook(book.getIsbn());
            //Si el ISBN no existe en la base de datos, se guarda el libro
            if(!temp.isEmpty()){
                //Se valida que el libro tenga un título y una fecha de registro para poder se guardado
                if(book.getTitle()!= null && book.getRegisterDate() != null){
                    // Se guarda el libro en la base de datos
                    return bookRepository.save(book);
                }else
                    // Si el libro no tiene título o fecha de publicación, no se puede guardar en la base de datos
                    return book;
            } else
                //Si el ISBN ya existe en la base de datos, no se puede guardar el libro
                 return book;
        } else
            //Si el libro no tiene ISBN, no se puede guardar en la base de datos
            return book;
    }

    /**
     * Actualiza un libro en la base de datos con la información proporcionada en el
     * objeto Book
     * @param book la información del libro que se desea guardar en la base de datos
     * @return El objeto Book actualizado que se ha guardado en la base de datos, si no se ha podido guardar,
     * se retorna el objeto original sin cambios.
     */
    public Book updateBook (Book book){
        if(book.getIsbn()!= null){
            Optional<Book> temp = bookRepository.getBook(book.getIsbn());
            if(!temp.isEmpty()){
                if(book.getYear()!= null)
                    temp.get().setYear(book.getYear());
                if(book.getAuthors()!= null)
                    temp.get().setAuthors(book.getAuthors());
                return bookRepository.save(temp.get());
            }else
                return book;
        }else
            return book;
    }

    /**
     * Eliminar el libro con el ISBN especificado de la base de datos
     * @param isbn El isbn del libro que se desea borrar
     * @return true, si se pudo borrar el libro, false en caso contrario
     */
    public Boolean deleteBook(int isbn){
        Boolean success = bookRepository.getBook(isbn).map(book -> {
            bookRepository.delete(book);
            return true;
        }) .orElse(false);
        return success;
    }
}