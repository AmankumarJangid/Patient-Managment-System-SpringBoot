package com.pm.Patient_management.dto.appointment;

import com.pm.Patient_management.entity.Doctor;
import com.pm.Patient_management.entity.Patient;
import com.pm.Patient_management.entity.enums.AppointmentStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDto {
    @Id
    Long id;

    @NotNull(message = "Patient ID is required")
    private Long patientId;

    @NotNull(message = "Doctor ID is required")
    private Long doctorId;

    @NotNull(message = "Appointment date is required")
    private LocalDate date;

    @NotNull(message = "Appointment time is required")
    private LocalTime time;

    @NotNull(message = "Appointment status is required")
    private AppointmentStatus appointmentStatus;

    private String reason;

    private String notes;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
