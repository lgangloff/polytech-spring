package org.polytech.spring.patient;

public class PatientSerialization implements PatientStore{
    public void persist(Patient aPatient) {
        System.out.println(String.format("PatientSerialization - Serialization de %s %s", aPatient.getFirstName(), aPatient.getLastName()));
    }
}
