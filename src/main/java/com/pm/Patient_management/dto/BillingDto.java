package com.pm.Patient_management.dto;

import com.pm.Patient_management.entity.Patient;
import com.pm.Patient_management.entity.enums.BillingMethod;
import com.pm.Patient_management.entity.enums.BillingStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillingDto {
    @NotNull
    private BigDecimal totalAmount;

    @NotNull
    private BigDecimal payedAmount;

    @NotNull
    @Enumerated(EnumType.STRING)
    private BillingMethod billingMethod;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal total_amount;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal payed_amount;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal due_amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BillingStatus billingStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

}
