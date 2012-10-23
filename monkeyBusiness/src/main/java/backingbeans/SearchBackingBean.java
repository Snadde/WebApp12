package backingbeans;

/**
 * This class is used for searching for products. As of now user can only search
 * for the name of a product. This class also helps sorting the lists of search
 * results. The algorithm for this is inspired by http://www.mkyong.com/jsf2/jsf
 * -2-datatable-sorting-example/
 * 
 * @author marschu & thituson
 */
import core.Product;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.enterprise.context.*;
import javax.inject.Named;

@Named
@SessionScoped
public class SearchBackingBean implements Serializable{
    

    private String searchName;
    private List<Product> resultProducts = new ArrayList<Product>();

    private boolean sortNameUp = true;
    private boolean sortPriceUp = true;
    private boolean sortSkillUp = true;
    private boolean sortCategoryUp = true;

    /**
     * Default constructor
     */
    public SearchBackingBean(){}

    /**
     * Get method for the search name to use to search for the product
     * @return searchName the search string
     */
    public String getSearchName() {
        return searchName;
    }

    /**
     * Set method for the search string to use to find a product
     * @param searchString the string to use in search
     */
    public void setSearchName(String searchString) {
        this.searchName = searchString;
    }

    /**
     * Set method for the found products of user search, the hits will be placed in list
     * @param resultProducts list of found products 
     */
    public void setResultProducts(List<Product> resultProducts) {
        this.resultProducts = resultProducts;
    }

    /**
     * Get method for the list of products that corresponded to the search string
     * @return resultProducts list of found products
     */
    public List<Product> getResultProducts() {
        return resultProducts;

    }
    
    /**
     * Simple sorting algorithm by product name, can sort both descending and ascending
     * @return null
     */
    public String sortByName() 
    {
 
        if(sortNameUp)
        {
        Collections.sort(resultProducts, new Comparator<Product>() {
             @Override
             public int compare(Product p1, Product p2) 
             {
                 return p1.getName().compareTo(p2.getName());
             }
            });	
            sortNameUp = false;
        }
        else
        {
            Collections.sort(resultProducts, new Comparator<Product>() {
             @Override
             public int compare(Product p1, Product p2) 
             {
                 return p2.getName().compareTo(p1.getName());
             }
            });	
            sortNameUp = true;
        }
        
        return null;
    }
    
    /**
     * Simple sorting algorithm by product price, sorts descending and ascending
     * @return null
     */
    public String sortByPrice()
    {
        if(sortPriceUp)
        {
        Collections.sort(resultProducts, new Comparator<Product>() {
             @Override
             public int compare(Product p1, Product p2) 
             {
                 return ((Double)p1.getPrice()).compareTo((Double)p2.getPrice());
             }
            });	
            sortPriceUp = false;
        }
        else
        {
            Collections.sort(resultProducts, new Comparator<Product>() {
             @Override
             public int compare(Product p1, Product p2) 
             {
                 return ((Double)p2.getPrice()).compareTo((Double)p1.getPrice());
             }
            });	
            sortPriceUp = true;
        }
        
        return null;
    }
    
    /**
     * Simple sorting algorithm in regards to the required skill of the product,
     * ascending and descending
     * @return null
     */
    public String sortBySkill()
    {
        if(sortSkillUp)
        {
        Collections.sort(resultProducts, new Comparator<Product>() {
             @Override
             public int compare(Product p1, Product p2) 
             {
                 return p1.getRequiredSkill().compareTo(p2.getRequiredSkill());
             }
            });	
            sortSkillUp = false;
        }
        else
        {
            Collections.sort(resultProducts, new Comparator<Product>() {
             @Override
             public int compare(Product p1, Product p2) 
             {
                 return p2.getRequiredSkill().compareTo(p1.getRequiredSkill());
             }
            });	
            sortSkillUp = true;
        }
        
        return null;
    }
    
    /**
     * Simple sorting algorithm in regards to product category, sorts ascending
     * and descending
     * @return null
     */
    public String sortByCategory()
    {
        if(sortCategoryUp)
        {
        Collections.sort(resultProducts, new Comparator<Product>() {
             @Override
             public int compare(Product p1, Product p2) 
             {
                 return p1.getCategory().compareTo(p2.getCategory());
             }
            });	
            sortCategoryUp = false;
        }
        else
        {
            Collections.sort(resultProducts, new Comparator<Product>() {
             @Override
             public int compare(Product p1, Product p2) 
             {
                 return p2.getCategory().compareTo(p1.getCategory());
             }
            });	
            sortCategoryUp = true;
        }
        
        return null;
    }

}

