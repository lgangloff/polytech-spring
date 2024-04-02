package org.polytech.spring.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.polytech.spring.patient.Patient;
import org.polytech.spring.patient.PatientNotFoundException;
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
public class PatientController {
    
    @Autowired
    private PatientService patientService;
        

    @GetMapping(path = "/patients")
    public List<Patient> getAllByName(
        @RequestParam(name = "name", required = false) String name){
        return Optional.ofNullable(name)
            .map(patientService::findAllByNameLike)
            .orElseGet(patientService::findAll);
    }

    @PostMapping(path = "/patients")
    public ResponseEntity<Patient> createPatient(
        @RequestBody Patient patient,  
        UriComponentsBuilder uriBuilder){

        Patient savedPatient = patientService.save(patient);

        URI uri = uriBuilder.path("/patient/{id}").buildAndExpand(patient.getId()).toUri();
        return ResponseEntity.created(uri).body(savedPatient);
    }
    
    
    @GetMapping(path = "/patient/{id}")
    public Patient getOnePatient(
        @PathVariable Integer id) throws PatientNotFoundException{
        return patientService.findOneById(id);
    }

    @PutMapping(path = "/patient/{id}")
    public void updatePatient(
        @PathVariable Integer id,
        @RequestBody Patient patient) throws PatientNotFoundException{
        patientService.update(id, patient);
    }

    @DeleteMapping(path = "/patient/{id}")
    public void deletePatient(
        @PathVariable Integer id) throws PatientNotFoundException{
        patientService.delete(id);
    }
}
