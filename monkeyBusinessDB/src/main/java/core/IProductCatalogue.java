
package core;

import java.util.List;

/**
 * Interface to product catalogue
 * @author hajo
 */
public interface IProductCatalogue extends IDAO<Product, Long> {

    List<Product> getByName(String name);
    
}
