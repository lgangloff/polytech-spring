package org.polytech.spring.patient;

public class PatientService {
    
    private PatientStore store;

    public PatientService(PatientStore store) {
        this.store = store;
    }

    public void init(){
        System.out.println(String.format("PatientService - init"));
    }

    public void cleanup(){
        System.out.println(String.format("PatientService - cleanup"));
    }

    public void savePatient(Patient aPatient){
        System.out.println(String.format("PatientService - Validation du patient %s", aPatient.getEmail()));
        store.persist(aPatient);
    }
}
