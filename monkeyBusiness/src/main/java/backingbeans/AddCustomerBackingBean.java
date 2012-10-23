package backingbeans;

/**
 * * This class acts like a view part and holds the information of the Customer
 * class. The user sets the attributes in the form and the control bean will get
 * all attributes to create the class. It only contains attributes and getters
 * and setters
 *
 * @author Patrik Thituson
 */
import core.Address;
import java.io.Serializable;
import javax.enterprise.context.*;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Named
@ConversationScoped
public class AddCustomerBackingBean implements Serializable {

    @NotNull
    @Pattern(regexp = "^[a-zA-Z]*")
    @Size(min = 1, message = "Must enter a name")
    private String fname;
    @Pattern(regexp = "^[a-zA-Z]*")
    @Size(min = 1, message = "Must enter a name")
    private String lname;
    @Size(min = 1, message = "Must enter a email")
    private String email;
    @Size(min = 1, message = "Must enter a username")
    private String userName;
    @Size(min = 1, message = "Must enter a password")
    private String password;

    /**
     * Default constructor
     */
    public AddCustomerBackingBean(){}

    /**
     * Get method for the user's first name
     * @return fname string of user's first name
     */
    public String getFname() {
        return fname;
    }

    /**
     * Sets first name of the user
     *
     * @param fname the first name of user
     */
    public void setFname(String fname) {
        this.fname = fname;
    }

    /**
     * Get method for user's last name
     * @return lname the user's last name
     */
    public String getLname() {
        return lname;
    }

    /**
     * Set method for user's last name
     *
     * @param lname the last name of the user
     */
    public void setLname(String lname) {
        this.lname = lname;
    }

    /**
     * Get method for user's email
     * @return email the user email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set method for user's email
     *
     * @param email the user's email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get method for user's username
     * @return username the username in use by customer
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the username of the user
     *
     * @param userName the username to be used by customer, used for login purposes
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Get method for user's password 
     * @return password the password in use by customer, in string from
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set method for the user's password
     *
     * @param password the designated password for the user
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
