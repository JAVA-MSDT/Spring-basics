/*
 * Copyright (c) 2023 Ahmed Samy.
 */

package org.javamsdt.model.impl;

import lombok.ToString;
import org.javamsdt.model.User;
@ToString
public class UserImpl implements User {

  private long id;
  private String name;
  private String email;

  @Override
  public long getId() {
    return this.id;
  }

  @Override
  public void setId(long id) {
    this.id = id;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String getEmail() {
    return this.email;
  }

  @Override
  public void setEmail(String email) {
    this.email = email;
  }


}
