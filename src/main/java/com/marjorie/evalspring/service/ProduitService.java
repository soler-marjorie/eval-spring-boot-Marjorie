package com.marjorie.evalspring.service;

import com.marjorie.evalspring.exception.NoProduitFoundException;
import com.marjorie.evalspring.exception.SaveProduitExistException;
import com.marjorie.evalspring.model.Produit;
import com.marjorie.evalspring.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    //Méthode qui retourne tous les objets produit
    public Iterable<Produit> getAll(){
        if(produitRepository.count() == 0) {
            throw new NoProduitFoundException();
        }
        return produitRepository.findAll();
    }

    //Méthode qui retourne un produit par son id
    public Optional<Produit> getById(Long id){
        return produitRepository.findById(id);
    }

    //Méthode qui ajoute un produit
    public Produit add(Produit produit){
        if(produitRepository.findByNom(produit.getNom()).isPresent()) {
            throw  new SaveProduitExistException(produit);
        }
        return produitRepository.save(produit);
    }
}
