package com.pm.Patient_management.controller;

import com.pm.Patient_management.dto.ApiResponse;
import com.pm.Patient_management.dto.appointment.AppointmentDto;
import com.pm.Patient_management.service.AppointmentService;
import com.pm.Patient_management.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("appointment")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @GetMapping("/{id}")
    private ResponseEntity<ApiResponse<AppointmentDto>>getAppointmentById(@PathVariable Long id){

        try{
            AppointmentDto appointment = appointmentService.getAppointmentById(id);
            return ResponseEntity.ok(new ApiResponse<>(
                    true,
                    "Appointment successfully fetched",
                    appointment
            ));
        }
        catch ( IllegalArgumentException exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body( new  ApiResponse<>(
                    false,
                    "Appointment not found",
                    null
            ));
        }


    }

}
