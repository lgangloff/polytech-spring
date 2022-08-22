package org.polytech.spring.patient;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class PatientDataBase implements PatientStore{
    public void persist(Patient aPatient) {
        System.out.println(String.format("PatientDataBase - Insertion de %s %s en BDD", aPatient.getFirstName(), aPatient.getLastName()));
    }

    @PostConstruct
    public void init(){
        System.out.println("PatientDataBase - init");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("PatientDataBase - destroy");
    }
}
