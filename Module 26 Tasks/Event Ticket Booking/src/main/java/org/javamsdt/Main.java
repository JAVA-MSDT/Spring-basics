/*
 * Copyright (c) 2023 Ahmed Samy.
 */

package org.javamsdt;

import org.javamsdt.config.ApplicationConfig;
import org.javamsdt.dao.DB;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
    ApplicationConfig config = context.getBean(ApplicationConfig.class);
    DB db = context.getBean(DB.class);

    System.out.println(db.getDbProp());
    System.out.println(config.getValue());
    System.out.println("Hello world!");
  }
}
