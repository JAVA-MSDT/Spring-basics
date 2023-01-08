/*
 * Copyright (c) 2023 Ahmed Samy.
 */

package com.javamsdt.model;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class User implements Serializable {
  private static final long serialVersionUID = 7438255714694047836L;
  private long id;
  private String fullName;
  private int age;
  private String email;
  private LocalDate birtDate;

}
