package com.pm.Patient_management.repository;

import com.pm.Patient_management.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
