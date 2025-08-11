package com.microservicePatient.microservicePatient.controller;

import com.microservicePatient.microservicePatient.model.Patient;
import com.microservicePatient.microservicePatient.service.PatientService;
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

    @PostMapping("/person")
    @ResponseStatus(HttpStatus.CREATED)
    public Patient save(@RequestBody @Valid Patient patient) {
        patientService.save(patient);
        return patient;
    }

    @PutMapping("/person/{id}")
    public Patient update(@PathVariable Integer id,@RequestBody Patient updatedPatient) {
        patientService.update(id, updatedPatient);
        return updatedPatient;
    }

    @DeleteMapping("/person/{id}")
    public void delete(@PathVariable Integer id) {
        patientService.delete(id);
    }

}
