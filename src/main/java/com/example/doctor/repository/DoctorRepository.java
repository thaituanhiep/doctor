package com.example.doctor.repository;

import com.example.doctor.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    @Query("SELECT d " +
            "FROM Doctor d " +
            "WHERE d.doctorCode = ?1")
    public Optional<Doctor> findDoctorByDoctorCode(String doctorCode);
}
