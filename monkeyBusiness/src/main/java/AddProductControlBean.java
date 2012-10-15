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
import javax.annotation.security.RolesAllowed;
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
    
    @RolesAllowed("Admin")
    public String action() {
        String name = addProductbb.getName();
        double price = addProductbb.getPrice();
        Long requiredSkill = addProductbb.getRequiredSkill();
        Long category = addProductbb.getCategory();
        Product product = new Product(name, price, requiredSkill, category);
        prodCat.add(product);
        return "adminProducts?faces-redirect=true";  // Where to go, navigate 
    }
    
    


    
    
    
}
