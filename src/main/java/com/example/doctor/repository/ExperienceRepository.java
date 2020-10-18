package com.example.doctor.repository;

import com.example.doctor.entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Integer> {
    @Query("SELECT e " +
            "FROM Experience e " +
            "WHERE e.doctor.doctorCode = ?1")
    public List<Experience> findExperiencesByDoctorCode(String doctorCode);

}
