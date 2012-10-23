package core;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 * A product catalogue inspired by hajo's shop.
 *
 * @author Martin Augustsson, Markus Schützer, Gustaf Werlinder och Patrik
 * Thituson
 */
public final class ProductCatalogue extends AbstractDAO<Product, Long> implements IProductCatalogue {

    /**
     * Default constructor
     * @param puName the persistance unit name
     */
    private ProductCatalogue(String puName) {
        super(Product.class, puName);
    }

    /**
     * Makes a new instance of Product Catalogue.
     * @param puName the persistance unit name
     * @return a new instance of Product Catalogue
     */
    public static IProductCatalogue newInstance(String puName) {
        return new ProductCatalogue(puName);
    }

    /**
     * Get a product list of products matching the param.
     * @param name the name it will search for
     * @return resualts of the search in a list
     */
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

    /**
     * Get a list of products that got the param in their name.
     * ex. if you search for "te" it will get everything that got "te" in the
     * name, like "test", "lite", "porter".
     * @param name the name we will search for
     * @return a list with products that matched the search
     */
    @Override
    public List<Product> getByNameLike(String name) {
        EntityManager em = emf.createEntityManager();
        String productsByName = "select b from Product b where b.name like :name";
        TypedQuery<Product> tq = em.createQuery(productsByName, Product.class);
        tq.setParameter("name", "%" + name + "%");
        List<Product> products = tq.getResultList();
        return products;
    }

    /**
     * Search for a product by it's id.
     * @param id the id we want to find
     * @return the product with the specific id
     */
    public Product getById(long id) {
        EntityManager em = emf.createEntityManager();
        String productById = "select b from Product b where b.id = :id";
        TypedQuery<Product> tq = em.createQuery(productById, Product.class);
        tq.setParameter("id", id);
        Product product = tq.getSingleResult();
        return product;
    }

    /**
     * Search for product with a given price
     * @param price the price we searching for
     * @return a list of products that got the price we are searching for
     */
    public List<Product> getByPrice(double price) {
        EntityManager em = emf.createEntityManager();
        String productsByPrice = "select b from Product b where b.price = :price";
        TypedQuery<Product> tq = em.createQuery(productsByPrice, Product.class);
        tq.setParameter("price", price);
        List<Product> products = tq.getResultList();
        return products;
    }
}
