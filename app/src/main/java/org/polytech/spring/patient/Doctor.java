package org.polytech.spring.patient;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ManyToAny;

@Entity
public class Doctor {
    @Id
    @Column(name="id_doctor")
    private Integer id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_address", 
        foreignKey = @ForeignKey(name = "doctor_id_address_fk"), nullable = false)
    private Address address;
    
    @ManyToMany(cascade = {}, fetch = FetchType.LAZY)
    @JoinTable(name = "doctor_patients", 
        joinColumns =        {@JoinColumn(name="id_doctor", foreignKey = @ForeignKey(name="doctor_patients_id_doctor_fk"))}, 
        inverseJoinColumns = {@JoinColumn(name="id_patient",foreignKey = @ForeignKey(name="doctor_patients_id_patient_fk"))})
    private List<Patient> patients;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    
}
