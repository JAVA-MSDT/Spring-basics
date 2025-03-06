/*
 * Copyright (c) 2023 Ahmed Samy.
 */

package org.javamsdt.model.impl;

import lombok.ToString;
import org.javamsdt.model.Ticket;
import org.javamsdt.model.enums.Category;

@ToString
public class TicketImpl implements Ticket {
  private long id;
  private long eventId;
  private long userId;
  private Category category;
  private int place;

  @Override
  public long getId() {
    return this.id;
  }

  @Override
  public void setId(long id) {
    this.id = id;
  }

  @Override
  public long getEventId() {
    return this.eventId;
  }

  @Override
  public void setEventId(long eventId) {
    this.eventId = eventId;
  }

  @Override
  public long getUserId() {
    return this.userId;
  }

  @Override
  public void setUserId(long userId) {
    this.userId = userId;
  }

  @Override
  public Category getCategory() {
    return this.category;
  }

  @Override
  public void setCategory(Category category) {
    this.category = category;
  }

  @Override
  public int getPlace() {
    return this.place;
  }

  @Override
  public void setPlace(int place) {
    this.place = place;
  }
}
