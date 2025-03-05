/*
 * Copyright (c) 2023 Ahmed Samy.
 */

package com.javamsdt.service;

import com.javamsdt.model.User;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserSerializeDeserialize {

  public void serializeUser(User user, String path) {
    try (FileOutputStream fileOutputStream = new FileOutputStream(path);
      ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);) {
      objectOutputStream.writeObject(user);
      objectOutputStream.flush();
      log.info("Done serializing a User {} to the following Path {}", user.getFullName(), path);
    } catch (FileNotFoundException f) {
      log.error("File not Found {} ", f.getMessage());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public User deSerializeUser(String path) {
    User user = new User();
    try (FileInputStream fileInputStream = new FileInputStream(path);
      ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);) {
      user = (User) objectInputStream.readObject();
      log.info("Done deSerializing a User {} from the following Path {}", user.getFullName(), path);

    } catch (FileNotFoundException f) {
      log.error("File not Found {} ", f.getMessage());
    } catch (ClassNotFoundException e) {
      log.error("Class not Found {} ", e.getMessage());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return user;
  }
}
