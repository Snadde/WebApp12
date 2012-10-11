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
import core.Product;
import java.io.Serializable;
import javax.enterprise.context.*;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class AddCustomerControlBean implements Serializable{
    @Inject
    private AddAddressBackingBean addAddressBackingBean;
    @Inject
    private AddCustomerBackingBean addCustomerBackingBean;
    @Inject
    private CustomersBackingBean customersBackingBean;
    
    public AddCustomerControlBean(){}
        
    public String action() {
        String town = addAddressBackingBean.getTown();
        String street = addAddressBackingBean.getStreet();
        int nbr = addAddressBackingBean.getNbr();
        Address address = new Address(street, nbr, town);
        String fname = addCustomerBackingBean.getFname();
        String lname = addCustomerBackingBean.getLname();
        String email = addCustomerBackingBean.getEmail();
        String userName =addCustomerBackingBean.getUserName();
        String password = addCustomerBackingBean.getPassword();
        System.out.println("HAR AR USERNAME I CONTROLBEAN: " + userName);
        Customer customer = new Customer(address, fname, lname, email, userName, password);
        customersBackingBean.add(customer);
        return "showCustomers?faces-redirect=true";
    }
    
    


    
    
    
}
