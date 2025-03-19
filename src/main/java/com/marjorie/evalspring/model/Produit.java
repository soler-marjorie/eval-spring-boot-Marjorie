package com.marjorie.evalspring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "produit")
public class Produit {

    /*
     * ATTRIBUTS
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom", nullable = false, length = 50)
    @NotBlank(message = "Le nom du produit ne doit pas être vide")
    @Size(min = 2, max = 50, message = "La description du produit doit contenir entre 5 et 50 caractères")
    private String nom;

    @Column(name = "prix", nullable = false)
    @NotNull(message = "Le prix du produit ne doit pas être vide")
    @DecimalMin(value = "0.0", inclusive = false, message = "Le rix du produit ne doit pas être vide et supèrieur à zéro")
    private Double price;

    /*
     * CONSTRUCTORS
     */

    public Produit() {}

    public Produit(String nom, Double price) {
        this.nom = nom;
        this.price = price;
    }

    /*
     * GETTERS AND SETTERS
     */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    /*
     * METHODS
     */
    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", price=" + price +
                '}';
    }
}
