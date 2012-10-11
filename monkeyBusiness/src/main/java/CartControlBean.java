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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
    
    public List<Map.Entry<Product, Integer>> getAll(){
//        Map <Product, Integer> tempCartMap = cartModelBean.getAll();
        Set<Map.Entry<Product, Integer>> managerSet = cartModelBean.getAll().entrySet();
        
        return new ArrayList<Map.Entry<Product, Integer>>(managerSet);
    }

    public void addToCart(Product p){
        cartModelBean.add(p);
                
    }
            
        public void actionListener(ActionEvent ae) { 

        String id = ae.getComponent().getId();
        
        if(id.equals("Addbutton")){
            addToCart((Product) ae.getComponent().getAttributes().get("prod"));
        }
        else if(id.equals("DeleteButton")){
        
        }
        else if(id.equals("-Button")){
        
        }
        else if(id.equals("+Button")){
        
        }
    }        
   
      
}
