package com.pm.Patient_management.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("prescription")
public class PrescriptioniController {

    @GetMapping("/patient/{patientId}")
        private ResponseEntity<Object> getPrescriptionsByPatientId(@PathVariable Long patientId){
            return ResponseEntity.ok().body("Get mapping for find prescription by patient id : " + patientId);
    }

    @GetMapping("/{prescriptionId}")
    private ResponseEntity<Object> getPrescriptionById(@PathVariable Long prescriptionId){
        return ResponseEntity.ok().body("Get mapping for find prescription by id" + prescriptionId);
    }

}
