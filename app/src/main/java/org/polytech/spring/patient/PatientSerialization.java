package org.polytech.spring.patient;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class PatientSerialization implements PatientStore{
    public void persist(Patient aPatient) {
        System.out.println(String.format("PatientSerialization - Serialization de %s %s", aPatient.getFirstName(), aPatient.getLastName()));
    }
}
