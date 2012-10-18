/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelbeans;


import core.Customer;
import core.IOrderBook;
import core.JPAShop;
import core.PurchaseOrder;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author Martin && Gustaf
 */
@Named
@ApplicationScoped
public class OrderBookModelBean {
    
    private final transient IOrderBook orderBook = JPAShop.INSTANCE.getOrderBook();
    
    public void addOrder(PurchaseOrder po)
    {
        orderBook.add(po);
    }
    
    public List<PurchaseOrder> getByCustomer(Customer c) 
    {
        return orderBook.getByCustomer(c);
    }
    
    public PurchaseOrder getById (long id)
    {
        return orderBook.find(id);
    }
}
