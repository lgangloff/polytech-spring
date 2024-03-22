package org.polytech.spring.patient;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class PatientDataBase implements PatientStore{

    @Value("${store.db.url}")
    private String dbUrl;

    public void persist(Patient aPatient) {
        System.out.println(String.format("PatientDataBase - Insertion de %s %s en BDD (%s)", 
            aPatient.getFirstName(), aPatient.getLastName(), dbUrl));
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
