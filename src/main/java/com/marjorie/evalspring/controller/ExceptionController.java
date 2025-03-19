package com.marjorie.evalspring.controller;

import com.marjorie.evalspring.exception.NoProduitFoundException;
import com.marjorie.evalspring.exception.ProduitNotFoundException;
import com.marjorie.evalspring.exception.SaveProduitExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(ProduitNotFoundException.class)
    public ResponseEntity<Map<String, String>> produitNotFound(ProduitNotFoundException produitNotFound) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("Erreur", produitNotFound.getMessage());
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(errorResponse);
    }

    @ExceptionHandler(NoProduitFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String noProduits(NoProduitFoundException noProduitFound) {
        return noProduitFound.getMessage();
    }


    @ExceptionHandler(SaveProduitExistException.class)
    public ResponseEntity<Map<String, String>> saveLivreExist(SaveProduitExistException saveLivreExistException) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("Erreur", saveLivreExistException.getMessage());
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(errorResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(error -> errors.put(error.getField(), error.getDefaultMessage())
                );

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
