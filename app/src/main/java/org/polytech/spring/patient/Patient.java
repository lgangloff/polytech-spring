package org.polytech.spring.patient;

import java.time.LocalDate;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SoftDelete;
import org.hibernate.envers.Audited;
import org.hibernate.type.YesNoConverter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Audited
@NamedQuery(
    name = "patientsWithPreferredDoctorInCity",
    query = "select p from Patient p join fetch p.address " +
            "where p.preferredDoctor.address.city like :city"
)
@SoftDelete(columnName = "removed", converter = YesNoConverter.class)
public class Patient extends Person {
    
    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(name = "mail", length = 320, nullable = false)
    private String email;
    
    @JsonIgnoreProperties("hibernateLazyInitializer")
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "preferred_id_person_doctor", 
        foreignKey = @ForeignKey(name = "patient_preferred_id_person_doctor_fk"), nullable = false)
    private Doctor preferredDoctor;

    
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_on")
	@CreationTimestamp
	private Date createdOn;
    
    public Patient(){
        super();
    }
    
    public Patient(Integer id, String firstName, String lastName, String email) {
        super(id, firstName, lastName);
        this.email = email;
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

    public Doctor getPreferredDoctor() {
        return preferredDoctor;
    }

    public void setPreferredDoctor(Doctor preferredDoctor) {
        this.preferredDoctor = preferredDoctor;
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
        Patient other = (Patient) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    
}
