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
import javax.enterprise.context.*;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class AddProductControlBean implements Serializable{
    @Inject
    private ProductCatalogueBean prodCat;
    @Inject
    private AddProductBackingBean addProductbb;
    
    public AddProductControlBean(){}
        
    public String action() {
        String name = addProductbb.getName();
        double price = addProductbb.getPrice();
        Long requiredSkill = addProductbb.getRequiredSkill();
        Product product = new Product(name, price, requiredSkill);
        prodCat.add(product);
        return "adminProducts?faces-redirect=true";  // Where to go, navigate 
    }
    
    


    
    
    
}
