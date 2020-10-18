package com.example.doctor.service;

import com.example.doctor.entity.Doctor;
import com.example.doctor.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public List<Doctor> getAll() {
        return doctorRepository.findAll();
    }

    @Override
    public Optional<Doctor> findDoctorByDoctorCode(String doctorCode) {
        return doctorRepository.findDoctorByDoctorCode(doctorCode);
    }
}
