package org.polytech.spring.services;

import java.time.LocalDate;
import java.util.List;

import org.polytech.spring.patient.Doctor;
import org.polytech.spring.patient.DoctorNotFoundException;
import org.polytech.spring.patient.Patient;
import org.polytech.spring.patient.PatientNotFoundException;
import org.polytech.spring.repository.DoctorRepository;
import org.polytech.spring.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@Scope("singleton")
public class DoctorService {
    
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientService patientService;

    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    public void archivePatientOfDoctor(Integer doctorId, Integer patientId) throws DoctorNotFoundException, PatientNotFoundException {
    
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(DoctorNotFoundException::new);
        Patient patient = patientService.findOneById(patientId);

        doctor.getPatients().remove(patient);
        doctorRepository.save(doctor);
    }

}
