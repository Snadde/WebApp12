package backingbeans;

import java.io.Serializable;
import javax.enterprise.context.*;
import javax.inject.Named;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * * This class acts like a view part and holds the information of the Product
 * class. The user sets the attributes in the form and the control bean will get
 * all attributes to create the class. It only contains attributes and getters
 * and setters
 *
 * @author Patrik Thituson, Martin Augustsson, Gustaf Werlinder, Markus Schutzer
 */
@Named
@RequestScoped
public class AddProductBackingBean implements Serializable{
    

    @NotNull
    @Pattern(regexp = "^[a-zA-Z]*")
    @Size(min = 1, max = 10, message = "Must use 1-10 chars")
    private String name;
    @NotNull
    @Min(value = 1, message = "To small")
    @Max(value = 10000, message = "To big")
    private double price;
    @NotNull
    @Min(value = 1, message = "Please enter a skill level")
    private Long requiredSkill;
    @NotNull
    @Min(value = 1, message = "Please enter a category")
    private Long category;
    private String imageLink;
     
    /**
     * Default constructor
     */
    public AddProductBackingBean(){}

    /**
     * Set method for the price of this product
     * @param price double representing product price
     */
    public void setPrice(double price) {
        this.price = price;
    }
    /**
     * Set method for name of product
     * @param name of product
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Get method for name of product
     * @return name the name of the product
     */
    public String getName() {
        return name;
    }
    /**
     * Get method for the price of the product
     * @return price the cost of the product
     */
    public double getPrice() {
        return price;
    }
    /**
     * Get method for the product skill
     * @return required skill a long representing skill level
     */
    public Long getRequiredSkill() {
        return requiredSkill;
    }
    /**
     * set method for the required skill
     * @param requiredSkill the skill required for present product
     */
    public void setRequiredSkill(Long requiredSkill) {
        this.requiredSkill = requiredSkill;
    }
    /**
     * Get method for product category
     * @return category a long representing product category
     */
    public Long getCategory() {
        return category;
    }
    /**
     * Set method for product category
     * @param category the category to which this product belongs
     */
    public void setCategory(Long category) {
        this.category = category;
    }
    
    /**
     * Get method for imagelink of this product
     * @return imageLink a string which links to this product's image
     */
    public String getImageLink() {
        return imageLink;
    }
    
    /**
     * Set method for the product's imagelink
     * @param imageLink the imagelink to represent the product
     */
    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }
      
}
