package com.teamscreenbiz.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String firstname;
  private String lastname;
  private String username;
  private String password;
  private String email;
  private String address;
  private String role;
  private Long firstPhoneNumber;
  private Long secondPhoneNumber;

  protected User() {
    super();
    setRole("user");
  }

  public User(String firstname, String lastname, String username, String password) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.username = username;
    this.password = password;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public Long getFirstPhoneNumber() {
    return firstPhoneNumber;
  }

  public void setFirstPhoneNumber(Long firstPhoneNumber) {
    this.firstPhoneNumber = firstPhoneNumber;
  }

  public Long getSecondPhoneNumber() {
    return secondPhoneNumber;
  }

  public void setSecondPhoneNumber(Long secondPhoneNumber) {
    this.secondPhoneNumber = secondPhoneNumber;
  }
}
