package com.marjorie.evalspring.exception;

import com.marjorie.evalspring.model.Categorie;
import com.marjorie.evalspring.model.Produit;

public class SaveCategorieExistException extends RuntimeException {
    public SaveCategorieExistException(Categorie categorie) {
        super("Le libele categorie : " + categorie.getLibele() + "existe déjà.");
    }
}
