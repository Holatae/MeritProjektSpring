package com.example.meritprojektspringdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@SpringBootApplication
public class MeritProjektSpringDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MeritProjektSpringDemoApplication.class, args);
    }


}
