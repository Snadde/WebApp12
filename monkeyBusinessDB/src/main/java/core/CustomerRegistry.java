
package core;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 * All customers
 * @author hajo
 */
public final class CustomerRegistry extends AbstractDAO<Customer, String> implements ICustomerRegistry {

    public static ICustomerRegistry newInstance(String puName) {
        return new CustomerRegistry(puName);
    }
    
    public CustomerRegistry(String puName) {
        super(Customer.class, puName);
    }

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
