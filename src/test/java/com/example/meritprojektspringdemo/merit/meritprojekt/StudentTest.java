package com.example.meritprojektspringdemo.merit.meritprojekt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StudentTest {
    private final String realTestSSN = "690813-3272";

    @Test
    void studentAddingCoursesTest() {
        Student student = new Student(realTestSSN);
        student.addCourse(new Course("SVENSKA 1", 100, "A"));
        student.addCourse(new Course("PROGRAMMERING 1", 100, "E"));

        assertEquals("info.coolchatserver.merit.Course{name='SVENSKA 1', grade='A', coursePoints=100, gradeMerit=20.0}", student.getCourses().get(0).toString());
        assertEquals("info.coolchatserver.merit.Course{name='PROGRAMMERING 1', grade='E', coursePoints=100, gradeMerit=10.0}", student.getCourses().get(1).toString());
    }

    @Test
    void createStudentWithoutLegalSSN(){
        assertThrows(IllegalArgumentException.class, () -> new Student("1111111111"));
    }
    @Test
    void calculateMeritWithOneCourse(){
        Student student = new Student(realTestSSN);
        student.addCourse(new Course("SVENSKA 1", 100, "A"));

        assertEquals(20.0, student.calculateMerit());
    }

    @Test
    void removeCourseWithIndex1(){
        Student student = new Student(realTestSSN);
        student.addCourse(new Course("SVENSKA 1", 100, "A"));
        student.addCourse(new Course("PROGRAMMERING 1", 100, "E"));
        student.removeCourseFromIndex(1);

        assertEquals("info.coolchatserver.merit.Course{name='SVENSKA 1', grade='A', coursePoints=100, gradeMerit=20.0}", student.getCourses().get(0).toString());
        assertThrows(IndexOutOfBoundsException.class, () -> {
            student.getCourses().get(1).getName();
        });
    }

}
