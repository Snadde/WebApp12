package backingbeans;

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
import javax.enterprise.context.*;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class ShowProductBackingBean implements Serializable{
    
    @Inject // Handled by system, don't need to create class.
    private Conversation conv;
    private String requiredSkill;
    private String category;
    private Product prod;
    
    /**
     * Default Constructor
     */
    public ShowProductBackingBean(){}

    /**
     * Get method for the product
     * @return prod the product object
     */
    public Product getProd() {
        return prod;
    }

    /**
     * Set method for the product
     * @param prod the product object
     */
    public void setProd(Product prod) {
        this.prod = prod;
    }

    /**
     * The get method for the required skill of this product object
     * @return requiredSkill a string representing the required skill
     */
    public String getRequiredSkill() {
        return requiredSkill;
    }

    /**
     * Set method for the required skill of this product object
     * @param requiredSkill the skill level for the product
     */
    public void setRequiredSkill(String requiredSkill) {
        this.requiredSkill = requiredSkill;
    }

    /**
     * Get method for the category of the product
     * @return category a string representing product category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Set method for the product's category
     * @param category the category to place the product in
     */
    public void setCategory(String category) {
        this.category = category;
    }
    
   

     
}
