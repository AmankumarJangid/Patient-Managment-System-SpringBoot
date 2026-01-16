package com.pm.Patient_management.service.implementation;

import com.pm.Patient_management.dto.appointment.AppointmentDto;
import com.pm.Patient_management.entity.Appointment;
import com.pm.Patient_management.repository.AppointmentRepository;
import com.pm.Patient_management.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final ModelMapper modelMapper;

    @Override
    public AppointmentDto getAppointmentById(Long id) {
        Appointment appointment = appointmentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Could not find the appointment with id " + id.toString()));

        return modelMapper.map(appointment, AppointmentDto.class);
    }
}
