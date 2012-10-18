package modelbeans;

import core.Customer;
import core.ICustomerRegistry;
import core.JPAShop;
import core.Product;
import java.io.Serializable;
import java.util.List;
import javax.ejb.SessionContext;
import javax.enterprise.context.*;
import javax.inject.Named;

/**
 * This class has a customer registry and acts like the model part. The custom
 * registry has the connection to the database but all the control beans uses
 * this bean to set and get data to and from the database
 *
 * @author Patrik Thituson, Gustaf Werlinder
 */
@Named
@ApplicationScoped
public class CustomerRegistryBean implements Serializable {

    private final transient ICustomerRegistry customerRegistry = JPAShop.INSTANCE.getCustomerRegistry();

    /**
     * Adds a customer if it doesn´t exist. (Checks the id, it must be unique)
     *
     * @param customer
     */
    public void add(Customer customer) {
        if (customerRegistry.find(customer.getId()) == null) {
            customerRegistry.add(customer);
        }
    }

    /**
     * Returns the customer with the same id as the parameter id
     *
     * @param id
     * @return customer
     */
    public Customer find(Long id) {
        return customerRegistry.find(id);
    }

    /**
     * Checks if the username is taken by calling the customer registry method
     * findByUserName
     *
     * @param name
     * @return true if the username is taken false otherwise
     */
    public boolean isUserNameTaken(String name) {
        if (customerRegistry.findByUserName(name) != null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Updates the customer
     *
     * @param customer
     */
    public void update(Customer customer) {
        customerRegistry.update(customer);
    }

    /**
     * Removes the customer
     *
     * @param id
     */
    public void remove(Long id) {
        customerRegistry.remove(id);
    }

    /**
     *
     * @return list of all the customers
     */
    public List<Customer> getAll() {
        return customerRegistry.getAll();
    }
    
    /**
     * Validate the login by check that useName and password match
     * @param userName
     * @param password
     * @return 
     */
    public List<Customer> validateLogin(String userName, String password) {
        return customerRegistry.validateLogin(userName, password);
    }
}
