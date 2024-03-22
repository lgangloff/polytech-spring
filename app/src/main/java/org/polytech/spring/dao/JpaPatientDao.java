package org.polytech.spring.dao;

import java.util.List;
import java.util.Optional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import org.polytech.spring.patient.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JpaPatientDao implements Dao<Patient> {

    @Autowired
    private EntityManager em;
    @Override
    public Optional<Patient> get(long id) {
        return Optional.ofNullable(em.find(Patient.class, id));
    }

    @Override
    public List<Patient> getAll() {
        TypedQuery<Patient> query = em.createQuery(
            "SELECT p FROM Patient p JOIN FETCH p.address", 
            Patient.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void save(Patient p) {
        em.persist(p);
    }

    @Override
    @Transactional
    public void update(Patient p) {
        em.merge(p);
    }

    @Override
    @Transactional
    public void delete(Patient p) {
        em.remove(p);
    }
    
}
