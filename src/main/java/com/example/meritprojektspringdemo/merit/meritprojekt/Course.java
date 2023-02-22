package com.example.meritprojektspringdemo.merit.meritprojekt;

import org.jetbrains.annotations.NotNull;

public class Course {
    private String name;
    private String grade;
    private int coursePoints;
    private double gradeMerit;
    private final double totalMerit;

    public double getTotalMerit() {
        return totalMerit;
    }

    public int getCoursePoints() {
        return coursePoints;
    }

    public void setCoursePoints(int coursePoints) {
        this.coursePoints = coursePoints;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getGradeMerit() {
        return gradeMerit;
    }

    public void setGradeMerit(double gradeMerit) {
        this.gradeMerit = gradeMerit;
    }

    public Course(@NotNull String name, int coursePoints, String grade) {
        if (grade == null) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.grade = grade;
        this.coursePoints = coursePoints;

        switch (grade.toUpperCase()) {
            case "A" -> {
                this.gradeMerit = 20;
            }
            case "B" -> {
                this.gradeMerit = 17.5;
            }
            case "C" -> {
                this.gradeMerit = 15;
            }
            case "D" -> {
                this.gradeMerit = 12.5;
            }
            case "E" -> {
                this.gradeMerit = 10;
            }
            case "F", "-" -> {
                this.gradeMerit = 0;
            }
            default -> {
                throw new IllegalArgumentException();
            }
        }

        totalMerit = gradeMerit * coursePoints;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                ", coursePoints=" + coursePoints +
                ", gradeMerit=" + gradeMerit +
                '}';
    }
}
