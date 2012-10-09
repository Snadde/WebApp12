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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.*;
import javax.faces.event.ActionListener;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Named("editProduct")
@ConversationScoped
public class editProductBB implements Serializable{
    
    @Inject // Handled by system, don't need to create class.
    private Conversation conv;
    
    @Inject
    private ProductCatalogueBean prodCat;
    private Long id;
    @NotNull
    @Pattern(regexp = "^[a-zA-Z]*")
    @Size(min = 1, max = 10, message = "Must use 1-10 chars")
    private String name;
    @NotNull
    @Min(value = 1, message = "To small")
    @Max(value = 10000, message = "To big")
    private double price;
    @NotNull
    @Min(value = 1, message = "To small")
    @Max(value = 10, message = "To big")
    private Long requiredSkill;
    
    
    public editProductBB(){}
    
    public editProductBB(ProductCatalogueBean productCatalogueBean){
        this.prodCat = productCatalogueBean;
        
    
    }
    

    // Any name possible
    public String action() {
        if (!conv.isTransient()) {
            conv.end();
             Logger.getAnonymousLogger().log(Level.INFO, "CONVERSATION ENDS");
        }
        try {
            prodCat.update(new Product(id, name, price, requiredSkill));
            return "products?faces-redirect=true"; // Go back
        } catch (Exception e) {
            // Not implemented
            //return "error?faces-redirect=true&amp;cause=" + e.getMessage();
            return null;
        }

        
    }

    public void actionListener(Product product) { // NOTE: faces.ActionEvent
        if (conv.isTransient()) {
            conv.begin();
             Logger.getAnonymousLogger().log(Level.INFO, "CONVERSATION BEGINS: Got pnumb {0}", product);
        }else{
            
        }
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.requiredSkill = product.getRequiredSkill();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public Long getRequiredSkill() {
        return requiredSkill;
    }

    public void setRequiredSkill(Long requiredSkill) {
        this.requiredSkill = requiredSkill;
    }
      
}
