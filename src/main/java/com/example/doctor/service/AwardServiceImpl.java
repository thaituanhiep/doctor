package com.example.doctor.service;

import com.example.doctor.entity.Award;
import com.example.doctor.repository.AwardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AwardServiceImpl implements AwardService {

    @Autowired
    private AwardRepository awardRepository;

    @Override
    public List<Award> findAwardsByDoctorCode(String doctorCode) {
        return awardRepository.findAwardsByDoctorCode(doctorCode);
    }
}
