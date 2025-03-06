/*
 * Copyright (c) 2023 Ahmed Samy.
 */

package org.javamsdt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class PointTwo {
  public static void main(String[] args) throws IOException {
    Path path = Paths.get("D:/programming");

    try (Stream<Path> paths = Files.find(path, Integer.MAX_VALUE, (pathD, attributes) -> attributes.isRegularFile()
      && (pathD.toString().contains("s") || pathD.toString().contains("S")))) {
      paths.forEach(System.out::println);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    /*
     * Files.walk(path)
     * .filter(pathD -> !Files.isDirectory(pathD))
     * .filter(PointTwo::isAccessPermit)
     * .collect(Collectors.toList())
     * .forEach(System.out::println);
     */

  }

  private static boolean isAccessPermit(Path path) {
    return Files.isExecutable(path)
      && Files.isExecutable(path)
      && Files.isWritable(path)
      && Files.isReadable(path);
  }
}
