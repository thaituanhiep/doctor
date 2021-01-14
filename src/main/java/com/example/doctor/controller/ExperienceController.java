package com.example.doctor.controller;

import com.example.doctor.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/exper")
public class ExperienceController {

    @Autowired
    private ExperienceService experienceService;

    @GetMapping(value = "/doctor/{doctorCode}")
    public ResponseEntity<?> findExperByDoctorCode(@PathVariable String doctorCode) {
        return ResponseEntity.ok(experienceService.findByDoctorCode(doctorCode));
    }
}
