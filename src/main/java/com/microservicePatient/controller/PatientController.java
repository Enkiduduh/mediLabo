package com.microservicePatient.controller;

import com.microservicePatient.model.Patient;
import com.microservicePatient.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PatientController {
    @Autowired
    PatientService patientService;

    @GetMapping("/patients")
    public List<Patient> getPatients() {
        return patientService.getAllPatients();
    }

    @PostMapping("/patient")
    @ResponseStatus(HttpStatus.CREATED)
    public Patient save(@RequestBody @Valid Patient patient) {
        patientService.save(patient);
        return patient;
    }

    @GetMapping("/patients/{id}")
    public Patient profile(@PathVariable Integer id) {
        return patientService.findById(id);
    }

    @PutMapping("/patients/{id}")
    public Patient update(@PathVariable Integer id,@RequestBody Patient updatedPatient) {
        patientService.update(id, updatedPatient);
        return updatedPatient;
    }

    @DeleteMapping("/patients/{id}")
    public void delete(@PathVariable Integer id) {
        patientService.delete(id);
    }

}
