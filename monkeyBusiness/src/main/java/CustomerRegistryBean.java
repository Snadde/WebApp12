
import core.Customer;
import core.ICustomerRegistry;
import core.JPAShop;
import core.Product;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.*;



/**
 *
 * @author Patrik Thituson, Gustaf Werlinder
 */

@SessionScoped
public class CustomerRegistryBean implements Serializable {
    
    private final transient ICustomerRegistry customerRegistry = JPAShop.INSTANCE.getCustomerRegistry();
    
    public void add(Customer customer) {
        if(customerRegistry.find(customer.getId())==null)
        {
            customerRegistry.add(customer);
        }
    }
    
    public Customer find(Long id) {
        return customerRegistry.find(id);
    }

   
    public void update(Customer customer) {
        customerRegistry.update(customer);
    }

   
    public void remove(Long id) {
        customerRegistry.remove(id);
    }

   
    public List<Customer> getAll() {
        return customerRegistry.getAll();
    }
    
    
}
