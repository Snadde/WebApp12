package backingbeans;

import core.Address;
import core.Customer;
import core.PurchaseOrder;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Gustaf
 */
@Named
@SessionScoped
public class CustomerPurchaseOrdersBackingBean implements Serializable {

    Customer customer;
    List customerPurchaseOrdersList;
    
    
    //Hela klassen är provisorisk och måste göras om. /Gustaf
    
    public Customer getCustomer()
    {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<PurchaseOrder> getCustomerPurchaseOrdersList() {
        System.out.println("BACKINGBEAN:  " + customerPurchaseOrdersList);
        return customerPurchaseOrdersList;
    }

    public void setCustomerPurchaseOrdersList(List<PurchaseOrder> customerPurchaseOrdersList) {
        this.customerPurchaseOrdersList = customerPurchaseOrdersList;
    }
}
