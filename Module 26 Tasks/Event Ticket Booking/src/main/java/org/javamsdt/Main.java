/*
 * Copyright (c) 2023 Ahmed Samy.
 */

package org.javamsdt;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.javamsdt.config.ApplicationConfig;
import org.javamsdt.dao.DB;
import org.javamsdt.model.Event;
import org.javamsdt.model.EventModel;
import org.javamsdt.model.User;
import org.javamsdt.model.impl.EventImpl;
import org.javamsdt.model.impl.UserImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.w3c.dom.ls.LSOutput;

public class Main {
  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
    ApplicationConfig config = context.getBean(ApplicationConfig.class);
    DB db = context.getBean(DB.class);


    Map<String, List<EventModel>> temp = new HashMap<>();
    db.setDbMab(temp);
    Map<String, List<EventModel>> dbMab = db.getDbMab();
    User user = new UserImpl();
    user.setId(1);
    user.setName("User One");
    user.setEmail("Email");
    System.out.println("User" + user);
    List<EventModel> users = new ArrayList<>();
    users.add(user);
    System.out.println("Users Size:: " + users.size());

    Event event = new EventImpl();
    event.setId(1);
    event.setTitle("Event One");
    event.setDate(new Date());

    List<EventModel> events = new ArrayList<>();
    events.add(event);
    temp.put("User", users);
    temp.put("Event", events);
    System.out.println("Db Size:: " + dbMab.size());
    System.out.println(db.getDbProp());
    System.out.println(config.getValue());
    System.out.println("Hello world!");

    dbMab.keySet().forEach(System.out::println);
    dbMab.entrySet().forEach(System.out::println);
  }
}
