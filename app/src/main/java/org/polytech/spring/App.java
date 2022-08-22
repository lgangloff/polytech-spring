
package org.polytech.spring;

import org.polytech.spring.patient.Patient;
import org.polytech.spring.patient.PatientService;
import org.polytech.spring.patient.PatientStore;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {


    public static void main(String[] args) {

        //Initialisation d'un context spring basé sur une configuration par xml
        try ( ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml")) { 
                          
            System.out.println("PatientService: " + ctx.getBean(PatientService.class));
            System.out.println("PatientService: " + ctx.getBean(PatientService.class));
            System.out.println("PatientStore: " + ctx.getBean(PatientStore.class));
            System.out.println("PatientStore: " + ctx.getBean(PatientStore.class));
        } 


    }
}
