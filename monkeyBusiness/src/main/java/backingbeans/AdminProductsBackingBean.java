package backingbeans;

/**
 * This Class simply contains a method to get all products from the product catalogue
 * @author Patrik Thituson
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
    /**
     * 
     * @return List of all the products
     */
    public List<Product> getAll() {
        return productCatalogueBean.getAll();
    }

}
