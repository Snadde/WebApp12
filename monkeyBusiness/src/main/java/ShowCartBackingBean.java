/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Martin Augustsson && Gustaf Werlinder
 */
import core.Product;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.*;
import javax.inject.Inject;
import javax.inject.Named;

@Named()
@SessionScoped
public class ShowCartBackingBean implements Serializable{
    @Inject
    private CartControlBean cartControlBean;
    
    private List cartProductList;
    
    public ShowCartBackingBean(){}

    public void setCartProductList(ArrayList<Map.Entry<Product, Integer>> cartProductList)
    {
        this.cartProductList = cartProductList;
    }

    public List getCartProductList() {
        return cartProductList;
    }
    
    
}
