package org.polytech.spring.repository;

import java.util.List;

import org.polytech.spring.patient.Address_;
import org.polytech.spring.patient.Doctor_;
import org.polytech.spring.patient.Patient;
import org.polytech.spring.patient.Patient_;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository
public class PatientRepositoryCustomImpl implements PatientRepositoryCustom {

    @Autowired
    private EntityManager em;

    @Override
    public List<Patient> findPatientsWithDoctorInCity(String city) {
       TypedQuery<Patient> namedQuery = em.createNamedQuery(
        "patientsWithPreferredDoctorInCity", Patient.class);
        
       namedQuery.setParameter("city", city);
       return namedQuery.getResultList();
    
    }
    
    public List<Patient> withCriteraAPIfindPatientsWithDoctorInCity(String city) {
    
        CriteriaBuilder builder = em.getCriteriaBuilder();

        CriteriaQuery<Patient> criteria = builder.createQuery(Patient.class);
        Root<Patient> root = criteria.from(Patient.class);
        criteria.select(root);
        root.fetch(Patient_.address);
        criteria.where(
            builder.like(
                root.get(Patient_.preferredDoctor).get(Doctor_.address).get(Address_.city),
                city));

        return em.createQuery(criteria).getResultList();
    }
}
