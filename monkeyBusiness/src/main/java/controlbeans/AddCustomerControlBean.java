package controlbeans;

/**
 * This class acts like the controller and is conversationScoped. It starts a
 * conversation to get all the attributes from the backing bean (view par). It
 * checks so the username isn´t in use before it ends the conversation and sends
 * an add request to the customer registry bean. If the username is in use it
 * sends back a message and the attributes is still in the form because the
 * conversation is not ended.
 *
 * @author Patrik Thituson
 */
import backingbeans.AddAddressBackingBean;
import backingbeans.AddCustomerBackingBean;
import core.Address;
import core.Customer;
import core.Product;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.*;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import modelbeans.CustomerRegistryBean;

@Named
@ConversationScoped
public class AddCustomerControlBean implements Serializable {

    @Inject 
    private Conversation conv;
    @Inject
    private AddAddressBackingBean addAddressBackingBean;
    @Inject
    private AddCustomerBackingBean addCustomerBackingBean;
    @Inject
    private CustomerRegistryBean customerRegistryBean;

    public AddCustomerControlBean() {
    }

    /**
     * Starts a conversation and gets the username to check that it is not
     * taken, if it is the method returns null and sets a message. The form is
     * still filled in except the password. If the username is available it gets
     * all attributes form the backing bean and creates a new customer which it
     * sends to the custom registry bean to add it and redirect the user to shopProducts site.
     *
     * @return the page which to be redirected or null if the username already
     * exist, which means that it stays on the same page with the form filled
     */
    public String action() {
        if (conv.isTransient()) {
            conv.begin();
            Logger.getAnonymousLogger().log(Level.INFO, "CONVERSATION BEGINS: Got pnumb {0}");
        } else {
        }

        String userName = addCustomerBackingBean.getUserName();
        if (customerRegistryBean.isUserNameTaken(userName)) {
            FacesContext.getCurrentInstance().addMessage("regForm:username", new FacesMessage("Username is already in use"));
            return null;

        }
        String town = addAddressBackingBean.getTown();
        String street = addAddressBackingBean.getStreet();
        int nbr = addAddressBackingBean.getNbr();
        Address address = new Address(street, nbr, town);
        String fname = addCustomerBackingBean.getFname();
        String lname = addCustomerBackingBean.getLname();
        String email = addCustomerBackingBean.getEmail();
        String password = addCustomerBackingBean.getPassword();

        if (!conv.isTransient()) {
            conv.end();
            Logger.getAnonymousLogger().log(Level.INFO, "CONVERSATION ENDS");
        }

        Customer customer = new Customer(address, fname, lname, email, userName, password);
        customerRegistryBean.add(customer);
        return "shopProducts?faces-redirect=true";
    }
}
