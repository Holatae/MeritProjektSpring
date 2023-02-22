package com.example.meritprojektspringdemo.merit.meritprojekt;

import dev.personnummer.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Student {
    private final String SSN;
    private ArrayList<Course> courses = new ArrayList<>();
    private double extraMerit;

    /**
     * @param SSN Social security number
     * if you don't currently have any courses in memory, just set it to <strong>null</strong>
     * @throws PersonnummerException If the SSN is invalid an exception is thrown.
     */
    public Student(String SSN) {
        new File("students").mkdirs();
        try {
            this.SSN = new Personnummer(SSN).format();
        } catch (PersonnummerException e) {
            throw new IllegalArgumentException(e);
        }
        File file = new File("students", this.SSN);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public double getExtraMerit() {
        return extraMerit;
    }

    /**
     * @param extraMerit how much extraMerit should be
     * <p>Extra Merit should <strong>ONLY</strong> be set to 0, 0.5, 1, 1.5 or 2
     *    It works with other numbers as well but those are the only extra merit you can
     *    get in Sweden</p>
     */
    public void setExtraMerit(double extraMerit) {
        this.extraMerit = extraMerit;
    }

    @Override
    public String toString() {
        return "Student{" +
                "SSN='" + SSN + '\'' +
                ", courses=" + courses +
                ", extraMerit=" + extraMerit +
                '}';
    }

    public void removeCourseFromIndex(int index){
        this.courses.remove(index);
        CourseManager.saveStudentToFile(this);
    }

    public double calculateMerit(){
        double merit = 0;
        for (Course course : courses) {
            merit += course.getGradeMerit() * course.getCoursePoints();
        }
        int totalHours = 0;
        for (Course course : courses) {
            totalHours += course.getCoursePoints();
        }
        double meritTemp = (merit / totalHours) + extraMerit;
        return Math.round(meritTemp * 100.0) / 100.0;
    }

    public String getSSN() {
        return SSN;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    /**
     * @param course the course you want to add to current student
     * @see Course
     */
    public void addCourse(Course course) {
        this.courses.add(course);
        CourseManager.saveStudentToFile(this);
    }

    public void LoadStudentFromFile(){
        this.courses = CourseManager.readCourses(this.SSN);
    }
}
