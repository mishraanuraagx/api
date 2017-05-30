package com.teamscreenbiz.api.core;

import com.teamscreenbiz.api.model.Company;
import com.teamscreenbiz.api.model.MobileModel;
import com.teamscreenbiz.api.model.Product;
import com.teamscreenbiz.api.model.Transaction;
import com.teamscreenbiz.api.model.User;
import com.teamscreenbiz.api.model.Vendor;
import com.teamscreenbiz.api.repository.CompanyRepository;
import com.teamscreenbiz.api.repository.MobileModelRepository;
import com.teamscreenbiz.api.repository.ProductRepository;
import com.teamscreenbiz.api.repository.TransactionRepository;
import com.teamscreenbiz.api.repository.UserRepository;
import com.teamscreenbiz.api.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class DatabaseLoader implements ApplicationRunner{
  Random ram = new Random();
  @Autowired
  private final UserRepository users;
  private final MobileModelRepository mobileModelRepository;
  private final CompanyRepository companies;
  private final ProductRepository products;
  private final TransactionRepository transactions;
  private final VendorRepository vendors;



  public DatabaseLoader(UserRepository users,
                        MobileModelRepository mobileModelRepository,
                        CompanyRepository companies,
                        ProductRepository products,
                        TransactionRepository transactions,
                        VendorRepository vendors) {
    this.users = users;
    this.mobileModelRepository = mobileModelRepository;
    this.companies = companies;
    this.products = products;
    this.transactions = transactions;
    this.vendors = vendors;
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    List<User> customers =Arrays.asList(
        new User("Shubham","Wadhwa","lethal","lives"),
        new User("Harsh","Singh","hpsindia","blackout"),
        new User("Baljit","Singh","baloo","fontbhai"),
        new User("Jatin","","veryhighly","talented")
    );
    users.save(customers);
    User mishra = new User("Anuraag","Mishra","maximum","force");
    mishra.setRoles(new String[]{"Admin"});
    users.save(mishra);

    //  String companyName, String desc
    List<Company> brands = Arrays.asList(
        new Company("Apple", "Overpriced,Top-Notch"),
        new Company("Samsung", "Lost Market with last phone, hope for the best in future"),
        new Company("Mi", "Well best valued phones at low price range"),
        new Company("Motorola", "Troll"),
        new Company("Vivo", "Lol")
    );
    companies.save(brands);
    Company c = new Company("Screenbiz", "startup");
    companies.save(c);

//    List<MobileModel> mobiles = Arrays.asList(
//      new MobileModel("NOTE 4"),
//      new MobileModel("Mi 5"),
//      new MobileModel("One Plus 3"),
//      new MobileModel("iOS 8"),
//      new MobileModel("S7")
//    );
//    for(int i=0;i<mobiles.size();i++){
//      mobiles.get(i).setCompany(brands.get(ram.nextInt(brands.size())));
//    }
//    mobileModelRepository.save(mobiles);
//
//    for(int i =0;i<100;i++){
//      Product prod = new Product("product"+ram.nextInt(9999),3 + ram.nextInt(2)+((double)ram.nextInt(10)/10));
//      products.save(prod);
//      prod.setMobileModel(mobiles.get(ram.nextInt(mobiles.size())));
//    }
//
//    String[] shopName = {"Halleluyeah","mega","destroyer","Holly","Shallow","Dung","Master","Mother Of",
//    "LALALALA","Molly","Man","C'mon"};
//
//    String[] shopDesc = {"JollyBolly","BalooBhai","font","HorlicksDrinker","BlackJacksSucker"};
//
//    String[] city = {"Chandigarh","Mohali","Panchkula"};
//
//    for(int i=0;i<10;i++){
//      Vendor vendor = new Vendor(shopName[ram.nextInt(shopName.length)]+shopName[ram.nextInt(shopName.length)]);
//      vendor.setAddress("SCO - "+ram.nextInt(500)+", Sec - " + ram.nextInt(50)+" city: "
//      + city[ram.nextInt(city.length)] + ", PIN : " + ram.nextInt(17) + "00" + ram.nextInt(50));
//      for(int j=10;j<10+ram.nextInt(10);j++){
//        vendor.addProduct(products.findById((long) ram.nextInt(100)));
//      }
//      vendor.setDesc(shopName[ram.nextInt(shopName.length)]);
//      vendors.save(vendor);
//    }
//
//    for (int i=0;i<100;i++){
//      Transaction trans = new Transaction("");
//      User user = users.findById((long) ram.nextInt(4));
//      Vendor vendor = vendors.findById((long) ram.nextInt(10));
//      Product prod = products.findById((long) ram.nextInt(100));
//      transactions.save(trans);
//      trans.setProduct(prod);
//      trans.setUser(user);
//    }
//
  }
}
