package org.polytech.spring.services;

import java.time.LocalDate;
import java.util.List;

import org.polytech.spring.patient.Patient;
import org.polytech.spring.patient.PatientNotFoundException;
import org.polytech.spring.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@Scope("singleton")
public class PatientService {
    
    @Autowired
    private PatientRepository patientRepository;

    public Patient save(Patient patient){
        return patientRepository.save(patient);
    }

    public Patient update(Integer id, Patient updatedPatient) throws PatientNotFoundException{
        return patientRepository.save(updatedPatient);
    }

    public void delete(Integer id) throws PatientNotFoundException{
        patientRepository.deleteById(id);
    }

    public Patient findOneById(Integer id) throws PatientNotFoundException {
        return patientRepository.findById(id).orElseThrow(PatientNotFoundException::new);
    }
    
    public List<Patient> findAllByNameLike(String name) {
        return findAll().stream()
            .filter(p->StringUtils.startsWithIgnoreCase(p.getFirstName(), name))
            .toList();
    }

    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

}
