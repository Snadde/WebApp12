package controlbeans;

/**
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

@Named
@SessionScoped
public class CustomersControlBean implements Serializable{
    @Inject
    private CustomerRegistryBean customerRegistryBean;
    
    public CustomersControlBean(){}
    
    public void add(Customer customer)
    {
        customerRegistryBean.add(customer);
    }
    
 
    public List<Customer> getAll() {
        return customerRegistryBean.getAll();
    }
        
    
    
    
}
