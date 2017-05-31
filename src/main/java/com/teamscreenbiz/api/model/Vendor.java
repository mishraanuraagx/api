package com.teamscreenbiz.api.model;


import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
  @ManyToMany(fetch = FetchType.EAGER)
  //TODO max: mappedBy = "products" causing error Well its a issue with owning No need to do anything
  private List<Product> products;
  @OneToMany(mappedBy = "vendor")
  private List<Transaction> transactions;

  protected Vendor(){
    super();
  }

  public Vendor(String name) {
    this.name = name;
  }

  public List<Transaction> getTransactions() {
    return transactions;
  }

  public void addTransaction(Transaction transaction) {
    if(transactions == null){
      transactions = new ArrayList<>();
    }
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
    if(products == null){
      products = new ArrayList<>();
    }
    products.add(product);

  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
