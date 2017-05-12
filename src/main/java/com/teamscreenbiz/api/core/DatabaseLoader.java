package com.teamscreenbiz.api.core;

import com.teamscreenbiz.api.model.User;
import com.teamscreenbiz.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DatabaseLoader implements ApplicationRunner{
  @Autowired
  private UserRepository users;

  public DatabaseLoader(UserRepository users) {
    this.users = users;
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    List<User> customers =Arrays.asList(
        new User("Anuraag","Mishra","max","death"),
        new User("Harsh","Singh","hps","blackout")
    );
    users.save(customers);
  }

}
