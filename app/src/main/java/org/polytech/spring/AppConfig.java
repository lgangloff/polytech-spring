package org.polytech.spring;

import org.polytech.spring.patient.PatientDataBase;
import org.polytech.spring.patient.PatientService;
import org.polytech.spring.patient.PatientStore;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public PatientStore store(){
        return new PatientDataBase();
    }
    
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public PatientService patientService(PatientStore store){
        return new PatientService(store);
    }
}
