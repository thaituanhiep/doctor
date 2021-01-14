package com.example.doctor.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchDTO {
    private String name;
    private String nationality;
    private String specialities;
    private String gender;
    private String education;
    private String hospital;
}
