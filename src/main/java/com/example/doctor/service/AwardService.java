package com.example.doctor.service;

import com.example.doctor.entity.Award;

import java.util.List;

public interface AwardService {
    List<Award> findAwardsByDoctorCode(String doctorCode);
}
