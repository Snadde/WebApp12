package backingbeans;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author thituson
 */
import core.Product;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.*;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Named
@SessionScoped
public class SearchBackingBean implements Serializable{
    

    private String searchName;
    private List<Product> resultProducts = new ArrayList<Product>();

   
    
    
    public SearchBackingBean(){}

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchString) {
        this.searchName = searchString;
    }


    public void setResultProducts(List<Product> resultProducts) {
        this.resultProducts = resultProducts;
    }

    public List<Product> getResultProducts() {
        return resultProducts;
    }
    
    
      
}
