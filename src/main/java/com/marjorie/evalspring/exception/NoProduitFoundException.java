package com.marjorie.evalspring.exception;

public class NoProduitFoundException extends RuntimeException {
    public NoProduitFoundException() {
        super("Aucun produits dans la base de donnée");
    }
}
