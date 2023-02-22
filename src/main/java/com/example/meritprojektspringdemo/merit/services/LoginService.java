package com.example.meritprojektspringdemo.merit.services;

import com.example.meritprojektspringdemo.merit.meritprojekt.Student;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    /**
     * @param SSN SSN of the student
     * @return The student with the SSN
     */
    public Student getStudent(String SSN) {
        Student student = new Student(SSN.split("\n")[0]);
        student.LoadStudentFromFile();
        return student;
    }
}
