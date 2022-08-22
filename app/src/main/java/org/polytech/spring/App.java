
package org.polytech.spring;

import org.polytech.spring.patient.Patient;
import org.polytech.spring.patient.PatientService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {


    public static void main(String[] args) {

        //Initialisation d'un context spring basé sur une configuration par xml
        try ( ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml")) { 
            //Récupération d'une instance de PatientService
            PatientService patientService = ctx.getBean(PatientService.class);
            
        
            Patient aPatient = new Patient("Jean", "Dupont", "jean.dupont@mail.com");
            patientService.savePatient(aPatient);
        } 


    }
}
