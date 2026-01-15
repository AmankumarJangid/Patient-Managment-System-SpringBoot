package com.pm.Patient_management.service;

import com.pm.Patient_management.dto.BillingDto;
import com.pm.Patient_management.entity.enums.BillingStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

public interface BillingService {

    BillingStatus setBillingStatus(BigDecimal totalAmount, BigDecimal payedAmount);
    ResponseEntity<Object> createBilling(BillingDto billingDto);
}
