package backingbeans;

import controlbeans.CartControlBean;
import core.Customer;
import core.Product;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.*;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author Patrik Thituson, Martin Augustsson, Gustaf Werlinder, Markus Schutzer
 */
@Named
@SessionScoped
public class ShowCartBackingBean implements Serializable{
    @Inject
    private CartControlBean cartControlBean;
    
    private List cartProductList;
    private double totalCartCost;
    private Customer customer;
    
    /**
     * Default constructor
     */
    public ShowCartBackingBean(){}

    /**
     * Set method for the the cartProductList, a list of all products in the cart
     * @param cartProductList list of the products in the cart
     */
    public void setCartProductList(ArrayList<Map.Entry<Product, Integer>> cartProductList)
    {
        this.cartProductList = cartProductList;
    }

    /**
     * Get method for the cartProductlist
     * @return cartProductList a list och products present in the cart
     */
    public List getCartProductList() {
        return cartProductList;
    }

    /**
     * Get method for the total cost of all products present in cart
     * @return totalCartCost the cumulative cost of the products in cart
     */
    public double getTotalCartCost() {
        return totalCartCost;
    }

    /**
     * Set method for the cost of the total products in cart
     * @param totalCartCost the cost of all products present in cart
     */
    public void setTotalCartCost(double totalCartCost) {
        this.totalCartCost = totalCartCost;
    }

    /**
     * Get method for the customer to which this cart belongs
     * @return customer the present customer
     */
    public Customer getCustomer() {
        cartControlBean.getAndSetUser();
        return customer;
    }

    /**
     * Set method for the customer for the cart
     * @param customer the customer to connect to the cart
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    
    
}
