
package org.polytech.spring;

import org.polytech.spring.patient.Patient;
import org.polytech.spring.patient.PatientService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class App {


    public static void main(String[] args) {

        //Initialisation d'un context spring basé sur une configuration par annotation
        try (AbstractApplicationContext ctx = 
            new AnnotationConfigApplicationContext(AppConfig.class)) {
                        
            //Récupération d'une instance de PatientService
            PatientService patientService = ctx.getBean(PatientService.class);
            
        
            Patient aPatient = new Patient("Jean", "Dupont", "jean.dupont@mail.com");
            patientService.savePatient(aPatient);

            PatientService patientService2 = ctx.getBean(PatientService.class);
        }
    }
}
