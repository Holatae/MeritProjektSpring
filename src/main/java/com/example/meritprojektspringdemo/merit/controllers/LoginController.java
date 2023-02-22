package com.example.meritprojektspringdemo.merit.controllers;

import com.example.meritprojektspringdemo.merit.meritprojekt.Student;
import com.example.meritprojektspringdemo.merit.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LoginController {

    LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping("/")
    public ModelAndView loginView() {
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }

    @PostMapping("/")
    public ModelAndView login( @RequestParam String SSN) {
        ModelAndView modelAndView = new ModelAndView("login");
        try {
            Student student = loginService.getStudent(SSN);
            modelAndView.addObject(student);
        } catch (Exception e) {
            modelAndView.addObject("error", "Invalid SSN");
            return modelAndView;

        }
        return new ModelAndView("redirect:/" + SSN.split("\n")[0]);
    }
}
