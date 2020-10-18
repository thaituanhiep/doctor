package com.example.doctor.repository;

import com.example.doctor.entity.Award;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AwardRepository extends JpaRepository<Award, Integer> {
    @Query("SELECT a " +
            "FROM Award a " +
            "WHERE a.doctor.doctorCode = ?1")
    public List<Award> findAwardsByDoctorCode(String doctorCode);
}
