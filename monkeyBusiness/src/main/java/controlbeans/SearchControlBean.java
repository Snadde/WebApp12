package controlbeans;

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

/**
 *
 * @author Patrik Thituson
 */
@Named
@ConversationScoped
public class SearchControlBean implements Serializable {

    @Inject // Handled by system, don't need to create class.
    private Conversation conv;
    @Inject
    private ProductCatalogueBean prodCat;
    @Inject
    private SearchBackingBean searchBackingBean;

    /**
     * Defualt constructor
     */
    public SearchControlBean() {
    }

    /**
     * get a list of all product that match the searchString and set the 
     * ResultProduct list in SearchBackingBean
     * 
     * @return which web page to redirect to 
     */
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

    /**
     * Set a list in SearchBackingBean with all products in product catalogue
     * 
     * @return the web page that we want to redirect to 
     */
    public String setAll() {
        if (!conv.isTransient()) {
            conv.end();
            Logger.getAnonymousLogger().log(Level.INFO, "CONVERSATION ENDS");
        }
        searchBackingBean.setResultProducts(prodCat.getAll());
        return "/jsf/shopProducts?faces-redirect=true";
    }
}
