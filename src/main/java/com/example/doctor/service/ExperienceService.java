package com.example.doctor.service;

import com.example.doctor.dto.ExperienceDTO;
import com.example.doctor.entity.Experience;

import java.util.List;

public interface ExperienceService {
    List<Experience> getAll();

    List<ExperienceDTO> findByDoctorCode(String doctorCode);
}
