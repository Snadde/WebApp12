/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlbeans;

import backingbeans.CustomerPurchaseOrdersBackingBean;
import core.Customer;
import core.Product;
import core.PurchaseOrder;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import modelbeans.OrderBookModelBean;
import monkeybusiness.SimpleLogin;



/**
 *
 * @author Gustaf Werlinder
 */
@Named
@SessionScoped
public class CompletePurchaseControlBean implements Serializable{
    
    
    @Inject
    private CustomerPurchaseOrdersBackingBean completePurchaseBackingBean;
    @Inject
    private SimpleLogin simpleLogin;
    @Inject
    private OrderBookModelBean orderBookModelBean;
    
    PurchaseOrder purchaseOrder;
    Customer customer;
    
    public void completePurchaseOrder(){}
    
    
    public String actionListener() {
        customer = simpleLogin.getCustomer();
        System.out.println("Customer:" + customer);
        
        purchaseOrder = customer.finishShopping();
        System.out.println("PO: " + purchaseOrder);
        orderBookModelBean.addOrder(purchaseOrder);     
        System.out.println("PO2: " + purchaseOrder);
        return "customerPurchaseOrders?faces-redirect=true";

    }
    
}
