package com.marjorie.evalspring.service;

import com.marjorie.evalspring.exception.NoCategorieFoundException;
import com.marjorie.evalspring.exception.SaveCategorieExistException;
import com.marjorie.evalspring.model.Categorie;
import com.marjorie.evalspring.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategorieService {

    @Autowired
    private CategorieRepository categorieRepository;

    //Méthode qui retourne tous les objets categorie
    public Iterable<Categorie> getAll(){
        if(categorieRepository.count() == 0) {
            throw new NoCategorieFoundException();
        }
        return categorieRepository.findAll();
    }

    //Méthode qui retourne une categorie par son id
    public Optional<Categorie> getById(Long id){
        return categorieRepository.findById(id);
    }

    //Méthode qui ajoute une categorie
    public Categorie add(Categorie categorie){
        if(categorieRepository.findByLibele(categorie.getLibele()).isPresent()) {
            throw  new SaveCategorieExistException(categorie);
        }
        return categorieRepository.save(categorie);
    }
}
