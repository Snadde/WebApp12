package controlbeans;

import backingbeans.AddAddressBackingBean;
import backingbeans.EditCustomerBackingBean;
import core.Address;
import core.Customer;
import core.Group;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.*;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import modelbeans.CustomerRegistryBean;

/**
 * @author Martin Augustsson, Markus Schützer, Gustaf Werlinder och Patrik
 * Thitusonn
 */

@Named
@ConversationScoped
@RolesAllowed({"admin","customer"})
public class EditCustomerControlBean implements Serializable {

    @Inject // Handled by system, don't need to create class.
    private Conversation conv;
    @Inject
    private AddAddressBackingBean addAddressBackingBean;
    @Inject
    private EditCustomerBackingBean editCustomerBackingBean;
    @Inject
    private CustomerRegistryBean customerRegistryBean;
    private Customer customer;

    public EditCustomerControlBean() {
    }

    /**
     * Updates the customer registry with the new edited customer, gets all
     * new info from editCustomerBackingBean
     * @return the webpage that we will be redirected to
     */
    public String action() {
        if (!conv.isTransient()) {
            conv.end();
            Logger.getAnonymousLogger().log(Level.INFO, "CONVERSATION ENDS");
        }
        try {
            Address address = editCustomerBackingBean.getAddress();
            String fname = editCustomerBackingBean.getFname();
            String lname = editCustomerBackingBean.getLname();
            String email = editCustomerBackingBean.getEmail();
            Customer customer = new Customer(address, fname, lname, email, this.customer.getUserName(), this.customer.getPassword());

            if (editCustomerBackingBean.isIsAdmin()) {
                customer.addGroup(Group.ADMIN);
            } else {
                customer.addGroup(Group.CUSTOMER);
            }
            customerRegistryBean.update(customer);
            FacesContext.getCurrentInstance().addMessage("profilesaved", new FacesMessage("Profile saved"));
            return null;
        } catch (Exception e) {
            // Not implemented
            //return "error?faces-redirect=true&amp;cause=" + e.getMessage();
            return null;
        }
    }

    /**
     * Prepares the editCustomerBackingBean with info about the customer that 
     * can be edited.
     * 
     * @param ae the action event that triggered this action listner
     */
    public void actionListener(ActionEvent ae) {
        customer = (Customer) ae.getComponent().getAttributes().get("customer");
        if (conv.isTransient()) {
            conv.begin();
            Logger.getAnonymousLogger().log(Level.INFO, "CONVERSATION BEGINS: Got customer {0}", customer);
        } else {
        }
        List<Group> listOfGroups = customer.getGroups();
        for (Group group : listOfGroups) {
            if (group.equals(Group.ADMIN)) {
                editCustomerBackingBean.setIsAdmin(true);
            }
        }

        editCustomerBackingBean.setFname(customer.getFname());
        editCustomerBackingBean.setLname(customer.getLname());
        editCustomerBackingBean.setEmail(customer.getEmail());
        Address address;
        address = customer.getAddress();
        editCustomerBackingBean.setAddress(address);
    }
}