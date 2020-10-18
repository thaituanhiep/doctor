package com.example.doctor.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Table(name = "experience")
@Entity
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(
            name = "doctor_code",
            referencedColumnName = "doctor_code"
    )
    @NotNull
    @JsonIgnoreProperties("experiences")
    private Doctor doctor;

    @Column(name = "year_start", nullable = true)
    private Integer yearStart;

    @Column(name = "year_end", nullable = true)
    private Integer yearEnd;

    @NotNull
    @Size(max = 1000)
    private String content;

    @Size(max = 50)
    @Column(name = "in_country")
    private String inCountry;
}
