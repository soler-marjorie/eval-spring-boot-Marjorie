package com.marjorie.evalspring.exception;

public class NoCategorieFoundException extends RuntimeException {
    public NoCategorieFoundException() {
        super("Aucun libele de categorie dans la base de donnée");
    }
}
