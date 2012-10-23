package core;

import java.util.HashMap;
import java.util.Map;

/**
 * Simple shopping cart inspired by hajo's shop
 * 
 * @author Martin Augustsson, Markus Schützer, Gustaf Werlinder och Patrik
 * Thituson
 */
public class Cart {

    // Java 1.7
    // Map that is the cart Maps Products with quantity(Integer)
    private final Map<Product, Integer> productFreq = new HashMap<>();

    /**
     * Adds a product to the map
     * 
     * @param product 
     */
    public void add(Product product) {
        int i = 1;
        if( productFreq.containsKey(product)) {
            i = productFreq.get(product) + 1;     
        }
        productFreq.put(product, i);
    }
    /**
     * Removes a product if the quantity > 1 else decrease quantity with 1
     * @param product 
     */
    public void remove(Product product) {       
        int i = productFreq.get(product);
        if( i > 1){
            productFreq.put(product, --i);
        }else{
            productFreq.remove(product);
        }
    }
    
    /**
     * Delets the product from the map
     * @param product 
     */
    public void delete(Product product){
        productFreq.remove(product);
    }
    
    /**
     * Get method for the map
     * @return productFreq
     */
    public Map<Product, Integer> getProductFreq() {
        return productFreq;
    }
    
    /**
     * 
     * @return the cart as a string
     */
    @Override
    public String toString() {
        return "Cart{" + "productFreq=" + productFreq.toString() + '}';
    }
    
}
