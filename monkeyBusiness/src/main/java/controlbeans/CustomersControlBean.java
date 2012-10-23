package controlbeans;

import core.Customer;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.*;
import javax.inject.Inject;
import javax.inject.Named;
import modelbeans.CustomerRegistryBean;

/**
 * This class acts like the controller and is sessionscoped. It is used to get
 * the list of all customers registred and also to add more customers to the 
 * registry
 * 
 * @author Martin Augustsson, Markus Schützer, Gustaf Werlinder och Patrik
 * Thituson
 */

@Named
@SessionScoped
public class CustomersControlBean implements Serializable{
    @Inject
    private CustomerRegistryBean customerRegistryBean;
    
    public CustomersControlBean(){}
    
    /**
     * Add a customer to the database
     * @param customer 
     */
    public void add(Customer customer)
    {
        customerRegistryBean.add(customer);
    }
    
    /**
     * 
     * @return all customers in the database
     */ 
    public List<Customer> getAll() {
        return customerRegistryBean.getAll();
    }
}
