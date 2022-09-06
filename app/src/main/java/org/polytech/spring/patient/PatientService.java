package org.polytech.spring.patient;

import java.util.List;

import org.polytech.spring.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@Scope("singleton")
public class PatientService {
    
    @Autowired
    private Dao<Patient> patientDao;

    public Patient save(Patient patient){
        patientDao.save(patient);
        return patient;
    }

    public Patient update(Integer id, Patient updatedPatient) throws PatientNotFoundException{
        patientDao.update(updatedPatient);
        return updatedPatient;
    }

    public Patient delete(Integer id) throws PatientNotFoundException{
        return 
            patientDao.get(id)
            .map((p)->{
                patientDao.delete(p);
                return p;
            })
            .orElseThrow(PatientNotFoundException::new);
    }

    public Patient findOneById(Integer id) throws PatientNotFoundException {
        return patientDao.get(id).orElseThrow(PatientNotFoundException::new);
    }
    
    public List<Patient> findAllByNameLike(String name) {
        return findAll().stream()
            .filter(p->StringUtils.startsWithIgnoreCase(p.getFirstName(), name))
            .toList();
    }

    public List<Patient> findAll() {
        return patientDao.getAll();
    }

}
