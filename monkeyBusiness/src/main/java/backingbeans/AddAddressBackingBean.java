package backingbeans;

/**
 * This class acts like a view part and holds the information of the Address
 * class. The user sets the attributes in the form and the control bean will get
 * all attributes to create the class.  It only contains attributes and getters
 * and setters
 *
 * @author Patrik Thituson
 */
import java.io.Serializable;
import javax.enterprise.context.*;
import javax.inject.Named;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Named
@ConversationScoped
public class AddAddressBackingBean implements Serializable {

    @NotNull
    @Pattern(regexp = "^[a-zA-Z]*")
    @Size(min = 1, max = 20, message = "Must use 1-20 chars")
    private String street;
    @NotNull
    @Pattern(regexp = "^[a-zA-Z]*")
    @Size(min = 1, max = 20, message = "Must use 1-20 chars")
    private String town;
    @NotNull
    @Min(value = 1, message = "To small")
    @Max(value = 10000, message = "To big")
    private int nbr;

    public AddAddressBackingBean() {
    }

    /**
     *
     * @return street
     */
    public String getStreet() {
        return street;
    }
    /**
     * Sets the street
     * @param street 
     */
    public void setStreet(String street) {
        this.street = street;
    }
    /**
     * 
     * @return town
     */
    public String getTown() {
        return town;
    }
    /**
     * sets the town
     * @param town 
     */
    public void setTown(String town) {
        this.town = town;
    }
    /**
     * 
     * @return number
     */
    public int getNbr() {
        return nbr;
    }
    /**
     * Sets the number
     * @param nbr 
     */
    public void setNbr(int nbr) {
        this.nbr = nbr;
    }
}
