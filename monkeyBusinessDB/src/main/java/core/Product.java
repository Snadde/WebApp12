
package core;

import java.io.Serializable;
import java.util.Objects;
import java.util.Random;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author hajo
 */
@Entity
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private  String name;
    private  double price;
    private  Long requiredSkill;
    private Long category;
    private String imageLink;


    public Product() {
    }
    
    public Product(Long id, String name, double price, Long requiredSkill, Long category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.requiredSkill = requiredSkill;
        this.category = category;
    }
       
    public Product(String name, double price, Long requiredSkill, Long category) {

        this.name = name;
        this.price = price;
        this.requiredSkill = requiredSkill;
        this.category = category;
    }
    
    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
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
    
    
    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", price=" + price + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    

}
