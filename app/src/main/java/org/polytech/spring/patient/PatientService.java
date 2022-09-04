package org.polytech.spring.patient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@Scope("singleton")
public class PatientService {
    
    public Patient save(Patient patient){
        int id = findAll().stream().map(Patient::getId).max(Integer::compareTo).orElse(0) + 1;
        patient.setId(id);
        DATA.put(id, patient);
        return patient;
    }

    public Patient update(Integer id, Patient updatedPatient) throws PatientNotFoundException{
        Patient patientInMap = findOneById(id);
        patientInMap.setBirthDate(updatedPatient.getBirthDate());
        patientInMap.setEmail(updatedPatient.getEmail());
        patientInMap.setFirstName(updatedPatient.getFirstName());
        patientInMap.setLastName(updatedPatient.getLastName());
        return patientInMap;
    }

    public Patient delete(Integer id) throws PatientNotFoundException{
        Patient patientToDelete = findOneById(id);
        return DATA.remove(patientToDelete.getId());
    }

    public Patient findOneById(Integer id) throws PatientNotFoundException {
        return Optional.ofNullable(DATA.get(id)).orElseThrow(PatientNotFoundException::new);
    }
    
    public List<Patient> findAllByNameLike(String name) {
        return findAll().stream()
            .filter(p->StringUtils.startsWithIgnoreCase(p.getFirstName(), name))
            .toList();
    }

    public List<Patient> findAll() {
        return new ArrayList<>(DATA.values());
    }


    
    private static final Map<Integer, Patient> DATA = new HashMap<>();
    static{
        DATA.put(1, new Patient(1, "Jean", "Dupont", "jean.dupont@mail.fr"));
        DATA.put(2, new Patient(2, "Sophia", "Ran", "sophia.ran@mail.fr"));
        DATA.put(3, new Patient(3, "Wendi", "Blake", "wendi.blake@mail.fr"));
    }
}
