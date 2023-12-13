package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Visite;

@Repository
public interface VisiteRepository extends CrudRepository<Visite, Long> {
    
}
