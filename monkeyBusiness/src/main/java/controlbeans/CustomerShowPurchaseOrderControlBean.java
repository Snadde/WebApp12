package controlbeans;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author thituson
 */
import backingbeans.CustomerShowPurchaseOrderBackingBean;
import backingbeans.ShopProductsBackingBean;
import backingbeans.ShowCartBackingBean;
import core.OrderItem;
import core.Product;
import core.PurchaseOrder;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.*;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import modelbeans.CartModelBean;

@Named
@SessionScoped
public class CustomerShowPurchaseOrderControlBean implements Serializable {

//    @Inject // Handled by system, don't need to create class.
//    private Conversation conv;
    @Inject
    private CustomerShowPurchaseOrderBackingBean customerShowPurchaseOrderBackingBean;

    private List<OrderItem> orderitemsList;
    private PurchaseOrder purchaseOrder;

    public CustomerShowPurchaseOrderControlBean() {
    }

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
