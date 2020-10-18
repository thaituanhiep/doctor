package com.example.doctor.controller;

import com.example.doctor.service.AwardService;
import com.example.doctor.service.DoctorService;
import com.example.doctor.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private AwardService awardService;

    @Autowired
    private ExperienceService experienceService;

    @GetMapping(value = "/doctor")
    public String listDoctor(Model model) {
        model.addAttribute("doctorList", doctorService.getAll());
        return "doctor-list";
    }

    @GetMapping(value = "/doctor/id/{doctorCode}")
    public String infoDoctor(Model model, @PathVariable("doctorCode") String doctorCode) {
        return doctorService.findDoctorByDoctorCode(doctorCode)
                .map(doctor -> {
                    model.addAttribute("doctor", doctor);
                    model.addAttribute("awardList", awardService.findAwardsByDoctorCode(doctorCode));
                    model.addAttribute("experienceList",
                            experienceService.findExperiencesByDoctorCode(doctorCode));
                    model.addAttribute("specialities", doctor.getSpecialities().split(";"));
                    return "doctor-content";
                })
                .orElse("doctor-list");
    }
}
