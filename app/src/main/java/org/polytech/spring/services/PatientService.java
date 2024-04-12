package org.polytech.spring.services;

import java.util.List;

import org.polytech.spring.patient.Patient;
import org.polytech.spring.patient.PatientNotFoundException;
import org.polytech.spring.repository.PatientRepository;
import org.polytech.spring.security.IsCurrentPatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import jakarta.annotation.security.RolesAllowed;

@Service
@Scope("singleton")
public class PatientService {
    
    @Autowired
    private PatientRepository patientRepository;

    public Patient save(Patient patient){
        return patientRepository.save(patient);
    }
    
    
    public void delete(Integer id) throws PatientNotFoundException{
        patientRepository.deleteById(id);
    }

    @IsCurrentPatient
    public Patient findOneById(Integer id) throws PatientNotFoundException {
        return patientRepository.findById(id).orElseThrow(PatientNotFoundException::new);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public Patient update(Integer id, Patient updatedPatient) throws PatientNotFoundException{
        return patientRepository.save(updatedPatient);
    }

    @RolesAllowed("ADMIN")    
    public List<Patient> findAllByNameLike(String name) {
        return findAll().stream()
            .filter(p->StringUtils.startsWithIgnoreCase(p.getFirstName(), name))
            .toList();
    }

    public List<Patient> findAll() {
        return patientRepository.findAllWithAddress();
    }

    public List<Patient> findAllHavindDoctorInCity(String city) {
        return patientRepository.withCriteraAPIfindPatientsWithDoctorInCity(city+"%");
    }

}
