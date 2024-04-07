package org.polytech.spring.repository;

import java.time.LocalDate;
import java.util.List;

import org.polytech.spring.patient.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository 
    extends JpaRepository<Patient, Integer>, PatientRepositoryCustom{
    List<Patient> findByfirstNameOrLastNameOrderByBirthDateDesc(String firstName, String lastName);
    List<Patient> findTop3ByFirstNameStartingWithIgnoringCase(String firstName);
    Long countByLastName(String lastName);
    List<Patient> searchByBirthDateBefore(LocalDate birthDate);

    @Query("select p from Patient p join fetch p.address")
    List<Patient> findAllWithAddress();
}
