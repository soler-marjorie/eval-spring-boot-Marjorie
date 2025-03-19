package com.marjorie.evalspring.controller;

import com.marjorie.evalspring.model.Categorie;
import com.marjorie.evalspring.service.CategorieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CategorieController {

    @Autowired
    private CategorieService categorieService;

    // Méthode qui ajoute un produit
    @PostMapping("/categorie/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Categorie saveCategorie(@Valid @RequestBody Categorie categorie) {
        return categorieService.add(categorie);
    }
}
