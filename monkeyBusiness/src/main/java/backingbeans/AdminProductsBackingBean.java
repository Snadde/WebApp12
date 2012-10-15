package backingbeans;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thituson
 */
import core.Product;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.*;
import javax.inject.Inject;
import javax.inject.Named;
import modelbeans.ProductCatalogueBean;

@Named
@SessionScoped
public class AdminProductsBackingBean implements Serializable{
    
    @Inject
    private ProductCatalogueBean productCatalogueBean;

    public AdminProductsBackingBean(){}
    
    public List<Product> getAll() {
        return productCatalogueBean.getAll();
    }

}
