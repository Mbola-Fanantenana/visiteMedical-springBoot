package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Medecin;
import com.example.demo.repository.MedecinRepository;
import lombok.Data;

@Data
@Service
public class MedecinService {
    
    @Autowired
    private MedecinRepository medecinRepository;

    public Optional<Medecin> getMedecin(final Long id) {
        return medecinRepository.findById(id);
    }

    public Iterable<Medecin> getMedecins() {
        return medecinRepository.findAll();
    }

    public void deleteMedecin(final Long id) {
        medecinRepository.deleteById(id);
    }

    public Medecin saveMedecin(Medecin medecin) {
        Medecin savedMedecin = medecinRepository.save(medecin);
        return savedMedecin;
    }
}
