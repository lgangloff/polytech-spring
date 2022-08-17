package org.polytech.spring.patient;

public class PatientDataBase implements PatientStore{
    public void persist(Patient aPatient) {
        System.out.println(String.format("PatientDataBase - Insertion de %s %s en BDD", aPatient.getFirstName(), aPatient.getLastName()));
    }
}
