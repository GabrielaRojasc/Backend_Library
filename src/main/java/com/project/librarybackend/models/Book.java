package com.project.librarybackend.models;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.annotation.Id;


@Entity
@Table (name = "Book") //
public class Book implements Serializable {

    //Attributes
    @Id
    private Integer isbn;
    private String title;
    private String registerDate;
    private Integer year;


    @ManyToOne
    @JoinColumn(name = "idEditorial")
    @JsonIgnoreProperties("books")
    private Editorial editorial_fk;

    @ManyToMany
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "isbn"),
            inverseJoinColumns = @JoinColumn(name = "code")
    )
    private Set<Author> authors;


    /**
     * Constructor of the class
     * @param isbn
     * @param title
     * @param registerDate
     * @param year
     * @param editorial_fk
     */
    public Book (Integer isbn, String title, String registerDate, Integer year, Editorial editorial_fk){
        this.isbn           = isbn;
        this.title          = title;
        this.registerDate   = registerDate;
        this.year           = year;
        this.editorial_fk   = editorial_fk;
    }

    //================ Getters and Setters =================== //

    /**
     * Retorna el Isbn del libro; no se puede modificar.
     * @return el isbn del libro
     */
    public Integer getIsbn() {
        return isbn;
    }

    /**
     * Retorna el título del libro
     * @return el título del libro
     */
    public String getTitle() {
        return title;
    }

    /**
     * Modifica el título del libro
     * @param title el nuevo título del libro
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Retorna la fecha de registro del libro
     * @return la fecha de registro del libro
     */
    public String getRegisterDate() {
        return registerDate;
    }

    /**
     * Modifica la fecha de registro del libro
     * @param registerDate la nueva fecha de registro del libro
     */
    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    /**
     * Retorna el conjunto de authores que tiene el libro
     * @return el conjunro de authores que tiene el libro
     */
    public Set<Author> getAuthors() {
        return authors;
    }

    /**
     * Modifica el conjunto de authores que tiene el libro
     * @param authors el nuevo conjunto de authores que tiene el libro
     */
    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    /**
     * Retorna la fecha de publicación del libro
     * @return la fecha de publicación del libro
     */
    public Integer getYear() {
        return year;
    }

    /**
     * Modifica la fecha de publicación del libro
     * @param year la nueva fecha de publicación del libro
     */
    public void setYear(Integer year) {
        this.year = year;
    }
}
