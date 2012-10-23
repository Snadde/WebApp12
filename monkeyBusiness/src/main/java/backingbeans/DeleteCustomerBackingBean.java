package backingbeans;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thituson
 */
import core.Address;
import java.io.Serializable;
import javax.enterprise.context.*;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Named
@ConversationScoped
public class DeleteCustomerBackingBean implements Serializable{
    
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
    
    /**
     * Default constructor
     */
    public DeleteCustomerBackingBean(){}

    /**
     * Get method for user's user name
     * @return the username in use by a certain customer
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Set method for the customer's user name
     * @param userName the user name for this customer to use
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    /**
     * Get method of this customer's first name
     * @return fname the user's first name
     */
    public String getFname() {
        return fname;
    }

    /**
     * Set method for the user's first name
     * @param fname customers first name
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
     * Set method for the customer's last name
     * @param lname the customer's last name
     */
    public void setLname(String lname) {
        this.lname = lname;
    }

    /**
     * Get method for customer's email address
     * @return email the users email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set method for customer's email address
     * @param email the email address to be used by the customer
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get method for the customer's address
     * @return address an object containing information about customer's address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Set method for the customer's address
     * @param address Address object containing information about the customer's address
     */
    public void setAddress(Address address) {
        this.address = address;
    }     
}
