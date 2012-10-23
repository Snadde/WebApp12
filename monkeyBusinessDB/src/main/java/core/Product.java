package core;

import java.io.Serializable;
import java.util.Objects;
import java.util.Random;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * A product class inspired by hajo's shop.
 *
 * @author Martin Augustsson, Markus Schützer, Gustaf Werlinder och Patrik
 * Thituson
 */
@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private double price;
    private Long requiredSkill;
    private Long category;
    private String imageLink;

    /**
     * Default constructor
     */
    public Product() {
    }

    /**
     * Constructor.
     *
     * @param id the id of the product
     * @param name the name of the product
     * @param price the price of the product
     * @param requiredSkill the required skill for the product
     * @param category the category of the product
     */
    public Product(Long id, String name, double price, Long requiredSkill, Long category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.requiredSkill = requiredSkill;
        this.category = category;
    }

    /**
     * Constructor where the database generate a id
     *
     * @param name the name of the product
     * @param price the price of the product
     * @param requiredSkill the required skill for the product
     * @param category the category of the product
     */
    public Product(String name, double price, Long requiredSkill, Long category) {
        this.name = name;
        this.price = price;
        this.requiredSkill = requiredSkill;
        this.category = category;
    }

    /**
     * Get method for the name of the product
     *
     * @return product name
     */
    public String getName() {
        return name;
    }

    /**
     * Get method for the id of the product
     *
     * @return product id
     */
    public Long getId() {
        return id;
    }

    /**
     * Get method for the price of the product
     *
     * @return product price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Get method for the required skill of the product
     *
     * @return product required skill
     */
    public Long getRequiredSkill() {
        return requiredSkill;
    }
    /**
     * Set method for the required Skill of the product
     *
     */
    public void setRequiredSkill(Long requiredSkill) {
        this.requiredSkill = requiredSkill;
    }

    /**
     * Get method for the category of the product
     *
     * @return product category
     */
    public Long getCategory() {
        return category;
    }
    /**
     * Set method for the category of the product
     *
     */
    public void setCategory(Long category) {
        this.category = category;
    }

    /**
     * Get method for the image link skill of the product
     *
     * @return product image link
     */
    public String getImageLink() {
        return imageLink;
    }
    /**
     * Set method for the image link of the product
     *
     */
    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    /**
     * Convert the product to a string
     * @return string representation of the product
     */
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
