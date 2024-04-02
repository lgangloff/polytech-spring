package org.polytech.spring.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.polytech.spring.patient.Doctor;
import org.polytech.spring.patient.DoctorNotFoundException;
import org.polytech.spring.patient.Patient;
import org.polytech.spring.patient.PatientNotFoundException;
import org.polytech.spring.services.DoctorService;
import org.polytech.spring.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class DoctorController {
    
    @Autowired
    private DoctorService doctorService;
        

    @GetMapping(path = "/doctors")
    public List<Doctor> getAll(){
        return doctorService.findAll();
    }

    @DeleteMapping(path = "/doctor/{docId}/patient/{pId}")
    public void archivePatient(
        @PathVariable("docId") Integer doctorId,
        @PathVariable("pId") Integer patientId) throws PatientNotFoundException, DoctorNotFoundException{
        
            doctorService.archivePatientOfDoctor(doctorId, patientId);
    }
}
