/*
 * Copyright (c) 2023 Ahmed Samy.
 */

package org.javamsdt.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"org.javamsdt"})
@PropertySource("classpath:application.properties")
public class ApplicationConfig {
  @Value("${spring.value}")
  private String value;

  public String getValue() {
    return value;
  }
}
