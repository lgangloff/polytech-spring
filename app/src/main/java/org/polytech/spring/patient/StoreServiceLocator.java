package org.polytech.spring.patient;

public class StoreServiceLocator {
    public static PatientStore getPatientStore(){
        return new PatientDataBase();
    }
}
