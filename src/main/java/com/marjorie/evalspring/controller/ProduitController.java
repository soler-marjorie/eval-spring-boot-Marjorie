package com.marjorie.evalspring.controller;

import com.marjorie.evalspring.exception.ProduitNotFoundException;
import com.marjorie.evalspring.model.Produit;
import com.marjorie.evalspring.service.CategorieService;
import com.marjorie.evalspring.service.ProduitService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    @Autowired
    private CategorieService categorieService;

    //retourne un JSON en GET avec tous les produits (categorie incluse), code statut 200
    @GetMapping("/produit")
    public Iterable<Produit> getAllProduits() {
        return produitService.getAll();
    }

    //retourne un JSON en GET avec le produit et sa categorie par son id, code statut 200
    @GetMapping("/produit/{id}")
    public Produit getProduit(@PathVariable Long id) {
        return produitService.getById(id).orElseThrow(
                () -> new ProduitNotFoundException(id)
        );
    }

    // Méthode qui ajoute un produit
    @PostMapping("/produit/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Produit saveProduit(@Valid @RequestBody Produit produit) {
        return produitService.add(produit);
    }


}
