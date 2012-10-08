
package core;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 * All products
 * @author hajo
 */
public final class ProductCatalogue extends AbstractDAO<Product, Long> implements IProductCatalogue {

    private ProductCatalogue(String puName) {
        super(Product.class, puName);
    }
   
    public static IProductCatalogue newInstance(String puName){
        return new ProductCatalogue(puName);
    }
    
    @Override
    public List<Product> getByName(String name) {
        List<Product> found = new ArrayList<>();
        for (Product p : getAll()) {
            if (p.getName().equals(name)) {
                found.add(p);
            }
        }
        return found;
    }
    
   
    
    public List<Product> getByNameLike(String name) {
        EntityManager em = emf.createEntityManager();
        String productsByName = "select b from Product b where b.name like :name";
        TypedQuery<Product> tq = em.createQuery(productsByName, Product.class);
        tq.setParameter("name", "%"+name+"%");
        List<Product> products = tq.getResultList();
        return products;
    }    
    
    public Product getById(long id) {
        EntityManager em = emf.createEntityManager();
        String productById = "select b from Product b where b.id = :id";
        TypedQuery<Product> tq = em.createQuery(productById, Product.class);
        tq.setParameter("id", id);
        Product product = tq.getSingleResult();
        return product;
    }    
    
    
    public List<Product> getByPrice(double price) {
        EntityManager em = emf.createEntityManager();
        String productsByPrice = "select b from Product b where b.price = :price";
        TypedQuery<Product> tq = em.createQuery(productsByPrice, Product.class);
        tq.setParameter("price", price);
        List<Product> products = tq.getResultList();
        return products;
    }    
    
    
    
    
}
