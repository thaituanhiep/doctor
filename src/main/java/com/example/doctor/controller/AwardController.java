package com.example.doctor.controller;

import com.example.doctor.service.AwardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/award")
public class AwardController {

    @Autowired
    private AwardService awardService;

    @GetMapping(value = "/doctor/{doctorCode}")
    public ResponseEntity<?> findAwardsByDoctorCode(@PathVariable String doctorCode) {
        return ResponseEntity.ok(awardService.findByDoctorCode(doctorCode));
    }
}
