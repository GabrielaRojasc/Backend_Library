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



    public Book (Integer isbn, String title, String registerDate, Integer year, Editorial editorial_fk){
        this.isbn           = isbn;
        this.title          = title;
        this.registerDate   = registerDate;
        this.year           = year;
        this.editorial_fk   = editorial_fk;
    }

    //================ Getters and Setters =================== //
    public Integer getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }
}
