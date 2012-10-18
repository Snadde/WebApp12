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

    public AddCustomerBackingBean(){}

    /**
     *
     * @return fname
     */
    public String getFname() {
        return fname;
    }

    /**
     * Sets fname
     *
     * @param fname
     */
    public void setFname(String fname) {
        this.fname = fname;
    }

    /**
     *
     * @return lname
     */
    public String getLname() {
        return lname;
    }

    /**
     * Sets the lname
     *
     * @param lname
     */
    public void setLname(String lname) {
        this.lname = lname;
    }

    /**
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return username
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the username
     *
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
