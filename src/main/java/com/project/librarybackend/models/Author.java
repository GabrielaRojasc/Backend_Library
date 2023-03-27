package com.project.librarybackend.models;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;


import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.annotation.Id;

@Entity
@Table (name="author")
public class Author implements Serializable {

    //Attributes
    @Id
    private Integer code;
    private String name;
    private String lastName;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;

    /**
     * Constructor of the class
     * @param code
     * @param name
     * @param lastName
     */
    public Author(Integer code, String name, String lastName){
        this.code       = code;
        this.name       = name;
        this.lastName   = lastName;
    }

    //================ Getters and Setters =================== //

    /**
     *
     * @return
     */
    public Integer getCode() {
        return code;
    }

    /**
     *
     * @param code
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */

    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}


