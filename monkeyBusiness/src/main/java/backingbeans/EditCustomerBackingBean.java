package backingbeans;

import core.Address;
import java.io.Serializable;
import javax.enterprise.context.*;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author Patrik Thituson, Martin Augustsson, Gustaf Werlinder, Markus Schutzer
 */
@Named
@SessionScoped
public class EditCustomerBackingBean implements Serializable{
    
    @Inject // Handled by system, don't need to create class.
    private Conversation conv;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z]*")
    @Size(min = 1, message = "Must enter a name")
    private  String fname;
    @Pattern(regexp = "^[a-zA-Z]*")
    @Size(min = 1, message = "Must enter a name")
    private  String lname;
    private  String email;
    private  Address address;
    private String userName;
    private String password;
    private boolean isAdmin;
    
    /**
     * Default constructor
     */
    public EditCustomerBackingBean(){}
        
    /**
     * Get method for customer's first name
     * @return fname customer's first name
     */
    public String getFname() {
        return fname;
    }

    /**
     * Set method for customer's first name
     * @param fname the customer's first name 
     */
    public void setFname(String fname) {
        this.fname = fname;
    }
    
    /**
     * Get method for customer's last name
     * @return lname the customer's last name
     */
    public String getLname() {
        return lname;
    }
    
    /**
     * Set method for customer's last name
     * @param lname the customer's last name
     */
    public void setLname(String lname) {
        this.lname = lname;
    }
    
    /**
     * Get method for the customer's email address
     * @return email the customer's email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set method for the customer's email address
     * @param email the customer's email address
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get method for the user's address
     * @return address the user's address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Set method for the user's address
     * @param address the user's address
     */
    public void setAddress(Address address) {
        this.address = address;
    }  
    
    /**
     * Get method for the customer's user name
     * @return userName the customer's user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Set method for the customer's user name
     * @param userName the customer's user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Get method for customer's password
     * @return password the password in use by customer
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set method for the the customer's password
     * @param password the password in use by customer
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get method for if the the user is admin or not
     * @return true if user is admin
     */
    public boolean isIsAdmin() {
        return isAdmin;
    }

    /**
     * Set method for user's status, admin or not
     * @param isAdmin if true the user will become and admin
     */
    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    
}
