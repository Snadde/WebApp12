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
    
    public CustomerShowPurchaseOrderBackingBean(){}

    public List getOrderitemList() {
        return orderitemList;
    }

    public void setOrderitemList(List orderitemList) {
        this.orderitemList = orderitemList;
    }

    public double getTotalOrderCost() {
        return totalOrderCost;
    }

    public void setTotalOrderCost(double totalOrderCost) {
        this.totalOrderCost = totalOrderCost;
    }
}