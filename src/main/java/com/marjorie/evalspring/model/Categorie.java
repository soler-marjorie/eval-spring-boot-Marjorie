package com.marjorie.evalspring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "categorie")
public class Categorie {

    /*
     * ATTRIBUTS
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "libele", nullable = false, length = 50)
    @NotBlank(message = "Le libele de la categorie ne doit pas être vide")
    @Size(min = 2, max = 50, message = "Le libele de la categorie doit contenir entre 5 et 50 caractères")
    private String libele;

    /*
     * CONSTRUCTORS
     */
    public Categorie() {}

    public Categorie(String libele, Long id) {
        this.libele = libele;
        this.id = id;
    }

    /*
     * METHODS
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibele() {
        return libele;
    }

    public void setLibele(String libele) {
        this.libele = libele;
    }
}
