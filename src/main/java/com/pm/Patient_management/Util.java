package com.pm.Patient_management;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/")
public class Util {
    @GetMapping("/current-time")
    private String getCurrentTime(){
        return LocalTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME);
    }
}
