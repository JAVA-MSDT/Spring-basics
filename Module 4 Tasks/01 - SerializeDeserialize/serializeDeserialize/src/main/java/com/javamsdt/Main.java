/*
 * Copyright (c) 2023 Ahmed Samy.
 */

package com.javamsdt;

import com.javamsdt.model.User;
import com.javamsdt.service.UserSerializeDeserialize;
import java.time.LocalDate;

public class Main {
  public static void main(String[] args) {
    UserSerializeDeserialize userSerializeDeserialize = new UserSerializeDeserialize();
    String path = "Module 4 Tasks/01 - SerializeDeserialize/serializeDeserialize/src/main/resources/files/user.txt";
    User user = new User(2, "UserTwo", 25, "user@user.com", LocalDate.now().minusYears(25));

    userSerializeDeserialize.serializeUser(user, path);
    userSerializeDeserialize.deSerializeUser(path);
  }
}
