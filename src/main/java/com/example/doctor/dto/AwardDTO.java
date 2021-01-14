package com.example.doctor.dto;

import com.example.doctor.entity.Award;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AwardDTO {
    private String doctorCode;
    private int yearAt;
    private String name;

    public static AwardDTO getDTO(Award award) {
        return AwardDTO.builder()
                .doctorCode(award.getDoctor().getDoctorCode())
                .yearAt(award.getYearAt())
                .name(award.getName())
                .build();
    }
}
