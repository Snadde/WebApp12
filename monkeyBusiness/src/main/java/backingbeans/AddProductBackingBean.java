package backingbeans;

/**
 * * This class acts like a view part and holds the information of the Product
 * class. The user sets the attributes in the form and the control bean will get
 * all attributes to create the class. It only contains attributes and getters
 * and setters
 *
 * @author Patrik Thituson
 */
import java.io.Serializable;
import java.util.Map;
import javax.enterprise.context.*;
import javax.inject.Named;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
     
    
    public AddProductBackingBean(){}

    /**
     * Sets the price
     * @param price 
     */
    public void setPrice(double price) {
        this.price = price;
    }
    /**
     * Sets the name
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * 
     * @return name
     */
    public String getName() {
        return name;
    }
    /**
     * 
     * @return price
     */
    public double getPrice() {
        return price;
    }
    /**
     * 
     * @return required skill
     */
    public Long getRequiredSkill() {
        return requiredSkill;
    }
    /**
     * sets the required skill
     * @param requiredSkill 
     */
    public void setRequiredSkill(Long requiredSkill) {
        this.requiredSkill = requiredSkill;
    }
    /**
     * 
     * @return category
     */
    public Long getCategory() {
        return category;
    }
    /**
     * Sets the category
     * @param category 
     */
    public void setCategory(Long category) {
        this.category = category;
    }
    /**
     * 
     * @return imageLink
     */
    public String getImageLink() {
        return imageLink;
    }
    /**
     * Sets the imageLink
     * @param imageLink 
     */
    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }
      
}
