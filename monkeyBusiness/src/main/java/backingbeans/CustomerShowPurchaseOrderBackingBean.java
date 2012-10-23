package backingbeans;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Martin Augustsson && Gustaf Werlinder
 */
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.*;
import javax.inject.Named;

@Named
@SessionScoped
public class CustomerShowPurchaseOrderBackingBean implements Serializable{
    
    private List orderitemList;
    private double totalOrderCost;
    
    /**
     * Default constructor
     */
    public CustomerShowPurchaseOrderBackingBean(){}

    /**
     * Get method for a single purchase order's item list
     * @return the item list connected to a purchase order
     */
    public List getOrderitemList() {
        return orderitemList;
    }

    /**
     * Set method for the list of order items
     * @param orderitemList a list of order items
     */
    public void setOrderitemList(List orderitemList) {
        this.orderitemList = orderitemList;
    }

    /**
     * Get method for the total cost of all order items in a purchase order
     * @return totalOrderCost the cost of the order items
     */
    public double getTotalOrderCost() {
        return totalOrderCost;
    }
    
    /**
     * Set method for the total cost of the items in the orderItemList
     * @param totalOrderCost double representing total cost
     */
    public void setTotalOrderCost(double totalOrderCost) {
        this.totalOrderCost = totalOrderCost;
    }
}
