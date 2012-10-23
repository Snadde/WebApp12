package core;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 * Address class inspired by hajo's address class
 * This class contains information about an address object that is saved along
 * with a customer in the database upon creation
 * 
 * @author Patrik Thituson, Martin Augustsson, Gustaf Werlinder, Markus Schutzer
 */
@Embeddable
public class Address implements Serializable {

    private String street;
    private int nbr;
    private String town;
    
    /**
     * Default constructor
     */
    public Address(){}
    
    /**
     * Constructor for address
     * 
     * @param street string representing street
     * @param nbr int representing street number
     * @param town string representing town
     */
    public Address(String street, int nbr, String town) {
        this.street = street;
        this.nbr = nbr;
        this.town = town;
    }

    /**
     * Get method for street number
     * @return nbr an int representing the street number
     */
    public int getNbr() {
        return nbr;
    }

    /**
     * Get method for the street field in address
     * @return street the street in the address 
     */
    public String getStreet() {
        return street;
    }

    /**
     * Get method for town
     * @return town the town in the address field
     */
    public String getTown() {
        return town;
    }

    /**
     * Set method for street
     * @param street the street field in the address
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Set method for street number
     * @param nbr the street number in the address field
     */
    public void setNbr(int nbr) {
        this.nbr = nbr;
    }

    /**
     * Set method for the town in the address
     * @param town the town in address
     */
    public void setTown(String town) {
        this.town = town;
    }
    
    /**
     * Override the toString method to represent the address in a custom way
     * @return string representation of address
     */
    @Override
    public String toString() {
        return "Address{" + "street=" + street + ", nbr=" + nbr + ", town=" + town + '}';
    }
    
    
}
