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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.*;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

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
