/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlbeans;

import backingbeans.CustomerPurchaseOrdersBackingBean;
import core.Customer;
import core.PurchaseOrder;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import modelbeans.CartModelBean;
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
    @Inject
    private CustomerPurchaseOrdersControlBean customerPurchaseOrdersControlBean;
    @Inject
    private CartModelBean cartModelBean;
    
    PurchaseOrder purchaseOrder;
    Customer customer;
    
    public void completePurchaseOrder(){}
    
    
    public void actionListener() {
        customer = simpleLogin.getCustomer();
//        System.out.println("Customer:" + customer);
        
        purchaseOrder = customer.finishShopping();
//        System.out.println("PO: " + purchaseOrder);
        orderBookModelBean.addOrder(purchaseOrder);     
//        System.out.println("PO2: " + purchaseOrder);
        cartModelBean.clearCart();
        customer.setCart(cartModelBean.getCart());
        customerPurchaseOrdersControlBean.action();

    }
    
}
