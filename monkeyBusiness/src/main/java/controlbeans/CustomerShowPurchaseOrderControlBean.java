package controlbeans;

import backingbeans.CustomerShowPurchaseOrderBackingBean;
import core.OrderItem;
import core.PurchaseOrder;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.*;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * This class is a control bean that prepares the CustomerShowPurchaseOrderBackingBean
 * to show the information about a specific pruchase order.
 * 
 * @author Martin Augustsson, Markus Schützer, Gustaf Werlinder och Patrik
 * Thituson
 */

@Named
@SessionScoped
public class CustomerShowPurchaseOrderControlBean implements Serializable {

    @Inject
    private CustomerShowPurchaseOrderBackingBean customerShowPurchaseOrderBackingBean;

    private List<OrderItem> orderitemsList;
    private PurchaseOrder purchaseOrder;

    public CustomerShowPurchaseOrderControlBean() {
    }
    
    /**
     * Gets the list of items from the purchase order and sets OrderitemList in
     * customerShowPurchaseOrderBackingBean
     */
    public void makeOrderitemList() {
        orderitemsList = purchaseOrder.getItems();
        customerShowPurchaseOrderBackingBean.setOrderitemList(orderitemsList);
    }
    
    /**
     * Calculate total order cost and set it in  
     * customerShowPurchaseOrderBackingBean
     */
    public void calculateTotalOrderCost() {
        double cost = 0;
        for(OrderItem o : orderitemsList)
        {
            cost += o.getProduct().getPrice() * o.getQuantity();
        }
        customerShowPurchaseOrderBackingBean.setTotalOrderCost(cost);
    }

    /**
     * Gets which purchase order is clicked and call methods that 
     * prepares the customerShowPurchaseOrderBackingBean
     * @param ae 
     */
    public void actionListener(ActionEvent ae) {

        purchaseOrder = (PurchaseOrder) ae.getComponent().getAttributes().get("purchaseOrder");
        this.makeOrderitemList();
        this.calculateTotalOrderCost();
    }

    /**
     * Sets the local Purchase Order
     * @param purchaseOrder 
     */
    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }
    
}
