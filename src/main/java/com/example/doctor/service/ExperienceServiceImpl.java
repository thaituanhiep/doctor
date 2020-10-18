package com.example.doctor.service;

import com.example.doctor.entity.Experience;
import com.example.doctor.repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceServiceImpl implements ExperienceService {

    @Autowired
    private ExperienceRepository experienceRepository;

    @Override
    public List<Experience> findExperiencesByDoctorCode(String doctorCode) {
        return experienceRepository.findExperiencesByDoctorCode(doctorCode);
    }
}
