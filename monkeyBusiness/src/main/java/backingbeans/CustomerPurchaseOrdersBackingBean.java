package backingbeans;

import core.Customer;
import core.PurchaseOrder;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Patrik Thituson, Martin Augustsson, Gustaf Werlinder, Markus Schutzer
 */
@Named
@SessionScoped
public class CustomerPurchaseOrdersBackingBean implements Serializable {

    Customer customer;
    List customerPurchaseOrdersList;
    
    /**
     * Get method for the customer
     * @return customer a customer object
     */
    public Customer getCustomer()
    {
        return customer;
    }

    /**
     * Set method for the customer
     * @param customer settings for the customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Get method for the customers purchaseorders
     * @return list of purchase orders for this customer
     */
    public List<PurchaseOrder> getCustomerPurchaseOrdersList() {
        return customerPurchaseOrdersList;
    }

    /**
     * Set method for the purchase order of the customer
     * @param customerPurchaseOrdersList a list of purchase orders to connect to this customer
     */
    public void setCustomerPurchaseOrdersList(List<PurchaseOrder> customerPurchaseOrdersList) {
        this.customerPurchaseOrdersList = customerPurchaseOrdersList;
    }
}
