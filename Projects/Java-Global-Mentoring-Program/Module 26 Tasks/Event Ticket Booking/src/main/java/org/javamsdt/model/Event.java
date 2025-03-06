package org.javamsdt.model;

import java.util.Date;

/**
 * Created by maksym_govorischev.
 */
public interface Event extends EventModel {
  /**
   * Event id. UNIQUE.
   * @return Event Id
   */
  long getId();

  void setId(long id);

  String getTitle();

  void setTitle(String title);

  Date getDate();

  void setDate(Date date);
}
