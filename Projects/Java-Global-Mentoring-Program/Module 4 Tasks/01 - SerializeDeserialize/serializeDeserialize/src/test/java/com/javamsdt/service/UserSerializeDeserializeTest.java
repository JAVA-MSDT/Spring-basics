/*
 * Copyright (c) 2023 Ahmed Samy.
 */

package com.javamsdt.service;

import com.javamsdt.model.Teacher;
import com.javamsdt.model.User;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class UserSerializeDeserializeTest {
  private static final Path resourceDirectory = Paths.get("src", "test", "resources");
  private static final String USER_PATH = resourceDirectory.toAbsolutePath() + "/files/user.txt";
  private static final String TEACHER_PATH = resourceDirectory.toAbsolutePath() + "/files/teacher.txt";

  User user = new User(2, "UserTwo", 25, "user@user.com", LocalDate.now().minusYears(25));
  UserSerializeDeserialize userSerializeDeserialize = new UserSerializeDeserialize();

  @Test
  @Order(1)
  void serializeUser() {
    // Given
    userSerializeDeserialize.serializeUser(user, USER_PATH);
    // When
    User expectedUser = userSerializeDeserialize.deSerializeUser(USER_PATH);

    // Then
    Assertions.assertEquals(expectedUser.getFullName(), user.getFullName());
  }

  @Test
  @Order(2)
  void deSerializeUser() {
    // When
    User expectedUser = userSerializeDeserialize.deSerializeUser(USER_PATH);

    // Then
    Assertions.assertEquals(expectedUser.getFullName(), user.getFullName());
  }

  @Test
  @Order(1)
  void serializeTeacher() {
    // Given
    userSerializeDeserialize.serializeUser(getTeacher(), TEACHER_PATH);
    // When
    User expectedTeacher = userSerializeDeserialize.deSerializeUser(TEACHER_PATH);

    // Then
    Assertions.assertEquals(expectedTeacher.getFullName(), getTeacher().getFullName());
  }

  @Test
  @Order(2)
  void deSerializeTeacher() {
    // When
    User expectedTeacher = userSerializeDeserialize.deSerializeUser(TEACHER_PATH);

    // Then
    Assertions.assertEquals(expectedTeacher.getFullName(), getTeacher().getFullName());
  }

  private Teacher getTeacher() {
    Teacher teacher = new Teacher();
    teacher.setId(1);
    teacher.setAge(30);
    teacher.setBirtDate(LocalDate.now().minusYears(30));
    teacher.setEmail("teacher@school.com");
    teacher.setFullName("Teacher");
    teacher.setSalary(4500D);
    teacher.setYearsOfExperience(5);
    teacher.setSubject("Arabic");
    return teacher;
  }
}
