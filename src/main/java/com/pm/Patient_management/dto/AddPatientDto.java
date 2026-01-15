package com.pm.Patient_management.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class AddPatientDto {
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
}
