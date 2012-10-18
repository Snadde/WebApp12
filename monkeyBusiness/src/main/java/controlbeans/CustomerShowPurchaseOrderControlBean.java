package controlbeans;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Gustaf Werlinder && Martin Augustsson
 */
import backingbeans.CustomerShowPurchaseOrderBackingBean;
import core.OrderItem;
import core.PurchaseOrder;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.*;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;


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
     * 
     */
    public void makeOrderitemList() {
        orderitemsList = purchaseOrder.getItems();
        customerShowPurchaseOrderBackingBean.setOrderitemList(orderitemsList);
    }

    public void calculateTotalOrderCost() {
        double cost = 0;
        for(OrderItem o : orderitemsList)
        {
            cost += o.getProduct().getPrice() * o.getQuantity();
        }
        customerShowPurchaseOrderBackingBean.setTotalOrderCost(cost);
    }

    public void actionListener(ActionEvent ae) {

        purchaseOrder = (PurchaseOrder) ae.getComponent().getAttributes().get("purchaseOrder");
        this.makeOrderitemList();
        this.calculateTotalOrderCost();
    }
}
