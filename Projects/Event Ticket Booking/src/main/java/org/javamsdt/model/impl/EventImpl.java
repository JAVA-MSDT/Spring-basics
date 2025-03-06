/*
 * Copyright (c) 2023 Ahmed Samy.
 */

package org.javamsdt.model.impl;

import java.util.Date;
import lombok.ToString;
import org.javamsdt.model.Event;

@ToString
public class EventImpl implements Event {
  private long id;
  private String title;
  private Date date;

  @Override
  public long getId() {
    return this.id;
  }

  @Override
  public void setId(long id) {
    this.id = id;
  }

  @Override
  public String getTitle() {
    return this.title;
  }

  @Override
  public void setTitle(String title) {
    this.title = title;
  }

  @Override
  public Date getDate() {
    return this.date;
  }

  @Override
  public void setDate(Date date) {
    this.date = date;
  }
}
