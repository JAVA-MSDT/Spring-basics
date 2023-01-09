/*
 * Copyright (c) 2023 Ahmed Samy.
 */

package com.javamsdt.service;

import com.javamsdt.model.User;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class UserSerializeDeserializeTest {
  private static final Path resourceDirectory = Paths.get("src", "test", "resources");
  private static final String PATH = resourceDirectory.toAbsolutePath() + "/files/user.txt";

  User user = new User(2, "UserTwo", 25, "user@user.com", LocalDate.now().minusYears(25));
  UserSerializeDeserialize userSerializeDeserialize = new UserSerializeDeserialize();

  @Test
  @Order(1)
  void serializeUser() {
    // Given
    userSerializeDeserialize.serializeUser(user, PATH);
    // When
    User expectedUser = userSerializeDeserialize.deSerializeUser(PATH);

    // Then
    Assertions.assertEquals(expectedUser.getFullName(), user.getFullName());
  }

  @Test
  @Order(2)
  void deSerializeUser() {
    // When
    User expectedUser = userSerializeDeserialize.deSerializeUser(PATH);

    // Then
    Assertions.assertEquals(expectedUser.getFullName(), user.getFullName());
  }
}
