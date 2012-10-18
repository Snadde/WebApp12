package controlbeans;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thituson
 */
import backingbeans.DeleteProductBackingBean;
import backingbeans.ShowProductBackingBean;
import core.Product;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.*;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import modelbeans.ProductCatalogueBean;

@Named
@RequestScoped
public class ShowProductControlBean implements Serializable{
    
    @Inject // Handled by system, don't need to create class.
    private Conversation conv;
    @Inject
    private ProductCatalogueBean prodCat;
    @Inject
    private ShowProductBackingBean showProductBackingBean;      
            
    
    
    public ShowProductControlBean(){}
    

//    public String action() {
//        if (!conv.isTransient()) {
//            conv.end();
//             Logger.getAnonymousLogger().log(Level.INFO, "CONVERSATION ENDS");
//        }
//        try 
//        {
//            
//            Long id = showProductBackingBean.getId();
//            prodCat.remove(id);
//            return "adminProducts?faces-redirect=true"; // Go back
//        } catch (Exception e) {
//            // Not implemented
//            //return "error?faces-redirect=true&amp;cause=" + e.getMessage();
//            return null;
//        }
//    
//
//        
//    }

    public void actionListener(ActionEvent ae) { 
        Product product = (Product) ae.getComponent().getAttributes().get("product");
       
        showProductBackingBean.setId(product.getId());
        showProductBackingBean.setName(product.getName());
        showProductBackingBean.setPrice(product.getPrice());
        String requiredSkill = prodCat.getSkillStringValue(product.getRequiredSkill());
        showProductBackingBean.setRequiredSkill(requiredSkill);
        showProductBackingBean.setCategory(product.getCategory());
        showProductBackingBean.setImageLink(product.getImageLink());
        //showProductBackingBean.setImageLink("./../resources/images/angry-monkey.jpg");
        
    }

 
      
}
