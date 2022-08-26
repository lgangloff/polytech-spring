package org.polytech.spring;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditStoreAspect {
    
    @Pointcut("execution(public * *..PatientStore.persist(..))") // the pointcut expression
    public void patientStorePersitMethod(){ // the pointcut signature
    }

    @Before("patientStorePersitMethod()") //advice
    public void auditStoreMethod(JoinPoint joinPoint){
        
        String methodArgsAsString = Stream.of(joinPoint.getArgs())
            .map(Object::toString).collect(Collectors.joining(","));

        System.out.println(String.format("Appel de la methode %s | arguments: %s", 
            joinPoint.toShortString(), methodArgsAsString));
    }
}
