package com.example.doctor.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@Table(name = "doctor")
@Entity
public class Doctor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(max = 20)
    @NotNull
    @Column(name = "doctor_code", unique = true)
    @NaturalId
    private String doctorCode;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("doctor")
    private Set<Award> awards;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("doctor")
    private Set<Experience> experiences;

    @Size(max = 50)
    @NotNull
    private String name;

    @Size(max = 20)
    private String gender;

    @NotNull
    @Size(max = 50)
    private String nationality;

    @Size(max = 100)
    @Column(name = "image_profile")
    private String imageProfile;

    @Size(max = 10000)
    private String about;

    @Size(max = 100)
    private String address;

    @Size(max = 20)
    private String phone;

    @Size(max = 20)
    @NotNull
    private String education;

    @Size(max = 100)
    @NotNull
    private String roles;

    @Size(max = 100)
    @NotNull
    private String specialities;

    @Size(max = 100)
    @NotNull
    private String workplace;

    @Temporal(TemporalType.DATE)
    @Column(name = "created_at")
    private Date createdAt;

    @Temporal(TemporalType.DATE)
    @Column(name = "updated_at")
    private Date updatedAt;

    @Temporal(TemporalType.DATE)
    @Column(name = "end_at")
    private Date endAt;
}
