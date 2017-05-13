package com.teamscreenbiz.api.model;




import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Product {
  @Id
  @GeneratedValue(strategy =  GenerationType.AUTO)
  protected Long id;

  @NotNull
  private String name;
  @ManyToOne
  private MobileModel mobileModel;
  //TODO max: Create an ENUM classs later
  private final static String problem = "Screen Replace";
  private double rating;
  private int priceLowBound;
  private int priceHighBound;
  private int profit;
  @ManyToMany(fetch = FetchType.EAGER,mappedBy = "products")
  private List<Vendor> vendors;

  @OneToMany(fetch = FetchType.EAGER,mappedBy = "product")
  private List<Transaction> transactions;


  public Product(){
    super();
  }

  public Product(String name, double rating) {
    this.name = name;
    this.rating = rating;
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


  public MobileModel getMobileModel() {
    if(mobileModel == null){
      return null;
    }
    return mobileModel;
  }

  public void setMobileModel(MobileModel mobileModel) {
    this.mobileModel = mobileModel;
    mobileModel.addProducts(this);
  }

  public List<Vendor> getVendors() {
    return vendors;
  }
  public void addVendor(Vendor vendor){

    if(vendors == null){
      vendors = new ArrayList<>();
    }
    vendors.add(vendor);
    vendor.addProduct(this);
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getProblem() {
    return problem;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public double getRating() {
    return rating;
  }

  public void setRating(double rating) {
    this.rating = rating;
  }

  public int getPriceLowBound() {
    return priceLowBound;
  }

  public void setPriceLowBound(int priceLowBound) {
    this.priceLowBound = priceLowBound;
  }

  public int getPriceHighBound() {
    return priceHighBound;
  }

  public void setPriceHighBound(int priceHighBound) {
    this.priceHighBound = priceHighBound;
  }

  public int getProfit() {
    return profit;
  }

  public void setProfit(int profit) {
    this.profit = profit;
  }
}
