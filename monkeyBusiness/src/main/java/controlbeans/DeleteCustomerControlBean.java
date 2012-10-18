package controlbeans;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thituson
 */
import backingbeans.AddAddressBackingBean;
import backingbeans.DeleteCustomerBackingBean;
import core.Address;
import core.Customer;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.*;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import modelbeans.CustomerRegistryBean;

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
            String userName = deleteCustomerBackingBean.getUserName();
            
            customerRegistryBean.remove(userName);
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
//        deleteCustomerBackingBean.setId(customer.getId());
        deleteCustomerBackingBean.setFname(customer.getFname());
        deleteCustomerBackingBean.setLname(customer.getLname());
        deleteCustomerBackingBean.setEmail(customer.getEmail());
        deleteCustomerBackingBean.setUserName(customer.getUserName());
        Address address;
        address = customer.getAddress();
        deleteCustomerBackingBean.setAddress(address);
    }
        
}