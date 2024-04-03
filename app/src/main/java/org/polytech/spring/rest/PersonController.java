package org.polytech.spring.rest;

import java.util.List;
import org.polytech.spring.patient.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@RestController
public class PersonController {
    
    @Autowired
    private EntityManager em;
        

    @GetMapping(path = "/persons")
    public List<Person> getAll(){
        TypedQuery<Person> query = em.createQuery("select p from Person p", Person.class);
        return query.getResultList();
    }

}
