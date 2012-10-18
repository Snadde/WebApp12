package core;

import java.util.List;

/**
 * Interface to customer registry
 * @author hajo
 */
public interface ICustomerRegistry extends IDAO<Customer, String> {

    List<Customer> getByName(String name);
    List<Customer> validateLogin(String userName, String password);
    Customer findByUserName(String name);
    
}
