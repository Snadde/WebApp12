
package core;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 * CustomerRegistry class inspired by hajo's CustomerRegistry class.
 * This class implements some functions to the customer registry part of
 * the database
 * 
 * @author Patrik Thituson, Martin Augustsson, Gustaf Werlinder, Markus Schutzer
 */
public final class CustomerRegistry extends AbstractDAO<Customer, String> implements ICustomerRegistry {

    public static ICustomerRegistry newInstance(String puName) {
        return new CustomerRegistry(puName);
    }
    
    /**
     * Constructor
     * @param puName the name of the database 
     */
    public CustomerRegistry(String puName) {
        super(Customer.class, puName);
    }

    /**
     * Searches the database for customer name and returns a list with matches
     * @param name the name to search for
     * @return found a list of all name matches
     */
    @Override
    public List<Customer> getByName(String name) {
        List<Customer> found = new ArrayList<>();
        for (Customer c : getAll()) {
            if (c.getFname().equals(name) || c.getLname().equals(name)) {
                found.add(c);
            }
        }
        return found;
    }
    
    /**
     * Used by login to make sure that username and password match and that the
     * customer should be granted access.
     * @param userName customer's input user name
     * @param password customer's input password
     * @return customers a list of the match
     */
    @Override
    public List<Customer> validateLogin(String userName, String password) {
        EntityManager em = emf.createEntityManager();
        String customerByUserName = "select c from Customer c where c.userName = :userName and c.password = :password";
        TypedQuery<Customer> tq = em.createQuery(customerByUserName, Customer.class);
        tq.setParameter("userName", userName);
        tq.setParameter("password", password);
        List<Customer> customers = tq.getResultList();
        return customers;
    }    

    /**
     * Search method for the user name
     * @param name the user name to search
     * @return null if no user name found, the customer object otherwise
     */
    @Override
    public Customer findByUserName(String name) {
        Customer found = null;
        for (Customer c : getAll()) {
            if (c.getUserName().equals(name) ) {
                return c;
            }
        }
        return found;
    }
    
}
