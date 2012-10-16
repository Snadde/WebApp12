package backingbeans;

import core.Address;
import core.Customer;
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
    
    
    //Hela klassen är provisorisk och måste göras om. /Gustaf
    
    public Customer getCustomer()
    {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
}

