package com.voiture.v1.entity;

import lombok.Data;

import com.voiture.v1.enums.StatutVoiture;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Voiture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idVoiture;

    @Column(unique = true)
    private String marque;

    @Column(unique = true)
    private String modele;

    @Column(unique = true)
    private String annee;

    @Column(unique = true)
    private String prixVoiture;

    @Column(unique = true)
    private String couleur;

    @Column(unique = true)
    private String immatriculation;

    @Enumerated(EnumType.STRING)
    private StatutVoiture statut;

    private int kilometrage;
    private String photoDevant;
    private String photoArriere;
    private Date datefineAssurance;
    private Date datefinusage;
    private Float prixLocation;

    @OneToMany(mappedBy = "voiture", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Maintenance> maintenances = new ArrayList<>();

    @OneToMany(mappedBy = "voiture",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Lesinfraction> lesinfraction  =new ArrayList<>();

    @OneToMany(mappedBy = "voiture",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ContratLocation> Contratlocation =new ArrayList<>();

    @OneToMany(mappedBy = "voiture",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> Reservation =new ArrayList<>();


}
