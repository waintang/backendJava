package com.example.practice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextReaderTest {

    public static void main(String[] args) {
        String filePath = "D:\\desktop\\m3u8.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            long i = 1;
            long sum = 0;
            while ((line = reader.readLine()) != null) {
                if(line.matches("#EXTINF:(.)*,")){
                    line = line.replace("#EXTINF:","");
                    line = line.replace(",","");
                    // 处理每一行的逻辑
                    System.out.print(i+":");
                    System.out.println(line);
                    sum = sum+Long.valueOf(line);
                    System.out.println("sum:"+sum);
                    i++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
