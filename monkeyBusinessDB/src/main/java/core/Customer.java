package core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
    private  String userName;
    private transient Cart cart = new Cart();
    @Embedded
    private  Address address;
    private  String fname;
    private  String lname;
    private  String email;
    
    private  String password;
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "CUSTOMER_GROUP")
    @Enumerated(EnumType.STRING)
    private final List<Group> groups = new ArrayList<>();
    
         
    public Customer() {}

    public Customer(Address address, String fname,
            String lname, String email, String userName, String password) {

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

    public String getPassword() {
        return password;
    }
   
    @Override
    public String toString() {

        return "Customer{" + "user name"+userName + ", address=" + address + ", fname=" + fname + ", lname=" + lname + ", email=" + email + '}';
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

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.userName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        if (!Objects.equals(this.userName, other.userName)) {
            return false;
        }
        return true;
    }
}
