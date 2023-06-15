package com.ran.designpattern.decorate;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * InputStreamTest
 * 测试自定义装饰输入流
 * @author rwei
 * @since 2023/6/15 21:32
 */
public class InputStreamTest {
    public static void main(String[] args) {
        String path = "/Users/rwei/IdeaProjects/Note/DesignPattern/src/main/java/com/ran/designpattern/decorate/test.txt";
        int c;
        try {
            LowCaseInputStream inputStream = new LowCaseInputStream(new BufferedInputStream(Files.newInputStream(Paths.get(path))));
            while ((c = inputStream.read()) > 0) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
