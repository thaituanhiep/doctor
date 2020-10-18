package com.example.doctor.service;

import com.example.doctor.entity.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorService {
    List<Doctor> getAll();

    Optional<Doctor> findDoctorByDoctorCode(String doctorCode);
}
