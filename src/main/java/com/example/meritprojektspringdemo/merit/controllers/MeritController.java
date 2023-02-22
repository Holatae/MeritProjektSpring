package com.example.meritprojektspringdemo.merit.controllers;
import com.example.meritprojektspringdemo.merit.meritprojekt.Course;
import com.example.meritprojektspringdemo.merit.meritprojekt.Student;
import com.example.meritprojektspringdemo.merit.services.MeritService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class MeritController {
    MeritService meritService;
    @Autowired
    public MeritController(MeritService meritService) {
        this.meritService = meritService;
    }
    @RequestMapping("/{SSN}")
    public @ResponseBody ModelAndView index(@PathVariable String SSN) {
        ModelAndView modelAndView;

        try {
            modelAndView = new ModelAndView("merit");
            Student student = meritService.checkIfStudentIsValid(SSN);
            modelAndView.addObject("student", student);
            return modelAndView;

        } catch (Exception e) {
            modelAndView = new ModelAndView("login");
            modelAndView.addObject("error", "Invalid SSN");
            return modelAndView;

        }
    }

    @PostMapping("/{SSN}")
    public @ResponseBody ModelAndView addCourse(@PathVariable String SSN, @ModelAttribute("htmlCourse") Course course) {
        Student student = meritService.addCourse(SSN, course);
        ModelAndView modelAndView = new ModelAndView("merit");
        modelAndView.addObject("student", student);
        return modelAndView;
    }

    @PostMapping("/{SSN}/removeCourse")
    public @ResponseBody ModelAndView removeCourses(@PathVariable String SSN, @RequestParam Map<String, String> check) {
        ModelAndView modelAndView = new ModelAndView("merit");
        modelAndView.addObject("student", meritService.removeCourse(SSN, check));
        return modelAndView;
    }
}
