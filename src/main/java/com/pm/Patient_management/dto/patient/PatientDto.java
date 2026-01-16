package com.pm.Patient_management.dto.patient;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.pm.Patient_management.entity.enums.Gender;
import com.pm.Patient_management.entity.enums.PatientStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {
    @NotBlank
    private Long id;

    @NotBlank(message = "First name must be entered")
    private String firstName;

    @NotBlank(message = "Last name must be entered")
    private String lastName;

    @NotBlank(message = "Please enter your contact")
    private String contact;

    @Email(message = "Enter a valid email")
    private String email;

    @NotBlank(message = "City can't be empty")
    private String city;

    @NotBlank(message = "State can't be empty")
    private String state;

    private String address;

    @NotNull(message = "Date of birth is required")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;

    private Gender gender;

    private PatientStatus patientStatus;

    private String bloodGroup;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;
}
