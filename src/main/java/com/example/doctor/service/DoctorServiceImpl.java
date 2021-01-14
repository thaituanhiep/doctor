package com.example.doctor.service;

import com.example.doctor.dto.SearchDTO;
import com.example.doctor.entity.Doctor;
import com.example.doctor.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public List<Doctor> getAll() {
        return doctorRepository.findAll();
    }

    @Override
    public Optional<Doctor> findByDoctorCode(String doctorCode) {
        List<Doctor> all = doctorRepository.findAll();
        Optional<Doctor> doctor =
                all.parallelStream()
                        .filter(o -> o.getDoctorCode().equals(doctorCode))
                        .findFirst();
        return doctor;
    }

    @Override
    public List<Doctor> searchDoctor(SearchDTO searchDTO) {
        List<Doctor> all = doctorRepository.findAll();
        List<Doctor> doctorList =
                all.parallelStream()
                        .filter(o -> searchDTO.getName() == null || o.getName().contains(searchDTO.getName()))
                        .filter(o -> searchDTO.getNationality() == null || o.getNationality().equalsIgnoreCase(searchDTO.getNationality()))
                        .filter(o -> searchDTO.getGender() == null || o.getGender().equalsIgnoreCase(searchDTO.getGender()))
                        .filter(o -> searchDTO.getEducation() == null || o.getEducation().equalsIgnoreCase(searchDTO.getEducation()))
                        .filter(o -> searchDTO.getSpecialities() == null || o.getSpecialities().contains(searchDTO.getSpecialities()))
                        .filter(o -> searchDTO.getHospital() == null || o.getWorkplace().contains(searchDTO.getHospital()))
                        .collect(Collectors.toList());
        return doctorList;
    }

}
