package com.pm.Patient_management.repository;

import com.pm.Patient_management.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByFirstName(String firstName);
    List<Patient> findByLastName(String lastName);
    List<Patient> findByCity(String city);
    List<Patient> findByFirstNameStartingWithIgnoreCase(String firstName);


    @Query("""
            SELECT p from  Patient p
            WHERE (:firstName = '' OR LOWER(p.firstName) LIKE LOWER(CONCAT(:firstName, '%')))
            AND (:lastName = '' OR LOWER(p.lastName) LIKE LOWER(CONCAT(:lastName, '%')))
            AND (:city = '' OR LOWER(p.city) LIKE LOWER(CONCAT(:city, '%')))
            AND (:email = '' OR LOWER(p.email) LIKE LOWER(CONCAT(:email, '%')))
            AND (:contact = '' OR LOWER(p.contact) LIKE LOWER(CONCAT(:contact, '%')))
            """)
    List<Patient> getSearchQueries(
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("city") String city,
            @Param("email") String email,
            @Param("contact") String contact
    );
}
