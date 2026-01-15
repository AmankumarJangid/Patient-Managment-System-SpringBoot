package com.pm.Patient_management.service.implementation;

import com.pm.Patient_management.repository.PrescriptionRepository;
import com.pm.Patient_management.service.PrescriptionService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PrescriptionServiceImpl implements PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;


}
