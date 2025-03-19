package com.marjorie.evalspring.repository;

import com.marjorie.evalspring.model.Produit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProduitRepository extends CrudRepository<Produit, Long> {
    Optional<Produit> findByNom(String nom);
}
