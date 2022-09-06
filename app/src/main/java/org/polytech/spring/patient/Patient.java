package org.polytech.spring.patient;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Patient {
    
    @Id
    @Column(name="id_patient")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private LocalDate birthDate;
    @Column(name = "mail", length = 320, nullable = false)
    private String email;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_address", 
        foreignKey = @ForeignKey(name = "patient_id_address_fk"), nullable = false)
    private Address address;
    
    @OneToOne(cascade = {})
    @JoinColumn(name = "preferred_id_doctor", 
        foreignKey = @ForeignKey(name = "patient_preferred_id_doctor_fk"), nullable = true)
    private Doctor preferredDoctor;

    public Patient(){

    }
    
    public Patient(Integer id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Doctor getPreferredDoctor() {
        return preferredDoctor;
    }

    public void setPreferredDoctor(Doctor preferredDoctor) {
        this.preferredDoctor = preferredDoctor;
    }

    
}
