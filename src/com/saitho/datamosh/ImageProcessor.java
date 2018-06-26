package com.saitho.datamosh;

import java.io.*;

/**
 * Decoding datamoshes: http://axxim.net/ow/gol-guesser/dorado/
 */
public class ImageProcessor {
    private int ignoreFirstPercentage = 25; // ignore first % bytes before making changes
    private int ignoreLastPercentage = 35; // ignore last % bytes before making changes

    private int startAt;
    private int stopAt;
    private int availableSize;

    private String word;
    private int currentWordIndex = 0;

    private byte[] originalFileContent;
    private String outputFilePath;

    ImageProcessor(String inputFilePath, String outputFilePath) throws IOException {
        BufferedInputStream is = new BufferedInputStream(new FileInputStream(inputFilePath));
        originalFileContent = is.readAllBytes();
        this.outputFilePath = outputFilePath;

        startAt = originalFileContent.length / 100 * ignoreFirstPercentage;
        stopAt = originalFileContent.length/100 * (100-ignoreLastPercentage);
        availableSize = originalFileContent.length/100 * (100 - ignoreFirstPercentage - ignoreLastPercentage);
    }

    private boolean hasNextChar() {
        if (word == null) {
            return false;
        }
        return currentWordIndex < word.length();
    }

    private char getNextChar() {
        return word.charAt(currentWordIndex++);
    }

    public void setWord(String word) {
        this.word = word;
        this.currentWordIndex = 0;
    }

    void process() throws IOException {
        byte[] newContent = this.originalFileContent;

        int putEvery = 0;
        if (word != null) {
            putEvery = availableSize / word.length();
        }
        int putNext = startAt;
        for (int i = 0; i < newContent.length; i++) {
            if (i >= stopAt || !(i == putNext) || !hasNextChar()) {
                continue;
            }
            // modify character
            newContent[i] = (byte) getNextChar();
            putNext += putEvery;
        }

        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(this.outputFilePath));
        out.write(newContent);
        out.close();
    }
}
