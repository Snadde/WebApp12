
package core;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * An order item is a product but with the added field detailing how many of 
 * that item is present inspired by hajo.
 * 
 * @author Martin Augustsson, Markus Schützer, Gustaf Werlinder och Patrik
 * Thituson
 */
@Entity
public class OrderItem implements Serializable{
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToOne
    private Product product;
    private int quantity;

  
    /**
     * Constructor
     * 
     * @param product the product that the customer has added
     * @param quantity how many of that product
     */
    OrderItem(Product product, int quantity) {
        this.quantity = quantity;
        this.product = product;
    }
    
    /**
     * Default constructor
     */
    public OrderItem() {
    }
   
    /**
     * Get method for the product part of order item
     * @return the product
     */
    public Product getProduct() {
        return product;
    }
    
    /**
     * Get method for the quantity part of an order item
     * @return the number of one product
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Overrides the toString method to make a custom string of an order item
     * @return 
     */
    @Override
    public String toString() {
        return "OrderItem{" + "product=" + product + ", quantity=" + quantity + '}';
    }

    /**
     * Get method for this order item's id
     * @return id the order item's id
     */
    public long getId() {
        return id;
    }

    /**
     * Set method for an order item's id
     * @param id the designated id for this order item
     */
    public void setId(long id) {
        this.id = id;
    }
    
    
}
