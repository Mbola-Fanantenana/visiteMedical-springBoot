package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Medecin;
import com.example.demo.service.MedecinService;

@RestController
@RequestMapping("/api")
public class MedecinController {
    
    @Autowired
    private MedecinService medecinService;

    @GetMapping("/medecins")
    public ResponseEntity<Iterable<Medecin>> getMedecins() {
        Iterable<Medecin> medecins = medecinService.getMedecins(); 
        return ResponseEntity.ok(medecins);
    }

    @GetMapping("/medecin/{id}")
    public ResponseEntity<Medecin> getMedecin(@PathVariable("id") Long id) {
        Optional<Medecin> medecin = medecinService.getMedecin(id);
        return medecin.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/saveMedecin")
    public ResponseEntity<Medecin> saveMedecin(@RequestBody Medecin medecin) {
        Medecin savedMedecin = medecinService.saveMedecin(medecin);
        return ResponseEntity.ok(savedMedecin);
    }

    @DeleteMapping("/deleteMedecin/{id}")
    public ResponseEntity<Void> deleteMedecin(@PathVariable("id") Long id) {
        medecinService.deleteMedecin(id);
        return ResponseEntity.noContent().build();
    }

    // Gestion des erreurs globale
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
}
