package com.marjorie.evalspring.exception;

import com.marjorie.evalspring.model.Produit;

public class SaveProduitExistException extends RuntimeException {
    public SaveProduitExistException(Produit produit) {
        super("Le produit : " + produit.getNom() + "existe déjà.");
    }
}
