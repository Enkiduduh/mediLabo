package com.mediLabo.microservicePatient.controller;

import com.mediLabo.microservicePatient.model.Patient;
import com.mediLabo.microservicePatient.service.PatientService;
import jakarta.persistence.NamedStoredProcedureQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {
   @Autowired
   PatientService patientService;

//   @RequestMapping("/patient/list")
//    public String home() {
//
//   }
}
