
import core.IProductCatalogue;
import core.JPAShop;
import core.Product;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.*;
import javax.inject.Named;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thituson
 */
@Named
@ApplicationScoped
public class ProductCatalogueBean implements Serializable {
    
    private final transient IProductCatalogue productCatalogue = JPAShop.INSTANCE.getProductCatalogue();
    
    public void add(Product p) {
        if(productCatalogue.find(p.getId())==null)
        {
            productCatalogue.add(p);
        }
    }
    
    public Product find(Long id) {
        return productCatalogue.find(id);
    }

   
    public void update(Product p) {
        productCatalogue.update(p);
    }

   
    public void remove(Long id) {
        productCatalogue.remove(id);
    }

   
    public List<Product> getAll() {
        return productCatalogue.getAll();
    }
    
    
}
