package com.voiture.v1.entity;

import com.voiture.v1.enums.Role;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmployee;

    @Column(unique = true)
    private String nom;
    @Column(unique = true)
    private String prenom;
    @Column(unique = true)
    private String cin;
    @Column(unique = true)
    private String numPermis;
    private String photoPermis;
    private String adresse;
    private String telephone;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String email;
    private String password;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ContratLocation> contratLocations = new ArrayList<>();
}
