package backingbeans;

import java.io.Serializable;
import javax.enterprise.context.*;
import javax.inject.Named;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * This class acts like a view part and holds the information of the Address
 * class. The user sets the attributes in the form and the control bean will get
 * all attributes to create the class.  It only contains attributes and getters
 * and setters
 *
 * @author Patrik Thituson, Martin Augustsson, Gustaf Werlinder, Markus Schutzer
 */
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

    /**
     * The default constructor
     */
    public AddAddressBackingBean() {
    }

    /**
     * Get method for the street variable
     * @return street represented in string
     */
    public String getStreet() {
        return street;
    }
    
    /**
     * Set method for the street variable
     * @param street a string setting the street variable
     */
    public void setStreet(String street) {
        this.street = street;
    }
    /**
     * Get method for the town variable
     * @return town a string representing the costumer's town
     */
    public String getTown() {
        return town;
    }
    
    /**
     * sets the town variable
     * @param town string representing the town
     */
    public void setTown(String town) {
        this.town = town;
    }
    /**
     * Get method for the number on the street where the customer lives
     * @return number and int representing the street number
     */
    public int getNbr() {
        return nbr;
    }
    /**
     * Sets the number of the street number of the customer's address
     * @param nbr an int representing street number
     */
    public void setNbr(int nbr) {
        this.nbr = nbr;
    }
}
