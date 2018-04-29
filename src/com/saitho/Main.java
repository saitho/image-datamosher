package com.saitho;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            String inputFile = args[0];
            String outputFile = args[1];
            ImageProcessor ip = new ImageProcessor(inputFile, outputFile);
            if (args.length > 2 && args[2] != null) {
                ip.setWord(args[2]);
            }
            ip.process();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
