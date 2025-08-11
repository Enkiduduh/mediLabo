package com.mediLabo.microservicePatient.controller;

import com.mediLabo.microservicePatient.model.Patient;
import com.mediLabo.microservicePatient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Patient save(@RequestBody Patient patient) {
        patientService.save(patient);
        return patient;
    }

    @PutMapping("/person")
    public Patient update(@RequestBody Patient updatedPatient) {
        patientService.update(updatedPatient);
        return updatedPatient;
    }


}
