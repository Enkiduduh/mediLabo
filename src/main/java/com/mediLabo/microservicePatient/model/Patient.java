package com.mediLabo.microservicePatient.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Nom", nullable = false)
    @NotNull
    private String nom;

    @Column(name = "Prénom", nullable = false)
    @NotNull
    private String prenom;

    @Column(name = "Date de Naissance", nullable = false)
    @NotNull
    private String dateDeNaissance;

    @Column(name = "Genre", nullable = false)
    @NotNull
    private String genre;

    @Column(name = "Adresse")
    private String adresse;

    @Column(name = "Téléphone")
    private String telephone;


}
