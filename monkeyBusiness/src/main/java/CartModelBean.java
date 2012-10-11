

import core.Cart;
import core.JPAShop;
import core.Product;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thituson
 */

@SessionScoped
public class CartModelBean implements Serializable {
    
    Cart cart = new Cart();

    public CartModelBean() {
    }
        
    public void add(Product p) {
        cart.add(p);
    }

    public void remove(Product p) {
        cart.remove(p);
    }

    public Map<Product, Integer> getAll() {
        return cart.getProductFreq();
    }
    
    public void clearCart(){
        this.cart = new Cart();
    }
    
    public Cart getCart(){
        return cart;
    }
          
    
}
