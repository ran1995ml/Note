package com.ran.javase.designpattern.decorator.io;



import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * InputStreamTest
 *
 * @author rwei
 * @since 2023/4/3 09:59
 */
public class InputStreamTest {
    public static void main(String[] args) throws IOException {
        int c;
        try {
            InputStream inputStream = new LowerCaseInputStream(new BufferedInputStream(Files.newInputStream(Paths.get("/Users/rwei/IdeaProjects/Note/JavaSE/src/main/java/com/ran/javase/designpattern/decorator/io/test.txt"))));
            while ((c = inputStream.read()) >= 0) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
