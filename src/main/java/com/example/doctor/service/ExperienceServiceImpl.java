package com.example.doctor.service;

import com.example.doctor.dto.ExperienceDTO;
import com.example.doctor.entity.Experience;
import com.example.doctor.repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExperienceServiceImpl implements ExperienceService {

    @Autowired
    private ExperienceRepository experienceRepository;

    @Override
    public List<Experience> getAll() {
        return experienceRepository.findAll();
    }

    @Override
    public List<ExperienceDTO> findByDoctorCode(String doctorCode) {
        List<Experience> all = experienceRepository.findAll();
        Comparator<ExperienceDTO> comparator =
                Comparator.comparing(ExperienceDTO::getInCountry, Comparator.nullsLast(Comparator.naturalOrder()))
                        .thenComparing(ExperienceDTO::getYearStart, Comparator.nullsLast(Comparator.naturalOrder()));

        List<ExperienceDTO> experienceDTOList =
                all.parallelStream()
                        .filter(o -> o.getDoctor().getDoctorCode().equals(doctorCode))
                        .map(ExperienceDTO::getDTO)
                        .sorted(comparator)
                        .collect(Collectors.toList());

        return experienceDTOList;
    }
}
