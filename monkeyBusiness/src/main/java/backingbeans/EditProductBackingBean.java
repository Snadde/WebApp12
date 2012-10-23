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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Named
@ConversationScoped
public class EditProductBackingBean implements Serializable{
    
    @Inject // Handled by system, don't need to create class.
    private Conversation conv;
    

    private Long id;
    @NotNull
    @Pattern(regexp = "^[a-zA-Z]*")
    @Size(min = 1, max = 10, message = "Must use 1-10 chars")
    private String name;
    @NotNull
    @Min(value = 1, message = "Too small")
    @Max(value = 10000, message = "Too big")
    private double price;
    @NotNull
    @Min(value = 1, message = "Too small")
    @Max(value = 10, message = "Too big")
    private Long requiredSkill;
    @NotNull
    @Min(value = 1, message = "Too small")
    private Long category;
    
    /**
     * Default constructor
     */
    public EditProductBackingBean(){}

    /**
     * Get method for the id of the product
     * @return id the id of the product
     */
    public Long getId() {
        return id;
    }

    /**
     * Get method for the name of the product
     * @return the name of the product
     */
    public String getName() {
        return name;
    }

    /**
     * Get method for the price of the product
     * @return the price of the product
     */
    public double getPrice() {
        return price;
    }
    
    /**
     * Set method for the id of the product
     * @param id the product's id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Set method for the name of the product
     * @param name the product's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set method of the price of the product
     * @param price the price of the product
     */
    public void setPrice(double price) {
        this.price = price;
    }
    
    /**
     * Get method of the required skill of the product
     * @return the required skill of the product in question
     */
    public Long getRequiredSkill() {
        return requiredSkill;
    }

    /**
     * Set method for the required skill of the product
     * @param requiredSkill the skill of the product
     */
    public void setRequiredSkill(Long requiredSkill) {
        this.requiredSkill = requiredSkill;
    }

    /**
     * Get method for the category of the product
     * @return category the category this product belongs to
     */
    public Long getCategory() {
        return category;
    }

    /**
     * Set method for the product's category
     * @param category the category to put this product in
     */
    public void setCategory(Long category) {
        this.category = category;
    }
    
      
}
