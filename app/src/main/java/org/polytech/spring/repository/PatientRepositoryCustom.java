package org.polytech.spring.repository;

import java.util.List;

import org.polytech.spring.patient.Patient;

public interface PatientRepositoryCustom {

    public List<Patient> findPatientsWithDoctorInCity(String city);
    public List<Patient> withCriteraAPIfindPatientsWithDoctorInCity(String city);
}
