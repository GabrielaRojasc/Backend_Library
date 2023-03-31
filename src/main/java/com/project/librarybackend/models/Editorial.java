package com.project.librarybackend.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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


    //================ Getters and Setters =================== //

    /**Retorna el id Editorial único; no tiene setter porque no se
     * puede modificar.
     * @return el id del Editorial
     */
    public Integer getIdEditorial() {
        return idEditorial;
    }

    /**
     *Retorna el nombre de la editorial
     * @return el nombre de la editorial
     */
    public String getNameEditorial() {
        return nameEditorial;
    }

    /**
     *Modifica el nombre de la editorial
     * @param nameEditorial el nuevo nombre de la editorial
     */
    public void setNameEditorial(String nameEditorial) {
        this.nameEditorial = nameEditorial;
    }

    /**
     *Retorna el país de la editorial
     * @return el país de la editorial
     */
    public String getCountryEditorial() {
        return countryEditorial;
    }

    /**
     *Modifica el país de la editorial
     * @param countryEditorial el nuevo nombre del país de la editorial
     */
    public void setCountryEditorial(String countryEditorial) {
        this.countryEditorial = countryEditorial;
    }
}

