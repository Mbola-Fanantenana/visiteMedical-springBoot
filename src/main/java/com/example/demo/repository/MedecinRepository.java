package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Medecin;

@Repository
public interface MedecinRepository extends CrudRepository<Medecin, Long> {
    
}
