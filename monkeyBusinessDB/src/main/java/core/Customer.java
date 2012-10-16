package core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.management.relation.Role;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author hajo
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="CUSTOMER")

public class Customer implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private transient Cart cart = new Cart();
    @Embedded
    private  Address address;
    private  String fname;
    private  String lname;
    private  String email;
    private  String userName;
    private  String password;
    private  boolean isAdmin = false;
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "CUSTOMER_GROUP")
    @Enumerated(EnumType.STRING)
    private final List<Group> groups = new ArrayList<>();
    
            
    public Customer() {}

    public Customer(Long id, Address address, String fname,
            String lname, String email, String userName, String password) {
        this.id = id;
        this.address = address;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    public Customer(Address address, String fname,
            String lname, String email, String userName, String password) {
        // For now. Later database will generate id
        //this.id = new Long(new Random().nextInt(100));
        this.address = address;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    public void addProductToCart(Product product) {
        cart.add(product);
    }

    public void removeProductFromCart(Product product) {
        cart.remove(product);
    }

    public PurchaseOrder finishShopping() {
        PurchaseOrder po = new PurchaseOrder(this);
        cart = null;
        return po;
    }

    public void cancelShopping() {
        cart = new Cart();
    }

    public Address getAddress() {
        return address;
    }

    public Cart getCart() {
        return cart;
    }
    
    public void setCart(Cart cart) {
        this.cart = cart;
    }    

    public String getEmail() {
        return email;
    }

    public String getFname() {
        return fname;
    }

    public Long getId() {
        return id;
    }

    public String getLname() {
        return lname;
    }
    public String getUserName() {
        return userName; 
    }

   public void setUserName(String username) {
       this.userName = username; 
   }

   public void setPassword(String password) {
       this.password = password; 
   }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", address=" + address + ", fname=" + fname + ", lname=" + lname + ", email=" + email + '}';
    }        
     public void addGroup(Group group) {
        groups.add(group);
    }
    public void removeGroup(Group group) {
        groups.remove(group);
    }

    public List<Group> getGroups() {
        return groups;
    }
}
