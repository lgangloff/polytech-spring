package org.polytech.spring.patient;

import java.util.Set;

import org.hibernate.annotations.SoftDelete;
import org.hibernate.envers.Audited;
import org.hibernate.type.NumericBooleanConverter;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
@Audited
public class Doctor extends Person {
    
    @ManyToMany(cascade = {}, fetch = FetchType.LAZY)
    @SoftDelete(columnName = "archived", converter = NumericBooleanConverter.class)
    @JoinTable(name = "doctor_patients", 
        joinColumns =        {@JoinColumn(name="id_person_doctor", foreignKey = @ForeignKey(name="doctor_patients_id_person_doctor_fk"))}, 
        inverseJoinColumns = {@JoinColumn(name="id_person_patient", foreignKey = @ForeignKey(name="doctor_patients_id_person_patient_fk"))})
    private Set<Patient> patients;

    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Doctor other = (Doctor) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    
    
}
