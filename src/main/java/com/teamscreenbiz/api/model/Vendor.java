package com.teamscreenbiz.api.model;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Vendor {
  @Id
  @GeneratedValue(strategy =  GenerationType.AUTO)
  protected Long id;
  @NotNull
  private String name;
  private String address;
  private Long phoneNumber;
  private int[] rating = new int[6];
  private int finalRating;
  private String desc;
  @ManyToMany
  private List<Product> products;
  @OneToMany
  private List<Transaction> transactions;

  protected Vendor(){
    super();
    products = new ArrayList<>();
    transactions = new ArrayList<>();
  }

  public Vendor(String name, String address, Long phoneNumber, int[] rating, int finalRating,
                String desc) {
    this.name = name;
    this.address = address;
    this.phoneNumber = phoneNumber;
    this.rating = rating;
    this.finalRating = finalRating;
    this.desc = desc;
  }

  public List<Transaction> getTransactions() {
    return transactions;
  }

  public void addTransaction(Transaction transaction) {
    transactions.add(transaction);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Long getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(Long phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public int[] getRating() {
    return rating;
  }

  public void setRating(int[] rating) {
    this.rating = rating;
  }

  public int getFinalRating() {
    return finalRating;
  }

  public void setFinalRating(int finalRating) {
    this.finalRating = finalRating;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public List<Product> getProduct() {
    return products;
  }

  public void addProduct(Product product) {
    products.add(product);

  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
