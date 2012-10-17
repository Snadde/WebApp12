package backingbeans;

import core.Address;
import core.Customer;
import core.PurchaseOrder;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Gustaf
 */
@Named
@RequestScoped
public class CustomerPurchaseOrdersBackingBean {

    Customer customer;
    List<PurchaseOrder> customerPurchaseOrders;
    
    
    //Hela klassen är provisorisk och måste göras om. /Gustaf
    
    public Customer getCustomer()
    {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<PurchaseOrder> getCustomerPurchaseOrders() {
        return customerPurchaseOrders;
    }

    public void setCustomerPurchaseOrders(List<PurchaseOrder> customerPurchaseOrders) {
        this.customerPurchaseOrders = customerPurchaseOrders;
    }
}
