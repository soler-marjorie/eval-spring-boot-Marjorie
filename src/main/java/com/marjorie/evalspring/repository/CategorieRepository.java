package com.marjorie.evalspring.repository;

import com.marjorie.evalspring.model.Categorie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategorieRepository extends CrudRepository<Categorie, Long> {
    Optional<Categorie> findByLibele(String libele);
}
