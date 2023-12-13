package com.example.demo.model;

import java.util.List;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "patient")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "visites"})
public class Patient {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String codePat;

    @Column(name="nom_pat")
    private String nomPat;

    @Column(name="prenom_pat")
    private String prenomPat;

    @Column(name="sexe_pat")
    private String sexePat;

    @Column(name="adresse_pat")
    private String adressePat;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Visite> visites;
}
