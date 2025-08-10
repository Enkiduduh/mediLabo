package com.mediLabo.microservicePatient.service;

import com.mediLabo.microservicePatient.model.Patient;
import com.mediLabo.microservicePatient.repository.PatientRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient findById(Integer id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid patient Id:" + id));
    }

    public void save(@Valid Patient patient) {
        patientRepository.save(patient);
    }

    public void update(Integer id, Patient data) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid patient Id:" + id));
        patient.setNom(data.getNom());
        patient.setPrenom(data.getPrenom());
        patient.setDateDeNaissance(data.getDateDeNaissance());
        patient.setGenre(data.getGenre());
        patient.setAdresse(data.getAdresse());
        patient.setTelephone(data.getTelephone());
        patientRepository.save(patient);
    }

    public void delete(Integer id) {
        Patient deleted = patientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid patient Id:" + id));
        patientRepository.delete(deleted);
    }
}

