package com.example.meritprojektspringdemo.merit.meritprojekt;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        new File("students").mkdirs();
        Cli cli = new Cli();
        cli.Run();

    }
}
