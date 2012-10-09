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

@Named
@SessionScoped
public class AdminProductsBB implements Serializable{
    @Inject
    private ProductCatalogueBean productCatalogueBean;
    
    public AdminProductsBB(){}
    
    @Inject
    public AdminProductsBB(ProductCatalogueBean productCatalogueBean){
        this.productCatalogueBean = productCatalogueBean;
    
    }

    public void add(Product product)
    {
        productCatalogueBean.add(product);
    }
    
 
    public List<Product> getAll() {
        return productCatalogueBean.getAll();
    }
        
    
    
    
}
