package com.example.meritprojektspringdemo.merit.controllers;

import com.example.meritprojektspringdemo.merit.meritprojekt.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LoginController {

    @RequestMapping("/")
    public ModelAndView loginView() {
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }

    @PostMapping("/")
    public RedirectView login(@RequestParam String SSN) {
        ModelAndView modelAndView = new ModelAndView("index");
        try {
            Student student = new Student(SSN.split("\n")[0]);
            modelAndView.addObject("student", student);
            student.LoadStudentFromFile();
            modelAndView.addObject(student);
        } catch (Exception e) {
            modelAndView.addObject("error", "Invalid SSN");
        }

        return new RedirectView("/" + SSN.split("\n")[0]);
    }
}
