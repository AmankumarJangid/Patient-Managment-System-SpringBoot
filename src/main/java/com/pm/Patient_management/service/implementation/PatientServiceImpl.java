package com.pm.Patient_management.service.implementation;

import com.pm.Patient_management.dto.AddPatientDto;
import com.pm.Patient_management.dto.PatientDto;
import com.pm.Patient_management.entity.Patient;
import com.pm.Patient_management.repository.PatientRepository;
import com.pm.Patient_management.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<PatientDto> getAllPatients() {
        List<Patient> patients =  patientRepository.findAll();

        return patients.stream().map(patient -> modelMapper.map(patient, PatientDto.class)).toList();

    }

    @Override
    public PatientDto getPatientById(Long id) {
        Patient patient = patientRepository.findById(id).orElseThrow( ()->new IllegalArgumentException(String.format("Cant find id %d", id)));
        return modelMapper.map(patient , PatientDto.class);
    }

    @Override
    public List<PatientDto> getPatientByQuery(String firstName, String lastName, String city, String email, String contact) {
        // SQL query in Patient Repository for this
        List<Patient> patients= patientRepository.getSearchQueries(firstName, lastName, city, email, contact);
        return patients.stream().map(patient -> modelMapper.map(patient, PatientDto.class)).collect(Collectors.toList());
    }


    @Override
    public PatientDto createNewPatient(AddPatientDto addPatientDto) {
        Patient newPatient = modelMapper.map(addPatientDto, Patient.class);
        Patient patient = patientRepository.save(newPatient);
        return modelMapper.map(patient , PatientDto.class);
    }

    @Override
    public PatientDto deletePatientById(Long id) {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(String.format("Cant find id %d", id)));
        patientRepository.deleteById(id);
        return modelMapper.map(patient , PatientDto.class);
    }

    @Override
    public Object updatePatient(Long id, AddPatientDto addPatientDto) {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(String.format("Cant find id %d", id)));
        modelMapper.map(addPatientDto ,patient);

        patient = patientRepository.save(patient);
        return modelMapper.map(patient, PatientDto.class);
    }

    @Override
    public Object updatePatientPartially(Long id, Map<String, Object> updates) {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(String.format("Cant find id %d", id)));
        updates.forEach((field, value)->{
            switch (field){
                case "firstName" : patient.setFirstName((String)value); break;
                case "lastName" : patient.setLastName((String)value); break;
                case "contact" : patient.setContact((String)value); break;
                case "email" : patient.setEmail((String)value); break;
                default: throw new IllegalArgumentException("Field :" + field + " is not supported");
            }
        });

        Patient newpatient = patientRepository.save(patient);
        return modelMapper.map(newpatient, PatientDto.class);
    }

    @Override
    public List<PatientDto> getPatientByName(String name) {
        List<Patient> patients = patientRepository.findByFirstNameStartingWithIgnoreCase(name);

        return patients.stream().map( patient -> modelMapper.map(patient, PatientDto.class)).collect(Collectors.toList());
    }


}
