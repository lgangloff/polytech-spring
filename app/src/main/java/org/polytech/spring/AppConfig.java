package org.polytech.spring;

import org.polytech.spring.patient.PatientDataBase;
import org.polytech.spring.patient.PatientSerialization;
import org.polytech.spring.patient.PatientService;
import org.polytech.spring.patient.PatientStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {

    @Bean
    @Primary
    public PatientStore databaseStore(){
        return new PatientDataBase();
    }
    @Bean
    public PatientStore serializeStore(){
        return new PatientSerialization();
    }
    
    @Bean
    public PatientService patientService(){
        return new PatientService();
    }
}
