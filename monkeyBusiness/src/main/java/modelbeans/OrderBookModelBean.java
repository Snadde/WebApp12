package modelbeans;

import core.Customer;
import core.IOrderBook;
import core.JPAShop;
import core.PurchaseOrder;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 * This class has a Order book and acts like the model part. The order book
 * has the connection to the database but all the control beans uses
 * this bean to set and get data to and from the database
 *
 * @author Martin Augustsson & Gustaf Werlinder
 */

@Named
@ApplicationScoped
public class OrderBookModelBean {
    
    private final transient IOrderBook orderBook = JPAShop.INSTANCE.getOrderBook();
    
    /**
     * Add a Purchase Order to the Order Book
     * @param po 
     */
    public void addOrder(PurchaseOrder po)
    {
        orderBook.add(po);
    }
    
    /**
     * Get all Purchase orders made by the same customer
     * @param c
     * @return a list of Purchase Orders 
     */
    public List<PurchaseOrder> getByCustomer(Customer c) 
    {
        return orderBook.getByCustomer(c);
    }
    
    /**
     * Get a Purchase Order by it's ID
     * @param id
     * @return a purchase order
     */
    public PurchaseOrder getById (long id)
    {
        return orderBook.find(id);
    }
}
