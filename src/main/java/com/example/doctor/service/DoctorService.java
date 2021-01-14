package com.example.doctor.service;

import com.example.doctor.dto.SearchDTO;
import com.example.doctor.entity.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorService {
    List<Doctor> getAll();

    Optional<Doctor> findByDoctorCode(String doctorCode);

    List<Doctor> searchDoctor(SearchDTO searchDTO);
}
