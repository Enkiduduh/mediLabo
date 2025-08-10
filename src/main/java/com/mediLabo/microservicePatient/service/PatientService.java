package com.mediLabo.microservicePatient.service;

import com.mediLabo.microservicePatient.model.Patient;
import com.mediLabo.microservicePatient.repository.PatientRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

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

    public void update(Patient updatedPatient) {
        List<Patient> patients = getAllPatients();

        Optional<Patient> existingPatientOpt = patients.stream()
                .filter(p -> p.getPrenom().equalsIgnoreCase(updatedPatient.getPrenom())
                        && p.getNom().equalsIgnoreCase(updatedPatient.getNom()))
                .findFirst();

        if (existingPatientOpt.isPresent()) {
            Patient existingPerson = existingPatientOpt.get();
            existingPerson.setNom(updatedPatient.getNom());
            existingPerson.setPrenom(updatedPatient.getPrenom());
            existingPerson.setDateNaissance(updatedPatient.getDateNaissance());
            existingPerson.setGenre(updatedPatient.getGenre());
            existingPerson.setAdresse(updatedPatient.getAdresse());
            existingPerson.setTelephone(updatedPatient.getTelephone());
            patientRepository.save(existingPerson);
        }  else {
            throw new RuntimeException("Patient non trouvée avec le prénom " + updatedPatient.getPrenom()
                    + " et le nom " + updatedPatient.getNom());
        }
    }

    public void delete(Integer id) {
        Patient deleted = patientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid patient Id:" + id));
        patientRepository.delete(deleted);
    }
}

