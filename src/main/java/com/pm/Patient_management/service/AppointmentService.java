package com.pm.Patient_management.service;

import com.pm.Patient_management.dto.appointment.AppointmentDto;
import org.springframework.stereotype.Service;

@Service
public interface AppointmentService {
    AppointmentDto getAppointmentById(Long id);
}
