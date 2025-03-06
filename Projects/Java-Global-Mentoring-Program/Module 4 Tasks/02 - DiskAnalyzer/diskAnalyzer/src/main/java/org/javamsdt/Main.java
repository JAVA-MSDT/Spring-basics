/*
 * Copyright (c) 2023 Ahmed Samy.
 */

package org.javamsdt;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.nio.file.Files.walk;

public class Main {
  public static void main(String[] args) {
    String path = "C:/";
    Path path1 = Paths.get(path);


    directories(path1);


    try(Stream<Path> pathStream = Files.list(path1)) {
      long counting = pathStream.peek(fi -> System.out.println(fi.getFileName()))
       .map(Main::directories)
        .peek(paths -> System.out.println("Paths:: " + paths.toString()))
        .count();
      System.out.println(counting);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private static List<Path> directories(Path path1) {
    try {
      System.out.println(path1);
       return Files.walk(path1)
        .filter(Files::isDirectory)
         .filter(Files::isWritable)
         .filter(Files::isReadable)
         .collect(Collectors.toList());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private static Map<String, Path> foldersMap(Path path) {
    System.out.println("Path:: " + path.getFileName().toString());
    Map<String, Path> directories = new HashMap<>();
    if(Files.isDirectory(path)) {
      directories.put(path.getFileName().toString(), path);
      return foldersMap(path);
    }
    return directories;
  }
}
