package com.teamscreenbiz.api.repository;


import com.teamscreenbiz.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long>{
  User findById(Long id);
  List<User> findAll();
}
