package core;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author hajo
 */
@Embeddable
public class Address implements Serializable {

    private String street;
    private int nbr;
    private String town;
    
    public Address(){}
    
    public Address(String street, int nbr, String town) {
        this.street = street;
        this.nbr = nbr;
        this.town = town;
    }

    public int getNbr() {
        return nbr;
    }

    public String getStreet() {
        return street;
    }

    public String getTown() {
        return town;
    }

    @Override
    public String toString() {
        return "Address{" + "street=" + street + ", nbr=" + nbr + ", town=" + town + '}';
    }
    
    
}
