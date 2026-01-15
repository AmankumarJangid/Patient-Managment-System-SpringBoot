package com.pm.Patient_management.repository;

import com.pm.Patient_management.entity.Billing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BillingRepository extends JpaRepository<Billing, Long> {
}
