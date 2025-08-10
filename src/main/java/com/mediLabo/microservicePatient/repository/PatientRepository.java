package com.mediLabo.microservicePatient.repository;

import com.mediLabo.microservicePatient.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
