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
 * Customer class inspired by hajo's Customer class.
 * This class contains information about a customer object that will be saved in
 * the database upon new customer creation. This class uses An address object as
 * a field to be saved with the customer.
 * 
 * @author Patrik Thituson, Martin Augustsson, Gustaf Werlinder, Markus Schutzer
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
    
    /**
     * Default constructor
     */
    public Customer() {}

    /**
     * Constructor for customer
     * @param address customer's address
     * @param fname customer's first name
     * @param lname customer's last name
     * @param email customer's email
     * @param userName customer's user name
     * @param password customer's password
     */
    public Customer(Address address, String fname,
            String lname, String email, String userName, String password) {

        this.address = address;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    /**
     * Adds a product to the user's shopping cart.
     * @param product the product to put in the cart object pertatining to the
     * customer
     */
    public void addProductToCart(Product product) {
        cart.add(product);
    }

    /**
     * Removes a product from the customer's cart
     * @param product the product to remove from the cart that the customer holds
     */
    public void removeProductFromCart(Product product) {
        cart.remove(product);
    }

    /**
     * Creates a purchase order from the products in a customer's cart after 
     * shopping is done.
     * @return the purchase order after creation
     */
    public PurchaseOrder finishShopping() {
        PurchaseOrder po = new PurchaseOrder(this);
        cart = null;
        return po;
    }

    /**
     * Will empty the cart without saving anything.
     */
    public void cancelShopping() {
        cart = new Cart();
    }

    /**
     * Get method for the customer's address
     * @return address the customer's address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Get method for the customer's cart
     * @return cart the cart that the customer currently holds
     */
    public Cart getCart() {
        return cart;
    }
    
    /**
     * Set method for customer's cart
     * @param cart sets this cart to the designated customer
     */
    public void setCart(Cart cart) {
        this.cart = cart;
    }    

    /**
     * Get method for user email
     * @return the customer's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Get method for customer's first name
     * @return fname the customer's first name
     */
    public String getFname() {
        return fname;
    }

    /**
     * Get method for customer's last name
     * @return lname the last name of the customer
     */
    public String getLname() {
        return lname;
    }
    
    /**
     * Get method for the customer's user name
     * @return userName the customer's user name
     */
    public String getUserName() {
        return userName; 
    }

    /**
     * Set method for customer's user name
     * @param username the user name to be used by the customer
     */
   public void setUserName(String username) {
       this.userName = username; 
   }

   /**
    * Set method for customer's password
    * @param password the password to be used by the customer
    */
   public void setPassword(String password) {
       this.password = password; 
   }

   /**
    * Get method for user's password
    * @return password the password in use by the customer
    */
    public String getPassword() {
        return password;
    }
   
    /**
     * Overrides the toString method to represent the customer in a custom way
     * @return string representing the customer
     */
    @Override
    public String toString() {
        return "Customer{" + "user name"+userName + ", address=" + address + ", fname=" + fname + ", lname=" + lname + ", email=" + email + '}';
    }        
    
    /**
     * Puts the customer in a group detailing his or hers rights
     * @param group the group customer can belong to. as of now: customer or admin
     */
    public void addGroup(Group group) {
        groups.add(group);
    }
    
    /**
     * Removes the customer from a group with rights
     * @param group the group to remove the customer from
     */
    public void removeGroup(Group group) {
        groups.remove(group);
    }

    /**
     * The possible groups a user can belong to
     * @return list of groups a user can be a member of
     */
    public List<Group> getGroups() {
        return groups;
    }

    /**
     * Set method for customer's address
     * @param address the address of a customer
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Set method for customer's first name
     * @param fname the customer's first name
     */
    public void setFname(String fname) {
        this.fname = fname;
    }

    /**
     * Set method for user's last name
     * @param lname the last name of customer
     */
    public void setLname(String lname) {
        this.lname = lname;
    }

    /**
     * Set method for user's email
     * @param email the email belonging to a customer
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * When we override equals we must override hashCode
     * @return hash the custom hash code
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.userName);
        return hash;
    }

    /**
     * Overrided equals method that compares two customer's usernames to see if
     * they're equal, this has to be done since no two users should be able to 
     * have the same user names and generated id would be insufficient.
     * 
     * @param obj the object to compare
     * @return true if equals
     */
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
