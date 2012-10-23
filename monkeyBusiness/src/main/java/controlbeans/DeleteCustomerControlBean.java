package controlbeans;

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

/**
 * @author Martin Augustsson, Markus Schützer, Gustaf Werlinder och Patrik
 * Thituson
 */
@Named
@ConversationScoped
public class DeleteCustomerControlBean implements Serializable {

    @Inject // Handled by system, don't need to create class.
    private Conversation conv;
    @Inject
    private AddAddressBackingBean addAddressBackingBean;
    @Inject
    private DeleteCustomerBackingBean deleteCustomerBackingBean;
    @Inject
    private CustomerRegistryBean customerRegistryBean;

    public DeleteCustomerControlBean() {
    }

    /**
     * Deletes the customer from the registry
     * @return to showCustomers if the delete was success
     */
    public String action() {
        if (!conv.isTransient()) {
            conv.end();
            Logger.getAnonymousLogger().log(Level.INFO, "CONVERSATION ENDS");
        }
        try {
            String userName = deleteCustomerBackingBean.getUserName();
            customerRegistryBean.remove(userName);
            return "showCustomers?faces-redirect=true"; // Go back
        } catch (Exception e) {
            // Not implemented
            //return "error?faces-redirect=true&amp;cause=" + e.getMessage();
            return null;
        }
    }

    /**
     * Prepares the DeleteCustomerBackingBean with data to show which
     * customer the admin is deleting
     * 
     * @param ae 
     */
    public void actionListener(ActionEvent ae) {
        Customer customer = (Customer) ae.getComponent().getAttributes().get("customer");
        if (conv.isTransient()) {
            conv.begin();
            Logger.getAnonymousLogger().log(Level.INFO, "CONVERSATION BEGINS: Got customer {0}", customer);
        } else {
        }
        
        deleteCustomerBackingBean.setFname(customer.getFname());
        deleteCustomerBackingBean.setLname(customer.getLname());
        deleteCustomerBackingBean.setEmail(customer.getEmail());
        deleteCustomerBackingBean.setUserName(customer.getUserName());
        Address address;
        address = customer.getAddress();
        deleteCustomerBackingBean.setAddress(address);
    }
}