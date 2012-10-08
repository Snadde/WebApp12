package core;

import java.util.HashMap;
import java.util.Map;

/**
 * Simple shopping cart
 * 
 * @author hajo
 */
public class Cart {

    // Java 1.7
    private final Map<Product, Integer> productFreq = new HashMap<>();

    public void add(Product product) {
        int i = 1;
        if( productFreq.containsKey(product)) {
            i = productFreq.get(product) + 1;     
        }
        productFreq.put(product, i);
    }

    public void remove(Product product) {       
        int i = productFreq.get(product);
        if( i > 1){
            productFreq.put(product, --i);
        }else{
            productFreq.remove(product);
        }
    }

    public Map<Product, Integer> getProductFreq() {
        return productFreq;
    }

    @Override
    public String toString() {
        return "Cart{" + "productFreq=" + productFreq.toString() + '}';
    }
    
}
