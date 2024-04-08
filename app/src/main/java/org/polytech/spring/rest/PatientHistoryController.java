package org.polytech.spring.rest;

import org.polytech.spring.patient.PatientNotFoundException;
import org.polytech.spring.services.PatientHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientHistoryController {
    
    @Autowired
    private PatientHistoryService patientHistoryService;
        

    @GetMapping(path = "/patient/{id}/history")
    public Object getOnePatient(
        @PathVariable("id") Integer id,
        @RequestParam("rev") Integer rev) throws PatientNotFoundException{
        return patientHistoryService.findOneByIdAndRevision(id, rev);
    }
}
