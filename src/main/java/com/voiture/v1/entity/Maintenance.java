package com.voiture.v1.entity;


import com.voiture.v1.enums.Typemaintenance;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String date;

    @Enumerated(EnumType.STRING)
    private Typemaintenance typemaintenance;
    private String prixpay;

    @ManyToOne
    @JoinColumn(name = "voiture_id")
    private Voiture voiture;


}
