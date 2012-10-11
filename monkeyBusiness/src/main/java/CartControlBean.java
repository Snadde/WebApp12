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
@ConversationScoped
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

    public String addToCart(Product p){
        cartModelBean.add(p);
                
        return "shopProducts?faces-redirect=true"; // Go back
    }
            
            
   
      
}
