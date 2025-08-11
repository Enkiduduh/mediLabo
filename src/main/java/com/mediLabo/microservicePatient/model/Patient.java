package com.mediLabo.microservicePatient.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "patient", uniqueConstraints = @UniqueConstraint(
        name = "uq_patient_natural",
        columnNames = {"nom", "prenom", "date_naissance"}
))
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Integer id;

    @Column(name = "nom", nullable = false)
    @NotNull
    private String nom;

    @Column(name = "prenom", nullable = false)
    @NotNull
    private String prenom;

    @Column(name = "date_naissance", nullable = false)
    @NotNull
    private LocalDate dateNaissance;

    public enum Genre {F, M}

    @Enumerated(EnumType.STRING)
    @Column(name = "genre", nullable = false, length = 1)
    @NotNull
    private Genre genre;

    @Size(max = 200)
    @Column(name = "adresse", length = 200)
    private String adresse;

    @Column(name = "telephone", length = 30)
    private String telephone;

}

