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
    private Long id;
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


    public void setId(Long id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
    
    public Long getRequiredSkill() {
        return requiredSkill;
    }

    public void setRequiredSkill(Long requiredSkill) {
        this.requiredSkill = requiredSkill;
    }

    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }
      
}
