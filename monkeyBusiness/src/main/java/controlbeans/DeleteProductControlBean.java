package controlbeans;

import backingbeans.DeleteProductBackingBean;
import core.Product;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.*;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import modelbeans.ProductCatalogueBean;

/**
 * @author Martin Augustsson, Markus Schützer, Gustaf Werlinder och Patrik
 * Thituson
 */

@Named
@ConversationScoped
public class DeleteProductControlBean implements Serializable{
    
    @Inject // Handled by system, don't need to create class.
    private Conversation conv;    
    @Inject
    private ProductCatalogueBean prodCat;
    @Inject
    private DeleteProductBackingBean deleteProductBackingBean;      
    
    public DeleteProductControlBean(){}

    /**
     * Deletes the product from the product catalogue
     * @return the webpage to redirect to
     */
    public String action() {
        if (!conv.isTransient()) {
            conv.end();
             Logger.getAnonymousLogger().log(Level.INFO, "CONVERSATION ENDS");
        }
        try 
        {
            Long id = deleteProductBackingBean.getId();
            prodCat.remove(id);
            return "adminProducts?faces-redirect=true"; // Go back
        } catch (Exception e) {
            // Not implemented
            //return "error?faces-redirect=true&amp;cause=" + e.getMessage();
            return null;
        } 
    }

    /**
     * Prepares the DeleteProductBackingBean with info that the admin will
     * get when he comes to the comfirmation page.
     * @param ae The action event that triggerd the action.
     */
    public void actionListener(ActionEvent ae) { 
        Product product = (Product) ae.getComponent().getAttributes().get("product");
        if (conv.isTransient()) {
            conv.begin();
             Logger.getAnonymousLogger().log(Level.INFO, "CONVERSATION BEGINS: Got pnumb {0}", product);
        }else{
            
        }
        deleteProductBackingBean.setId(product.getId());
        deleteProductBackingBean.setName(product.getName());
        deleteProductBackingBean.setPrice(product.getPrice());
        String requiredSkill = prodCat.getSkillStringValue(product.getRequiredSkill());
        deleteProductBackingBean.setRequiredSkill(requiredSkill);
    }   
}
