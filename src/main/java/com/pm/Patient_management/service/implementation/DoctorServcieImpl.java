package com.pm.Patient_management.service.implementation;

import com.pm.Patient_management.repository.DoctorRepository;
import com.pm.Patient_management.service.DoctorService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DoctorServcieImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

}
