package com.example.doctor.service;

import com.example.doctor.dto.AwardDTO;
import com.example.doctor.entity.Award;
import com.example.doctor.repository.AwardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AwardServiceImpl implements AwardService {

    @Autowired
    private AwardRepository awardRepository;

    @Override
    public List<Award> getAll() {
        return awardRepository.findAll();
    }

    @Override
    public List<AwardDTO> findByDoctorCode(String doctorCode) {
        List<Award> all = awardRepository.findAll();
        List<AwardDTO> awardList =
                all.parallelStream()
                        .filter(o -> o.getDoctor().getDoctorCode().equals(doctorCode))
                        .map(o -> AwardDTO.getDTO(o))
                        .sorted(Comparator.comparingInt(AwardDTO::getYearAt))
                        .collect(Collectors.toList());
        return awardList;
    }
}
