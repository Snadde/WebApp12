/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Martin Augustsson && Gustaf Werlinder
 */
import core.Product;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.*;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class ShopProductsBackingBean implements Serializable{
    @Inject
    private ProductCatalogueBean productCatalogueBean;
    
    public ShopProductsBackingBean(){}
      
 
    public List<Product> getAll() {
        return productCatalogueBean.getAll();
    }
    
}
