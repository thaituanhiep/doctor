package com.example.doctor.dto;

import com.example.doctor.entity.Experience;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ExperienceDTO {
    private String doctorCode;
    private Integer yearStart;
    private Integer yearEnd;
    private String content;
    private String inCountry;

    public static ExperienceDTO getDTO(Experience experience) {
        return ExperienceDTO.builder()
                .doctorCode(experience.getDoctor().getDoctorCode())
                .yearStart(experience.getYearStart())
                .yearEnd(experience.getYearEnd())
                .content(experience.getContent())
                .inCountry(experience.getInCountry())
                .build();
    }
}
