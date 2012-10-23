package controlbeans;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thituson
 */
import backingbeans.SearchBackingBean;
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
@ConversationScoped
public class SearchControlBean implements Serializable{
    
    @Inject // Handled by system, don't need to create class.
    private Conversation conv;
    
    @Inject
    private ProductCatalogueBean prodCat;
    @Inject
    private SearchBackingBean searchBackingBean;      
            
    
    
    public SearchControlBean(){}
    


    // Any name possible
    public String action() {
        if (!conv.isTransient()) {
            conv.end();
             Logger.getAnonymousLogger().log(Level.INFO, "CONVERSATION ENDS");
        }
        try {
            String searchString = searchBackingBean.getSearchName();
            searchBackingBean.setResultProducts(prodCat.getByName(searchString));
            return "shopProducts?faces-redirect=true"; // Go back
        } catch (Exception e) {
            // Not implemented
            //return "error?faces-redirect=true&amp;cause=" + e.getMessage();
            return null;
        } 
    }
    
    public String setAll()
    {
        if (!conv.isTransient()) {
            conv.end();
             Logger.getAnonymousLogger().log(Level.INFO, "CONVERSATION ENDS");
        }  
        searchBackingBean.setResultProducts(prodCat.getAll());
        return "/jsf/shopProducts?faces-redirect=true";
    }
      
}
