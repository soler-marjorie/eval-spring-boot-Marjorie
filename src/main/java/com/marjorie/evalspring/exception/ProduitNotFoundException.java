package com.marjorie.evalspring.exception;

public class ProduitNotFoundException extends RuntimeException {
    public ProduitNotFoundException(Long id) {
        super("Le produit avec id : " + id + " n'existe pas");
    }
}
