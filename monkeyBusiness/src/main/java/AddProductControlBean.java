/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thituson
 */
import core.Product;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.*;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Named
@SessionScoped
public class AddProductControlBean implements Serializable{
    @Inject
    private ProductCatalogueBean prodCat;
    @Inject
    private addProductBB addProductbb;
    
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
