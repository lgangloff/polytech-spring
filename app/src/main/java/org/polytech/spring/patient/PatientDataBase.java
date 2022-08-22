package org.polytech.spring.patient;

public class PatientDataBase implements PatientStore{
    public void persist(Patient aPatient) {
        System.out.println(String.format("PatientDataBase - Insertion de %s %s en BDD", aPatient.getFirstName(), aPatient.getLastName()));
    }
    
    public void init(){
        System.out.println(String.format("PatientDataBase - init"));
    }

    public void cleanup(){
        System.out.println(String.format("PatientDataBase - cleanup"));
    }

}
