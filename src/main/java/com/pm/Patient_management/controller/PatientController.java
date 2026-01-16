package com.pm.Patient_management.controller;

import com.pm.Patient_management.dto.patient.AddPatientDto;
import com.pm.Patient_management.dto.ApiResponse;
import com.pm.Patient_management.dto.patient.PatientDto;
import com.pm.Patient_management.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequiredArgsConstructor
@RequestMapping("patient")
public class PatientController {
    private final PatientService patientService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<PatientDto>>> getPatients(){
        List<PatientDto> patients = patientService.getAllPatients();
        return ResponseEntity.ok(new ApiResponse<>(
                true,
                "Patients successfully fetched",
                patients
        ));
    }

    @GetMapping("")
    public String helloToPatientManagementSystem(){
        return "<h1> Hello to my Patient Management System<h1>" +
                "<a href=\"patient/all\">Link to patients </a>";

    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<List<PatientDto>>> getPatientsByQuery(
            @RequestParam(value = "firstName", required = false, defaultValue = "") String firstName,
            @RequestParam(value = "lastName", required = false, defaultValue = "") String lastName,
            @RequestParam(value = "city", required = false, defaultValue = "") String city,
            @RequestParam(value = "email", required = false, defaultValue = "") String email,
            @RequestParam(value = "contact", required = false, defaultValue = "") String contact)
    {

        List<PatientDto> patients = patientService.getPatientByQuery(firstName, lastName, city , email, contact );
        return ResponseEntity.status(HttpStatus.OK).body( new ApiResponse<>(
                true,
                "Patients fetched Successfully",
                patients
        ));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<PatientDto>> getPatientByName( @PathVariable String name){
        return ResponseEntity.ok( patientService.getPatientByName(name));
    }



    @GetMapping("/{id}")
    public ResponseEntity<PatientDto> getPatientById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(patientService.getPatientById(id));
    }

    @PostMapping("")
    public ResponseEntity<ApiResponse<PatientDto>> createPatient(@RequestBody @Valid AddPatientDto addPatientDto){
        System.out.println(addPatientDto.getAddress());

        PatientDto saved = patientService.createNewPatient((addPatientDto));
        return ResponseEntity.status(HttpStatus.CREATED).
                body(
                        new ApiResponse<>(
                                true,
                                "Patient is successfully stored",
                                saved
                        ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePatientById(@PathVariable Long id ){

        try{
        return ResponseEntity.status(HttpStatus.OK).body(patientService.deletePatientById(id));
        }
        catch ( IllegalArgumentException e){
            return ResponseEntity.badRequest().body("message : Could not find the patient with id : " + id);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePatientDetails(@PathVariable Long id , @RequestBody @Valid AddPatientDto addPatientDto){
        try{
            return ResponseEntity.ok(patientService.updatePatient(id, addPatientDto));
        }
        catch( IllegalArgumentException e){
            return ResponseEntity.badRequest().body("message : Could not find the patient with id : " + id );
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> updatePatientPartially(@PathVariable Long id, @RequestBody Map<String , Object> updates){
        try{
            return ResponseEntity.ok(patientService.updatePatientPartially(id, updates));
        }
        catch( IllegalArgumentException e){
            return ResponseEntity.badRequest().body("message : Could not find the patient with id : " + id );
        }
    }



}
