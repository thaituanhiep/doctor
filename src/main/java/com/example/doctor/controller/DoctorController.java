package com.example.doctor.controller;

import com.example.doctor.dto.SearchDTO;
import com.example.doctor.service.DoctorService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping(value = "/all")
    public ResponseEntity<?> getAllDoctors() {
        return ResponseEntity.ok(doctorService.getAll());
    }

    @GetMapping(value = "/id/{doctorCode}")
    public ResponseEntity<?> findByDoctorCode(@PathVariable(required = false) String doctorCode) {
        if (doctorCode == null) {
            return ResponseEntity.noContent().build();
        } else return ResponseEntity.ok(doctorService.findByDoctorCode(doctorCode));
    }

    @PostMapping(value = "/search")
    public ResponseEntity<?> searchDoctor(@RequestBody String searchObj) {
        Gson gson = new Gson();
        SearchDTO searchDTO = gson.fromJson(searchObj, SearchDTO.class);
        return ResponseEntity.ok(doctorService.searchDoctor(searchDTO));
    }
}
