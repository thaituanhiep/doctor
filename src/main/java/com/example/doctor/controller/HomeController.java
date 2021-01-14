package com.example.doctor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    @GetMapping(value = "/doctors")
    public String listDoctor(Model model) {
        return "doctor-list";
    }

    @GetMapping(value = "/doctor/id/{doctorCode}")
    public String infoDoctor(Model model, @PathVariable String doctorCode) {
        return "doctor-content";
    }
}
