package com.project.librarybackend.repositories;

import com.project.librarybackend.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookRepository {
    @Autowired
    private BookCRUDRepository bookCRUDRepository;

    /**
     *Retorna todos los libros en un conjunto de lista
     * @return la lista de todos los libros
     */
    public List<Book> getAll() {
        return (List<Book>) bookCRUDRepository.findAll();
    }

    /**
     *Establece por filtro las fechas de publicación dentro de un rango inicio
     * y un final
     * @param startYear establece la fecha de publicación por un inicio
     * @param endYear establece la fecha de publicación por un final
     * @return la lista de los libros dentro de los años especificados
     */
    public List<Book> getBooksByDate(int startYear, int endYear){
        return (List<Book>) bookCRUDRepository.findBooksByDate(startYear, endYear);
    }
    /**
     *Establece de manera opcional para buscar por un isbn en específico
     * @param isbn establece el parámetro por el cual se va a buscar
     * @return retorna el isbn especificado
     */
    public Optional<Book> getBook(int isbn){
        return bookCRUDRepository.findById(isbn);
    }

    /**
     *Guarda un nuevo libro o actualiza el libro
     * @param book Se establece un libro a guardar
     * @return  retorna el libro nuevo o actualizado
     */
    public Book save(Book book){
        return bookCRUDRepository.save(book);
    }

    /**
     *Elimina el libro
     * @param book se establece el libro a eliminar
     */
    public void delete(Book book) {
        bookCRUDRepository.delete(book);
    }
}
