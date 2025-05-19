package com.voiture.v1.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data

public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long idClient;

    @Column(unique=true)
    private String nom;

    @Column(unique = true)
    private String prenom;

    @Column(unique = true)
    private String cin;
    @Column(unique = true)
    private String numPermis;
    @Column(unique = true)
    private String photoPermis;

    private String adresse;
    private String telephone;
    private String email;

    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Lesinfraction> Lesinfraction = new ArrayList<>();

    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<ContratLocation> Contartlocation = new ArrayList<>();

    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Reservation> Reservation = new ArrayList<>();
}
