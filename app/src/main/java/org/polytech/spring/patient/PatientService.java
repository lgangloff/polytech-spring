package org.polytech.spring.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class PatientService {
    
    @Autowired(required = true)
    @Qualifier("serializeStore")
    private PatientStore store;

    public void savePatient(Patient aPatient){
        System.out.println(String.format("PatientService - Validation du patient %s", aPatient.getEmail()));
        store.persist(aPatient);
    }
}
