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
import javax.enterprise.context.*;
import javax.inject.Named;

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
