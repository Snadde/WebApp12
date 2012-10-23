package backingbeans;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thituson
 */

import java.io.Serializable;
import javax.enterprise.context.*;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ConversationScoped
public class DeleteProductBackingBean implements Serializable{
    
    @Inject // Handled by system, don't need to create class.
    private Conversation conv;
    
    private Long id;
    private String name;
    private double price;
    private String requiredSkill;
    
    
    /**
     * Default constructor
     */
    public DeleteProductBackingBean(){}

    /**
     * Get method for the conversation
     * @return the conversation in use
     */
    public Conversation getConv() {
        return conv;
    }

    /**
     * Set method for the conversation
     * @param conv the conversation to be used
     */
    public void setConv(Conversation conv) {
        this.conv = conv;
    }

    /**
     * Get method for id of this product
     * @return id the product id
     */
    public Long getId() {
        return id;
    }

    /**
     * Set method for the product id
     * @param id the id to be used by the product
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get method for the product name
     * @return name the product name
     */
    public String getName() {
        return name;
    }

    /**
     * Set method for the product name
     * @param name of the product
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get method of the product price
     * @return price the price of the product
     */
    public double getPrice() {
        return price;
    }

    /**
     * Set method for the product price
     * @param price the price of this product
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Get method for the required skill of the product
     * @return requiredSkill the required skill of this product
     */
    public String getRequiredSkill() {
        return requiredSkill;
    }

    /**
     * Set method for the required skill of this product
     * @param requiredSkill required skill for the current product
     */
    public void setRequiredSkill(String requiredSkill) {
        this.requiredSkill = requiredSkill;
    }

       
    
    
    
    
}
