/*
 * Copyright (c) 2023 Ahmed Samy.
 */

package org.javamsdt.dao;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class DB {
  @Value("${db.prop}")
  private String dbProp;

}
