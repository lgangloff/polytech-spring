package org.polytech.spring.rest;

import java.util.List;

import org.polytech.spring.patient.Patient;
import org.polytech.spring.patient.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {
    
    @Autowired
    private PatientService patientService;

    @GetMapping(path = "/patients")
    public List<Patient> getAll(){
        return patientService.findAll();
    }
}
