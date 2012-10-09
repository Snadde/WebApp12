/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thituson
 */
import core.Product;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.*;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Named("addProduct")
@SessionScoped
public class addProductBB implements Serializable{
    
    private ProductCatalogueBean prodCat;
    @NotNull
    @Min(value = 1, message = "To small")
    @Max(value = 1000, message = "To big")
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
    @Min(value = 1, message = "To small")
    @Max(value = 10, message = "To big")
    private Long requiredSkill;
    
    
    public addProductBB(){}
    
    @Inject
    public addProductBB(ProductCatalogueBean productCatalogueBean){
        this.prodCat = productCatalogueBean;
    
    }
    

    // Any name possible
    public String action() {
        Product product = new Product(id, name, price, requiredSkill);
        prodCat.add(product);
        return "adminProducts?faces-redirect=true";  // Where to go, navigate 
    }



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
        return 0L;
    }

    public String getName() {
        return "";
    }

    public double getPrice() {
        return 0;
    }
    
    public Long getRequiredSkill() {
        return 1L;
    }

    public void setRequiredSkill(Long requiredSkill) {
        this.requiredSkill = requiredSkill;
    }
   
        
    
    
    
}
