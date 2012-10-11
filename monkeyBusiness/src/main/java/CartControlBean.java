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
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.*;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

@Named()
@SessionScoped
public class CartControlBean implements Serializable{
    
    @Inject // Handled by system, don't need to create class.
    private Conversation conv;
    
    @Inject
    private CartModelBean cartModelBean;    
    @Inject
    private ShopProductsBackingBean shopProductsBackingBean;
    @Inject
    private ShowCartBackingBean showCartBackingBean;

    public CartControlBean(){}
    
    public Map<Product,Integer> getAll(){
        return cartModelBean.getAll();
    }

    
    // Any name possible
    public String action() {
        if (!conv.isTransient()) {
            conv.end();
             Logger.getAnonymousLogger().log(Level.INFO, "CONVERSATION ENDS");
        }
        try {
            
//            cartModelBean.add(product);
            return "shopProducts?faces-redirect=true"; // Go back
        } catch (Exception e) {
            // Not implemented
            //return "error?faces-redirect=true&amp;cause=" + e.getMessage();
            return null;
        }

        
    }

    //En actionlistener
    public void actionListener(ActionEvent ae) { 
        Product product = (Product) ae.getComponent().getAttributes().get("prod");
        System.out.println(product.toString());
        if (conv.isTransient()) {
            conv.begin();
             Logger.getAnonymousLogger().log(Level.INFO, "CONVERSATION BEGINS: Got pnumb {0}", product);
        }else{
            
        }
                
    }
      
}
