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
 * A purchase order
 *
 * @author hajo
 */
@Entity
public class PurchaseOrder  implements Serializable {

    public enum State {  
        ACCEPTED,
        CANCELED,
        INVOICED,
        UNINVOIDED,
        SHIPPED,}
    
    // For now. Later database will generate id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ; //= new Long(new Random().nextInt(100));
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @OneToMany(fetch= FetchType.EAGER, cascade={CascadeType.PERSIST, CascadeType.REMOVE})
    private  List<OrderItem> items;
    @ManyToOne//( cascade={CascadeType.REFRESH},fetch = FetchType.EAGER)
    //@JoinColumn(name = "CUSTOMER_ID")
    private  Customer customer;
    private State state = State.ACCEPTED;

    public PurchaseOrder() {
    }

    /**
     * 
     * @param customer 
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
     * 
     * @return date when purchase order was created
     */
    public Date getDate() {
        return date;
    }
    
    /**
     * 
     * @param date 
     *      the date when customer order is created
     */
    public void setDate(Date date)
    {   this.date = new Date();
        this.date = date;
    }

    /**
     * 
     * @return a List of the items in the Purchase order
     */
    public List<OrderItem> getItems() {
        return items;
    }

    /**
     * 
     * @return the customer that made the Purchase order
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * 
     * @return the state that tells if the purchase order i.e. accepted,
     * canceled, invoiced, uninvoiced or shipped.
     */
    public State getState() {
        return state;
    }

    /**
     * 
     * @return id of the purchase order
     */
    public Long getId() {
        return id;
    }

    /**
     * 
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
