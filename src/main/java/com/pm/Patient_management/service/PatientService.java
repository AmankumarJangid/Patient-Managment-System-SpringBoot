package com.pm.Patient_management.service;

import com.pm.Patient_management.dto.patient.AddPatientDto;
import com.pm.Patient_management.dto.patient.PatientDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface PatientService {

    public List<PatientDto> getAllPatients();

    PatientDto getPatientById(Long id);

    List<PatientDto> getPatientByQuery(String firstName, String lastName, String city, String email, String contact);

    PatientDto createNewPatient(AddPatientDto addPatientDto);

    PatientDto deletePatientById(Long id);

    Object updatePatient(Long id, AddPatientDto addPatientDto);

    Object updatePatientPartially(Long id, Map<String, Object> updates);

    List<PatientDto> getPatientByName(String name);
}
