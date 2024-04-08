package org.polytech.spring.services;

import java.util.Optional;

import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditEntity;
import org.polytech.spring.patient.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;

@Service
public class PatientHistoryService {

    @Autowired
    private EntityManager em;

    public Optional<Patient> findOneByIdAndRevision(Integer id, Integer rev) {
        return Optional.ofNullable((Patient) AuditReaderFactory.get(em).createQuery()
        .forEntitiesAtRevision(Patient.class, rev)
        .add(AuditEntity.id().eq(id))
        .getSingleResult());
    }

}
