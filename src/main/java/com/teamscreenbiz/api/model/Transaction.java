package com.teamscreenbiz.api.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Transaction {
  @Id
  @GeneratedValue(strategy =  GenerationType.AUTO)
  protected Long id;

  @NotNull
  @ManyToOne
  private User user;
  @NotNull
  @ManyToOne
  private Product product;
  @ManyToOne
  private Vendor vendor;
  private int price;
  private String desc;

  protected Transaction(){
    super();
  }

  public Transaction(User user, Product product, Vendor vendor, int price, String desc) {
    this.user = user;
    this.product = product;
    this.vendor = vendor;
    this.price = price;
    this.desc = desc;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public Vendor getVendor() {
    return vendor;
  }

  public void setVendor(Vendor vendor) {
    this.vendor = vendor;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
