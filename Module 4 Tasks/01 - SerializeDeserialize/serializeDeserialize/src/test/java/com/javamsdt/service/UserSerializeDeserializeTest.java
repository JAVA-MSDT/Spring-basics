/*
 * Copyright (c) 2023 Ahmed Samy.
 */

package com.javamsdt.service;

import com.javamsdt.model.User;
import java.time.LocalDate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserSerializeDeserializeTest {
  // private static final String PATH = "Module 4 Tasks/01 - SerializeDeserialize/serializeDeserialize/src/test/resources/files/user.txt";
  private static final String PATH = "";

  User user = new User(2, "UserTwo", 25, "user@user.com", LocalDate.now().minusYears(25));
  UserSerializeDeserialize userSerializeDeserialize = new UserSerializeDeserialize();

  @BeforeEach
  void setUp() {

  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void serializeUser() {
    // Given
    userSerializeDeserialize.serializeUser(user, PATH);
    // When
    User expectedUser = userSerializeDeserialize.deSerializeUser(PATH);

    // Then
    Assertions.assertEquals(expectedUser.getFullName(), user.getFullName());
  }

  @Test
  void deSerializeUser() {
  }
}
