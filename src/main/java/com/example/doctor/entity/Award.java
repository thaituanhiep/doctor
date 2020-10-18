package com.example.doctor.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Table(name = "award")
@Entity
public class Award {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(
            name = "doctor_code",
            referencedColumnName = "doctor_code"
    )
    @NotNull
    @JsonIgnoreProperties("awards")
    private Doctor doctor;

    @Column(name = "year_at", nullable = true)
    private Integer yearAt;

    @NotNull
    @Size(max = 50)
    private String name;
}
