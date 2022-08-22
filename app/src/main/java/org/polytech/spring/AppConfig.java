package org.polytech.spring;

import org.polytech.spring.patient.PatientDataBase;
import org.polytech.spring.patient.PatientService;
import org.polytech.spring.patient.PatientStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public PatientStore store(){
        return new PatientDataBase();
    }
    
    @Bean
    public PatientService patientService(PatientStore store){
        return new PatientService(store);
    }
}
