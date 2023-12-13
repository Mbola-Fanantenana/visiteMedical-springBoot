package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Visite;
import com.example.demo.model.Medecin;
import com.example.demo.model.Patient;
import com.example.demo.repository.VisiteRepository;
import com.example.demo.repository.MedecinRepository;
import com.example.demo.repository.PatientRepository;
import lombok.Data;

@Data
@Service
public class VisiteService {
    
    @Autowired
    private VisiteRepository visiteRepository;

    @Autowired
    private MedecinRepository medecinRepository;

    @Autowired 
    private PatientRepository patientRepository;

    public Optional<Visite> getVisite(final Long id) {
        return visiteRepository.findById(id);
    }

    public Iterable<Visite> getVisites() {
        return visiteRepository.findAll();
    }

    public void deleteVisite(final Long id) {
        visiteRepository.deleteById(id);
    }

    public Visite saveVisite(Visite visite) {
        // Récupérer le médecin par ID
        Medecin medecin = medecinRepository.findById(visite.getMedecin().getId()).orElse(null);

        // Récupérer le patient par ID
        Patient patient = patientRepository.findById(visite.getPatient().getId()).orElse(null);

        if (medecin != null && patient != null) {
            visite.setMedecin(medecin);
            visite.setPatient(patient);

            return visiteRepository.save(visite);
        } else {
            return null;
        }
    
    }
}
