package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Visite;
import com.example.demo.service.VisiteService;

@RestController
@RequestMapping("/api")
public class VisiteController {

    @Autowired
    private VisiteService visiteService;

    @GetMapping("/visites")
    public ResponseEntity<Iterable<Visite>> getVisites() {
        Iterable<Visite> visites = visiteService.getVisites();
        return ResponseEntity.ok(visites);
    }

    @GetMapping("/visite/{id}")
    public ResponseEntity<Visite> getVisite(@PathVariable("id") Long id) {
        Optional<Visite> visite = visiteService.getVisite(id);
        return visite.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/saveVisite")
    public ResponseEntity<Visite> saveVisite(@RequestBody Visite visite) {
        Visite savedVisite = visiteService.saveVisite(visite);
        return ResponseEntity.ok(savedVisite);
    }
    
    @DeleteMapping("/deleteVisite/{id}")
    public ResponseEntity<Void> deleteVisite(@PathVariable("id") Long id) {
        visiteService.deleteVisite(id);
        return ResponseEntity.noContent().build();
    }

    // Gestion des erreurs globale
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
    
}
