package org.polytech.spring.patient;

public class PatientService {
    
    private PatientStore store;

    public PatientService(PatientStore store) {
        this.store = store;
    }

    void savePatient(Patient aPatient){
        store.persist(aPatient);
    }
}
