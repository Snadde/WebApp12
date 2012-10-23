package core;

import java.io.Serializable;
import java.util.Map.Entry;
import java.util.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * A purchase order based on hajo's shop
 *
 * @author Martin Augustsson, Markus Schützer, Gustaf Werlinder 
 * och Patrik Thituson
 */
@Entity
public class PurchaseOrder  implements Serializable {

    public enum State {  
        ACCEPTED,
        CANCELED,
        INVOICED,
        UNINVOIDED,
        SHIPPED,}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ; 
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @OneToMany(fetch= FetchType.EAGER, cascade={CascadeType.PERSIST, CascadeType.REMOVE})
    private  List<OrderItem> items;
    @ManyToOne
    private  Customer customer;
    private State state = State.ACCEPTED;

    /**
     * Default constructor
     */
    public PurchaseOrder() {
    }

    /**
     * Makes the Purchase Order by taking the customer as a param
     * to get ref to the shoppingcart
     * @param customer the customer to get the purchase order
     */
    public PurchaseOrder(Customer customer) {
        this.customer = customer;
        items = new ArrayList<>();
        Map<Product, Integer> pf = customer.getCart().getProductFreq();
        for (Entry<Product, Integer> e : pf.entrySet()) {
            items.add(new OrderItem(e.getKey(), e.getValue()));
        }
    }

    /**
     * Get method for the date of object
     * @return date when purchase order was created
     */
    public Date getDate() {
        return date;
    }
    
    /**
     * Set method for the date when the object is created
     * @param date the date when customer order is created
     */
    public void setDate(Date date)
    {   this.date = new Date();
        this.date = date;
    }

    /**
     * Get method for a items in a customer's purchase order
     * @return a List of the items in the Purchase order
     */
    public List<OrderItem> getItems() {
        return items;
    }

    /**
     * Get method for customer that holds a purchase order
     * @return the customer that made the Purchase order
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Get method for the state
     * @return the state that tells if the purchase order i.e. accepted,
     * canceled, invoiced, uninvoiced or shipped.
     */
    public State getState() {
        return state;
    }

    /**
     * Get method for id of purchase order. Needed to link customer to purchase
     * order
     * @return id of the purchase order
     */
    public Long getId() {
        return id;
    }

    /**
     * ToString method for making a string representation of purchase order
     * @return a sting consisting of id, date, items, costumer and state
     * of the purchase order.
     */
    @Override
    public String toString() {
        return "PurchaseOrder{" + "id=" + id + ", date=" + date + 
                ", items=" + items + ", customer=" + customer + 
                ", state=" + state + '}';
    }
}
