package org.duna.jep213.trywithresources;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

public class TryWithResourcesDemo01 {
  public static void main(String[] args) throws IOException {

    Logger logger = Logger.getLogger(TryWithResourcesDemo01.class.getName());

    String pathFile = "numbers.txt";

    //Java 9 introduces try-with-resources functionality
    //to simplify and optimize resource management
    //Although the try-with-resources functionality
    //was officially introduced in Java 9 with JEP 213,
    //some Java 9 features were implemented retroactively
    //in previous versions via update.
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathFile));

    //It is now possible to place the resource instance directly in the Try
    try (bufferedWriter) {
      for (int i = 1; i <= 10; i++) {
        bufferedWriter.write(i + "\n");
      }
    } catch (IOException e) {
      logger.warning("Interrupted!\n" + e);
      Thread.currentThread().interrupt();
    }

    System.out.println("Successful Created File: " + pathFile);
  }
}
