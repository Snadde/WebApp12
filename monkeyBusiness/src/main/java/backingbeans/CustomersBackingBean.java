package backingbeans;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thituson
 */
import core.Customer;
import core.Product;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.*;
import javax.inject.Inject;
import javax.inject.Named;
import modelbeans.CustomerRegistryBean;

@Named("customers")
@SessionScoped
public class CustomersBackingBean implements Serializable{
    @Inject
    private CustomerRegistryBean customerRegistryBean;
    
    public CustomersBackingBean(){}
    
    public void add(Customer customer)
    {
        customerRegistryBean.add(customer);
    }
    
 
    public List<Customer> getAll() {
        return customerRegistryBean.getAll();
    }
        
    
    
    
}
