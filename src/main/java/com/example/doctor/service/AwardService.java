package com.example.doctor.service;

import com.example.doctor.dto.AwardDTO;
import com.example.doctor.entity.Award;

import java.util.List;

public interface AwardService {
    List<Award> getAll();

    List<AwardDTO> findByDoctorCode(String doctorCode);
}
