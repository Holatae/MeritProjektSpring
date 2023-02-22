package com.example.meritprojektspringdemo.merit;

import com.example.meritprojektspringdemo.merit.meritprojekt.Course;
import org.jetbrains.annotations.NotNull;

public class extendedCourse extends Course {
    public extendedCourse(@NotNull String name, int coursePoints, @NotNull String grade, boolean isChecked) {
        super(name, coursePoints, grade);
    }
}
