package com.microservicePatient.microservicePatient.service;

import com.microservicePatient.microservicePatient.model.Patient;
import com.microservicePatient.microservicePatient.repository.PatientRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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

    public void update(Integer id, @Valid Patient updatedPatient) {
        Patient existingPatient = patientRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "patient non trouvé"));

        existingPatient.setNom(updatedPatient.getNom());
        existingPatient.setPrenom(updatedPatient.getPrenom());
        existingPatient.setDateNaissance(updatedPatient.getDateNaissance());
        existingPatient.setGenre(updatedPatient.getGenre());
        existingPatient.setAdresse(updatedPatient.getAdresse());
        existingPatient.setTelephone(updatedPatient.getTelephone());
        patientRepository.save(existingPatient);
    }

    public void delete(Integer id) {
        Patient deleted = patientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid patient Id:" + id));
        patientRepository.delete(deleted);
    }

}


