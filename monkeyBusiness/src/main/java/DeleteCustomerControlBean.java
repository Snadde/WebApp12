/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thituson
 */
import core.Address;
import core.Customer;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.*;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ConversationScoped
public class DeleteCustomerControlBean implements Serializable{
    
    @Inject // Handled by system, don't need to create class.
    private Conversation conv;
    @Inject
    private AddAddressBackingBean addAddressBackingBean;
    @Inject
    private DeleteCustomerBackingBean deleteCustomerBackingBean;
    @Inject
    private CustomerRegistryBean customerRegistryBean;

    
    public DeleteCustomerControlBean(){}
        


     public String action() {
        if (!conv.isTransient()) {
            conv.end();
             Logger.getAnonymousLogger().log(Level.INFO, "CONVERSATION ENDS");
        }
        try 
        {
            Long id = deleteCustomerBackingBean.getId();
            
            customerRegistryBean.remove(id);
            return "showCustomers?faces-redirect=true"; // Go back
        } catch (Exception e) {
            // Not implemented
            //return "error?faces-redirect=true&amp;cause=" + e.getMessage();
            return null;
        }
    }   
     
    public void actionListener(ActionEvent ae) 
    { 
        Customer customer = (Customer) ae.getComponent().getAttributes().get("customer");
        if (conv.isTransient()) {
            conv.begin();
             Logger.getAnonymousLogger().log(Level.INFO, "CONVERSATION BEGINS: Got pnumb {0}", customer);
        }else{

        }
        deleteCustomerBackingBean.setId(customer.getId());
        deleteCustomerBackingBean.setFname(customer.getFname());
        deleteCustomerBackingBean.setLname(customer.getLname());
        deleteCustomerBackingBean.setEmail(customer.getEmail());
        System.out.println("FORNAMNET: " + customer.getFname());
        Address address;
        address = customer.getAddress();
        deleteCustomerBackingBean.setAddress(address);
    }
        
}