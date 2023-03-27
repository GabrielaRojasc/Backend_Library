package com.project.librarybackend.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Entity
@Table( name = "editorial")
public class Editorial implements Serializable {
    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEditorial;
    private String nameEditorial;
    private String countryEditorial;

    @OneToMany (cascade ={CascadeType.PERSIST}, mappedBy = "editorial_fk")
    @JsonIgnoreProperties("editorial_fk")
    private List<Book> books;



    /**
     * Constructor of the class
     *
     * @param idEditorial
     * @param nameEditorial
     * @param countryEditorial
     */
    public Editorial(Integer idEditorial, String nameEditorial, String countryEditorial) {
        this.idEditorial         = idEditorial;
        this.nameEditorial       = nameEditorial;
        this.countryEditorial    = countryEditorial;
    }

    //================ Getters and Setters =================== //

    /**
     *
     * @return
     */
    public Integer getIdEditorial() {
        return idEditorial;
    }

    /**
     *
     * @return
     */
    public String getNameEditorial() {
        return nameEditorial;
    }

    /**
     *
     * @param nameEditorial
     */
    public void setNameEditorial(String nameEditorial) {
        this.nameEditorial = nameEditorial;
    }

    /**
     *
     * @return
     */
    public String getCountryEditorial() {
        return countryEditorial;
    }

    /**
     *
     * @param countryEditorial
     */
    public void setCountryEditorial(String countryEditorial) {
        this.countryEditorial = countryEditorial;
    }
}

