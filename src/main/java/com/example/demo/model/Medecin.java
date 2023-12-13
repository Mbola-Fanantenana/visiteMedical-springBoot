package com.example.demo.model;

import java.util.List;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "medecin")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "visites"})
public class Medecin {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String codeMed;

    @Column(name="nom_med")
    private String nomMed;

    @Column(name="prenom_med")
    private String prenomMed;

    @Column(name="grade_med")
    private String gradeMed;

    @OneToMany(mappedBy = "medecin", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Visite> visites;

}
