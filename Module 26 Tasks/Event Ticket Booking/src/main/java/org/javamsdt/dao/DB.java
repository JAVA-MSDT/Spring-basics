/*
 * Copyright (c) 2023 Ahmed Samy.
 */

package org.javamsdt.dao;

import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import org.javamsdt.model.EventModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class DB {
  @Value("${db.prop}")
  private String dbProp;

  private Map<String, List<EventModel>> dbMab;

  public Map<String, List<EventModel>> getDbMab() {
    return dbMab;
  }

  public void setDbMab(Map<String, List<EventModel>> dbMab) {
    this.dbMab = dbMab;
  }


}
