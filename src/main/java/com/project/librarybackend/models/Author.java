package com.project.librarybackend.models;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;


@Entity
@Table(name="author")
public class Author implements Serializable {

    //Attributes
    @Id
    private Integer code;
    private String name;
    private String lastName;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;


    //================ Getters and Setters =================== //

    /**
     * Retorna el código único del author. Este valor es utilizado
     * para identificar de forma única al author dentro del sistema
     * No tiene setter porque no se puede cambiar este código.
     * @return el código único del author
     */
    public Integer getCode() {
        return code;
    }

    /**
     *Modifica el código único del author
     * @param code el nuevo código para el author
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     *Retorna el nombre del author
     * @return el nombre del author
     */
    public String getName() {
        return name;
    }

    /**
     *Modifica el nombre del author
     * @param name el nuevo nombre para el author
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *Retorna el apellido del author
     * @return el apellido del author
     */

    public String getLastName() {
        return lastName;
    }

    /**
     *Modifica el apellido del author
     * @param lastName el nuevo apellido del author
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Retorna los libros asociados al author
     * @return los libros asociados al author
     */
    public Set<Book> getBooks() {
        return books;
    }

    /**
     * Modifica los libros asociados al author
     * @param books el nuevo conjunto de libros para el author
     */
    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}


