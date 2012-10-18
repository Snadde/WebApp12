package modelbeans;

import core.IProductCatalogue;
import core.JPAShop;
import core.Product;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.enterprise.context.*;
import javax.inject.Named;

/**
 * This class has a product catalogue and acts like the model part. The product
 * catalogue has the connection to the database but all the control beans uses
 * this bean to set and get data to and from the database
 *
 * @author Patrik Thituson, Markus Schutzer
 */
@Named
@ApplicationScoped
public class ProductCatalogueBean implements Serializable {

    private final transient IProductCatalogue productCatalogue = JPAShop.INSTANCE.getProductCatalogue();
    /**
     * A map that maps the String representation of the skillvalue to increase
     * user experience
     */
    private static Map<String, Long> skillValues;

    static {
        skillValues = new LinkedHashMap<String, Long>();
        skillValues.put("Please enter a skill level", 0L);
        skillValues.put("1 - Beginner", 1L);
        skillValues.put("2 - Beginner/intermediate", 2L);
        skillValues.put("3 - Intermediate", 3L);
        skillValues.put("4 - Intermediate/Skilled", 4L);
        skillValues.put("5 - Skilled", 5L);
        skillValues.put("6 - Skilled/Expert", 6L);
        skillValues.put("7 - Expert", 7L);
        skillValues.put("8 - Monkey Connoisseur", 8L);
        skillValues.put("9 - Monkey Enthusiast", 9L);
        skillValues.put("10 - MONKEY MADNESS!!!", 10L);
    }
    /**
     * A map that maps the String representation of the catgories to increase
     * user experience
     */
    private static Map<String, Long> categories;

    static {
        categories = new LinkedHashMap<String, Long>();
        categories.put("Please enter a category", 0L);
        categories.put("Monkeys", 1L);
        categories.put("Basic Monkeys", 2L);
        categories.put("Exotic Monkeys", 3L);
        categories.put("Small Monkeys", 4L);
        categories.put("Big Monkeys", 5L);
        categories.put("Gargantuan Monkeys", 6L);
        categories.put("Philosopher Monkeys", 7L);
        categories.put("Athletic Monkeys", 8L);
        categories.put("Monkey Outlet", 9L);
        categories.put("Monkey Equipment", 10L);
        categories.put("Monkey Safari", 11L);
    }

    /**
     * Adds a product if it doesn´t exist, checks the id it must be unique
     *
     * @param p
     */
    public void add(Product p) {
        if (productCatalogue.find(p.getId()) == null) {
            productCatalogue.add(p);
        }
    }

    /**
     * Finds and return the product with the id of the parameter
     *
     * @param id
     * @return product
     */
    public Product find(Long id) {
        return productCatalogue.find(id);
    }

    /**
     * Update the product
     *
     * @param p
     */
    public void update(Product p) {
        productCatalogue.update(p);
    }

    /**
     * removes the product
     *
     * @param id
     */
    public void remove(Long id) {
        productCatalogue.remove(id);
    }

    /**
     *
     * @return List of all the products
     */
    public List<Product> getAll() {
        return productCatalogue.getAll();
    }

    /**
     *
     * @return skillvalues the map that has the string representation of the
     * skillvalues
     */
    public static Map<String, Long> getSkillValues() {
        return skillValues;
    }

    /**
     * finds the products with the name of the parameter and returns them
     *
     * @param name
     * @return list of products
     */
    public List<Product> getByName(String name) {
        return productCatalogue.getByNameLike(name);
    }

    /**
     * Searches the map for the string representation
     *
     * @param skillValue
     * @return string representation of the skillvalue
     */
    public String getSkillStringValue(Long skillValue) {
        String skillStringValue = "No skill";
        for (Entry<String, Long> entry : skillValues.entrySet()) {
            if (entry.getValue() == skillValue) {
                skillStringValue = entry.getKey();
            }
        }
        return skillStringValue;
    }

    /**
     *
     * @return map of the categories with string representation and long value
     */
    public static Map<String, Long> getCategories() {
        return categories;
    }

    /**
     * Searches the map for the string representation
     *
     * @param categoryValue
     * @return string representation of the skill value
     */
    public String getCategoryStringValue(Long categoryValue) {
        String categoryStringValue = "No category";
        for (Entry<String, Long> entry : categories.entrySet()) {
            if (entry.getValue() == categoryValue) {
                categoryStringValue = entry.getKey();
            }
        }
        return categoryStringValue;
    }
}
