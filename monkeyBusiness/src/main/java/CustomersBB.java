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

@Named("customers")
@SessionScoped
public class CustomersBB implements Serializable{
    @Inject
    private CustomerRegistryBean customerRegistryBean;
    
    public CustomersBB(){}
    
    @Inject
    public CustomersBB(CustomerRegistryBean customerRegistryBean){
        this.customerRegistryBean = customerRegistryBean;
    
    }

    public void add(Customer customer)
    {
        customerRegistryBean.add(customer);
    }
    
 
    public List<Customer> getAll() {
        return customerRegistryBean.getAll();
    }
        
    
    
    
}