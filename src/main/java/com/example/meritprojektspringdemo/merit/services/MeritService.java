package com.example.meritprojektspringdemo.merit.services;

import com.example.meritprojektspringdemo.merit.meritprojekt.Student;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Map;

@Service
public class MeritService {
    public Student meritSite(String SSN) {
        Student student = new Student(SSN.split("\n")[0]);
        student.LoadStudentFromFile();
        return student;
    }

    /**
     * @param SSN SSN of the student
     * @param checkboxes All the checkboxes from the HTML document
     * @return The student with the removed courses
     */
    public Student removeCourse(String SSN, Map<String, String> checkboxes) {
        Student student = new Student(SSN.split("\n")[0]);
        student.LoadStudentFromFile();
        ArrayList<String> checkedCheckboxes = new ArrayList<>(checkboxes.values());
        int index = 0;

        while (index < student.getCourses().size()){
            index = 0;
            for (String checkbox : checkedCheckboxes
            ) {
                if (checkbox.equals("on")) {
                    student.removeCourseFromIndex(index);
                    checkedCheckboxes.remove(index);
                    break;
                }
                index++;
            }
        }

        student.LoadStudentFromFile();
        return student;
    }

}
