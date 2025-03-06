/*
 * Copyright (c) 2023 Ahmed Samy.
 */

package com.javamsdt.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class Teacher extends User implements Serializable {
  private static final long serialVersionUID = 7438255714694047845L;

  private String subject;
  private transient double salary;
  private int yearsOfExperience;

}
