package controlbeans;

import backingbeans.CustomerPurchaseOrdersBackingBean;
import core.Customer;
import core.OrderItem;
import core.PurchaseOrder;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import modelbeans.CartModelBean;
import modelbeans.OrderBookModelBean;
import monkeybusiness.SimpleLogin;

/**
 *This class is a control bean that prepares the saves the purchase orders
 * to the database. Also checking if the purchase order is empty before
 * saving it to database.
 * 
 * @author Gustaf Werlinder
 */
@Named
@SessionScoped
public class CompletePurchaseControlBean implements Serializable {

    @Inject
    private CustomerPurchaseOrdersBackingBean completePurchaseBackingBean;
    @Inject
    private SimpleLogin simpleLogin;
    @Inject
    private OrderBookModelBean orderBookModelBean;
    @Inject
    private CustomerPurchaseOrdersControlBean customerPurchaseOrdersControlBean;
    @Inject
    private CustomerShowPurchaseOrderControlBean customerShowPurchaseOrderControlBean; 
    @Inject
    private CartModelBean cartModelBean;
    @Inject
    private CartControlBean cartControlBean;        
    private PurchaseOrder purchaseOrder;
    private Customer customer;

    public void completePurchaseOrder() {
    }

    /**
     * Gets the customer that is logged in and set customers cart so it refers
     * to the cartModelBean that is assosiated with the session.
     * @param ae 
     */
    public void actionListener(ActionEvent ae) {
        String userName = (String) ae.getComponent().getAttributes().get("userName");
        customer = simpleLogin.getCustomer(userName);
        customer.setCart(cartModelBean.getCart());
    }
    
    /**
     * Makes a purchase order by calling the finishShopping in customer.
     * Checks if the purchase order is empty, if it is then we are note saving it
     * else save it to the database and make a new cart for the customer if 
     * she/he wants to buy something else.
     * 
     * @return the page that we should redirect to.
     */
    public String action()
    {
        purchaseOrder = customer.finishShopping();
        Date date = new Date();
        purchaseOrder.setDate(date);
        List<OrderItem> listOfItems = purchaseOrder.getItems();
        if (listOfItems.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage("noItems", new FacesMessage("Your cart is empty"));
            return null;
        } else {
            orderBookModelBean.addOrder(purchaseOrder);
            cartModelBean.clearCart();
            customer.setCart(cartModelBean.getCart());
                    cartControlBean.getAll();
            customerPurchaseOrdersControlBean.action(customer.getUserName());
            
            customerShowPurchaseOrderControlBean.setPurchaseOrder(purchaseOrder);
            customerShowPurchaseOrderControlBean.makeOrderitemList();
            customerShowPurchaseOrderControlBean.calculateTotalOrderCost();
            
            return "customerShowPurchaseOrder?faces-redirect=true";
        }
        
    }
}
