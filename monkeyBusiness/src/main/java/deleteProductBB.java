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

@Named("deleteProduct")
@ConversationScoped
public class deleteProductBB implements Serializable{
    
    @Inject // Handled by system, don't need to create class.
    private Conversation conv;
    
    private ProductCatalogueBean prodCat;
    private Long id;
    private String name;
    private double price;
    private Long requiredSkill;
    
    
    
    public deleteProductBB(){}
    
    @Inject
    public deleteProductBB(ProductCatalogueBean productCatalogueBean){
        this.prodCat = productCatalogueBean;
        
    
    }
    

    // Any name possible
    public String action() {
        if (!conv.isTransient()) {
            conv.end();
             Logger.getAnonymousLogger().log(Level.INFO, "CONVERSATION ENDS");
        }
        try {
            prodCat.remove(id);
            return "products?faces-redirect=true"; // Go back
        } catch (Exception e) {
            // Not implemented
            //return "error?faces-redirect=true&amp;cause=" + e.getMessage();
            return null;
        }

        
    }

    public Long getId() {
        return id;
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

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Long getRequiredSkill() {
        return requiredSkill;
    }
    
    
    
    
    
}
