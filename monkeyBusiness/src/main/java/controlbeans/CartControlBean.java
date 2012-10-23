package controlbeans;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Gustaf Werlinder && Martin Augustsson
 */
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


    public CartControlBean() {
    }

    public void getAll() {
        Map<Product, Integer> tempCartMap = cartModelBean.getAll();
        Set<Map.Entry<Product, Integer>> managerSet = tempCartMap.entrySet();
        showCartBackingBean.setCartProductList(new ArrayList<Map.Entry<Product, Integer>>(managerSet));
        calculateTotalCartCost(managerSet);
    }
    
    public void getAndSetUser(){
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        String user = request.getRemoteUser();
        showCartBackingBean.setCustomer(simpleLogin.getCustomer(user));       
    }

    public void calculateTotalCartCost(Set<Map.Entry<Product, Integer>> managerSet) {
        double totalCost = 0;
        for (Map.Entry entry : managerSet) {
            Product p = (Product) entry.getKey();
            totalCost += p.getPrice() * (int) entry.getValue();
        }
        showCartBackingBean.setTotalCartCost(totalCost);
    }

    public void addToCart(Product p) {
        cartModelBean.add(p);
    }

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
