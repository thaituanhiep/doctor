package com.example.doctor.service;

import com.example.doctor.entity.Experience;

import java.util.List;

public interface ExperienceService {
    List<Experience> findExperiencesByDoctorCode(String doctorCode);
}
