package controlbeans;

import backingbeans.DeleteProductBackingBean;
import backingbeans.ShowProductBackingBean;
import core.Product;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.*;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import modelbeans.ProductCatalogueBean;

/**
* This class support the ShowProductBackingBean with info that it needs
* to show product info.
* @author Patrik Thituson
*/

@Named
@RequestScoped
public class ShowProductControlBean implements Serializable{
    
    @Inject // Handled by system, don't need to create class.
    private Conversation conv;
    @Inject
    private ProductCatalogueBean prodCat;
    @Inject
    private ShowProductBackingBean showProductBackingBean;
            
    public ShowProductControlBean(){}

    /**
     * Prepares the ShowProductBackingBean with right info about the 
     * product that was clicked
     * @param ae the action event that trigged this action listener
     */
    public void actionListener(ActionEvent ae) {
        Product product = (Product) ae.getComponent().getAttributes().get("product");
       
        showProductBackingBean.setProd(product);
        String requiredSkill = prodCat.getSkillStringValue(product.getRequiredSkill());
        showProductBackingBean.setRequiredSkill(requiredSkill);
        String category = prodCat.getCategoryStringValue(product.getCategory());
        showProductBackingBean.setCategory(category);

    }
}