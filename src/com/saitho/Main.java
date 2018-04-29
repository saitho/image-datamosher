package com.saitho;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            ImageProcessor ip = new ImageProcessor("C:\\Users\\Lubenka\\Desktop\\Glee-original.jpg");
            ip.setWord("Hello World!");
            ip.process();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
