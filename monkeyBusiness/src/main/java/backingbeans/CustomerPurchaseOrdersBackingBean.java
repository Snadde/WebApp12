package backingbeans;

import core.Customer;
import core.PurchaseOrder;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Gustaf Werlinder && Martin Augustsson
 */
@Named
@SessionScoped
public class CustomerPurchaseOrdersBackingBean implements Serializable {

    Customer customer;
    List customerPurchaseOrdersList;
    
    
    public Customer getCustomer()
    {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<PurchaseOrder> getCustomerPurchaseOrdersList() {
        return customerPurchaseOrdersList;
    }

    public void setCustomerPurchaseOrdersList(List<PurchaseOrder> customerPurchaseOrdersList) {
        this.customerPurchaseOrdersList = customerPurchaseOrdersList;
    }
}
