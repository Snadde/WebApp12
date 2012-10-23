package modelbeans;

import core.Cart;
import core.Product;
import java.io.Serializable;
import java.util.Map;
import javax.enterprise.context.*;
import javax.inject.Named;


/**
 *A modelbean that holds the cart the user interact with. 
 * It's uniqe for every session. 
 * 
 * @author Martin Augustsson && Gustaf Werlinder
 */
@Named
@SessionScoped
public class CartModelBean implements Serializable {
    
    Cart cart = new Cart();

    public CartModelBean() {
    }
    
    /**
     * Adds a product to the cart
     * @param p 
     */
    public void add(Product p) {
        cart.add(p);
    }

    /**
     * Removes a product from the cart, if theres more then one(quantity>1)
     * decreases the quantity by 1.
     * @param p 
     */
    public void remove(Product p) {
        cart.remove(p);
    }

    /**
     * Get all products from the cart, also the quantity for every product
     * @return returns a map with all products and quantity
     */
    public Map<Product, Integer> getAll() {
        return cart.getProductFreq();
    }
    
    /**
     * Clears the cart and gives the user a new one to fill up.
     */
    public void clearCart(){
        this.cart = new Cart();
    }
    
    /**
     * 
     * @return returns the cart 
     */
    public Cart getCart(){
        return cart;
    }
    
    /**
     * Deletes the product from the cart.
     * @param product 
     */
    public void delete(Product product){
        cart.delete(product);
    }
}
