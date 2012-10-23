package controlbeans;

/**
 * This class acts like the controller and is requestScoped. It gets all the
 * attributes from the backing bean (view part). It creates a product and adds
 * it to the product catalogue bean (model).
 *
 * @author Martin Augustsson, Markus Schützer, Gustaf Werlinder och Patrik
 * Thituson
 */
import backingbeans.AddProductBackingBean;
import core.Product;
import java.io.Serializable;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.*;
import javax.inject.Inject;
import javax.inject.Named;
import modelbeans.ProductCatalogueBean;

@Named
@RequestScoped
public class AddProductControlBean implements Serializable {

    @Inject
    private ProductCatalogueBean prodCat;
    @Inject
    private AddProductBackingBean addProductbb;

    public AddProductControlBean() {
    }

    /**
     * Creates a product with the attributes from the backing bean
     *
     * @return the page which the suer should be redirected to
     */
    @RolesAllowed("Admin")
    public String action() {
        String name = addProductbb.getName();
        double price = addProductbb.getPrice();
        Long requiredSkill = addProductbb.getRequiredSkill();
        Long category = addProductbb.getCategory();
        Product product = new Product(name, price, requiredSkill, category);
        product.setImageLink(addProductbb.getImageLink());
        prodCat.add(product);
        return "adminProducts?faces-redirect=true";  // Where to go, navigate 
    }
}
