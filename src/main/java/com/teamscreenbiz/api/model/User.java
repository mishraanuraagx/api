package com.teamscreenbiz.api.model;




import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User {
//  public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();
  public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
      Pattern.compile(
          "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
          Pattern.CASE_INSENSITIVE);

  @Id
  @GeneratedValue(strategy =  GenerationType.AUTO)
  protected Long id;

  @NotNull
  @Size(min = 5, max = 20)
  private String firstName;
  @Size(max = 20)
  private String lastName;
  @NotNull
  @Size(min = 5, max = 20)
  @Column(unique = true)
  private String username;
  @Size(max = 100)
  private String address;
  @NotNull
//  @JsonIgnore
  @Size(min = 5, max = 16)
  private String password;
//  @JsonIgnore //TODO max: set this to default users
  private String[] roles = new String[]{"User"};
  boolean emailConfirmed;
  //TODO max: not working validation moved on to other tables for now
  @Size(min = 3, max = 321)
  private String email;
//  @JsonProperty(required = true)
  boolean firstPhoneNumberConfirmed;
//  @Size(max = 10)
//  TODO max: still some issue for size property
  private Long firstPhoneNumber;
  boolean secondPhoneNumberConfirmed;
//  TODO max: check for hypenated mobile number
  private Long secondPhoneNumber;
  @OneToMany(mappedBy = "user")
  private List<Transaction> transactions;


  protected User() {
    super();
    transactions = new ArrayList<>();
    setRoles(new String[]{"User"});
  }

  public User(String firstName, String lastName, String username,
              String password){
    this.firstName = firstName;
    this.lastName = lastName;
    this.username = username;
    setPassword(password);
  }

  public List<Transaction> getTransactions() {
    return transactions;
  }

  public void addTransaction(Transaction transaction) {
    transactions.add(transaction);
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

//  @JsonIgnore
  protected String getPassword() {
    return password;
  }

  public void setPassword(String password) {
//    this.password = PASSWORD_ENCODER.encode(password);
    this.password=password;
  }

  public String[] getRoles() {
    return roles;
  }

  public void setRoles(String[] roles) {
    this.roles = roles;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public boolean isEmailConfirmed() {
    return emailConfirmed;
  }

  public void setEmailConfirmed(boolean emailConfirmed) {
    this.emailConfirmed = emailConfirmed;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    if (validate(email)) {
      this.email = email;
      //TODO max: set message for successfull email update
    }


  }


  public static boolean validate(String emailStr) {
    Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
    return matcher.find();
  }

  public Long getFirstPhoneNumber() {
    return firstPhoneNumber;
  }

  public void setFirstPhoneNumber(Long firstPhoneNumber) {
    this.firstPhoneNumber = firstPhoneNumber;
  }

  public boolean isFirstPhoneNumberConfirmed() {
    return firstPhoneNumberConfirmed;
  }

  public void setFirstPhoneNumberConfirmed(boolean firstPhoneNumberConfirmed) {
    this.firstPhoneNumberConfirmed = firstPhoneNumberConfirmed;
  }

  public boolean isSecondPhoneNumberConfirmed() {
    return secondPhoneNumberConfirmed;
  }

  public void setSecondPhoneNumberConfirmed(boolean secondPhoneNumberConfirmed) {
    this.secondPhoneNumberConfirmed = secondPhoneNumberConfirmed;
  }

  public Long getSecondPhoneNumber() {
    return secondPhoneNumber;
  }

  public void setSecondPhoneNumber(Long secondPhoneNumber) {
    this.secondPhoneNumber = secondPhoneNumber;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
