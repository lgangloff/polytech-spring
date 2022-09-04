package org.polytech.spring.patient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
public class PatientService {
    
    private static Map<Integer, Patient> DATA = new HashMap<>();
    static{
        DATA.put(1, new Patient("Jean", "Dupont", "jean.dupont@mail.fr"));
        DATA.put(2, new Patient("Sophia", "Ran", "sophia.ran@mail.fr"));
        DATA.put(3, new Patient("Wendi", "Blake", "wendi.blake@mail.fr"));
    }
    public List<Patient> findAll() {
        return new ArrayList<>(DATA.values());
    }
}
