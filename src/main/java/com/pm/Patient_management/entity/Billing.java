package com.pm.Patient_management.entity;

import com.pm.Patient_management.entity.enums.BillingMethod;
import com.pm.Patient_management.entity.enums.BillingStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Billing {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal total_amount;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal payed_amount;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal due_amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BillingStatus billingStatus;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BillingMethod billingMethod;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;


}
