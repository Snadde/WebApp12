package controlbeans;

import backingbeans.ShowCartBackingBean;
import core.Product;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import javax.enterprise.context.*;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import modelbeans.CartModelBean;
import monkeybusiness.SimpleLogin;

/**
 * This class acts like a control bean for different backingbeans that needs 
 * to communicate with the cart model bean. And its sessionscoped. The action
 * listner checks which id the link/button that calld the method have, and then
 * the switch case desides what to do.
 * 
 * @author Martin Augustsson, Markus Schützer, Gustaf Werlinder och Patrik
 * Thituson
 */

@Named
@SessionScoped
public class CartControlBean implements Serializable {

    @Inject // Handled by system, don't need to create class.
    private Conversation conv;
    @Inject
    private CartModelBean cartModelBean;
    @Inject
    private ShowCartBackingBean showCartBackingBean;
    @Inject
    private SimpleLogin simpleLogin;

    /**
     * Default constructor
     */
    public CartControlBean() {
    }

    /**
     * Gets all products from the cart model bean and makes
     * a Entry set that later casts to  a Arraylist to make it easier to 
     * iterate trough by the datatable in xhtml. Sets the list in showCartBackingBean
     * and the calling  the function to calculate total cart cost.
     */
    public void getAll() {
        Map<Product, Integer> tempCartMap = cartModelBean.getAll();
        Set<Map.Entry<Product, Integer>> managerSet = tempCartMap.entrySet();
        showCartBackingBean.setCartProductList(new ArrayList<Map.Entry<Product, Integer>>(managerSet));
        calculateTotalCartCost(managerSet);
    }
    
    /**
     * Gets the user by checking the Remote User and after sets the customer in 
     * the showCartBackingBean.
     * 
     */
    public void getAndSetUser(){
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        String user = request.getRemoteUser();
        showCartBackingBean.setCustomer(simpleLogin.getCustomer(user));       
    }

    /**
     * Calculates the total cart cost using the set that is passed in the param.
     * When done sets the TotalCartCost in showCartBackingBean.
     * @param managerSet 
     */
    public void calculateTotalCartCost(Set<Map.Entry<Product, Integer>> managerSet) {
        double totalCost = 0;
        for (Map.Entry entry : managerSet) {
            Product p = (Product) entry.getKey();
            totalCost += p.getPrice() * (int) entry.getValue();
        }
        showCartBackingBean.setTotalCartCost(totalCost);
    }

    /**
     * Adds the product p in the cart model bean
     * @param p 
     */
    public void addToCart(Product p) {
        cartModelBean.add(p);
    }

    /**
     * An action listner that checks which button was clicked and
     * runs the right method.
     * @param ae 
     */
    public void actionListener(ActionEvent ae) {

        Product product = (Product) ae.getComponent().getAttributes().get("prod");
        String id = ae.getComponent().getId();
        
        switch (id) {
            case "plusButton":
            case "Addbutton":
                addToCart(product);
                this.getAll();
                break;
            case "minusButton":
                cartModelBean.remove(product);
                this.getAll();
                break;
            case "deleteButton":
                cartModelBean.delete(product);
                this.getAll();
                break;
            case "showCart":
                this.getAll();
                break;
            default:
                break;
        }

    }
}
