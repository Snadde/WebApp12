/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlbeans;

import backingbeans.CustomerPurchaseOrdersBackingBean;
import core.Customer;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import modelbeans.OrderBookModelBean;
import monkeybusiness.SimpleLogin;


/**
 *
 * @author Gustaf Werlinder && Martin Augustsson
 */
@Named
@SessionScoped
public class CustomerPurchaseOrdersControlBean implements Serializable{
    
    @Inject
    private SimpleLogin simpleLogin;
    @Inject
    private OrderBookModelBean orderBookModelBean;
    @Inject
    private CustomerPurchaseOrdersBackingBean customerPOBackingBean;

    
    public void CustomerPurcchaseOrdersControlBean(){}
        
    public void actionListener() {
        this.action();
    }
    
    public String action(){
        Customer customer = simpleLogin.getCustomer();
        customerPOBackingBean.setCustomer(customer);
        customerPOBackingBean.setCustomerPurchaseOrdersList(orderBookModelBean.getByCustomer(customer));
                
        return "customerPurchaseOrders?faces-redirect=true";
    } 
    
}
