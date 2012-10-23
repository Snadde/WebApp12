package controlbeans;

import backingbeans.CustomerPurchaseOrdersBackingBean;
import core.Customer;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import modelbeans.OrderBookModelBean;
import monkeybusiness.SimpleLogin;


/**
 * This class is a control bean that prepares the CustomerPurchaseOrdersBackingBean
 * to show the information about a specific pruchase order.
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
    
    /**
     * Get which user is calling this function, then pass it to the action method
     * @param ae 
     */
    public void actionListener(ActionEvent ae) {
        String userName = (String) ae.getComponent().getAttributes().get("userName");
        this.action(userName);
    }
    
    /**
     * Sets the customer and the list of purchase orders done by that 
     * customer to CustomerPurchaseOrdersBackingBean  
     * @param userName
     * @return the site to redirect to.
     */
    public String action(String userName) {
        
        Customer customer = simpleLogin.getCustomer(userName);
        customerPOBackingBean.setCustomer(customer);
        customerPOBackingBean.setCustomerPurchaseOrdersList(orderBookModelBean.getByCustomer(customer));
                
        return "/customers/customerPurchaseOrders?faces-redirect=true";
    } 
}
