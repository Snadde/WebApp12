package core;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test class to test the Product catalogue
 *
 * @author Patrik Thituson
 */
public class TestProductCatalogue {

    private static EntityManagerFactory emf;

    @BeforeClass
    public static void setUpClass() throws Exception {
        emf = Persistence.createEntityManagerFactory("shop_test_pu");

    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        emf.close();
    }

    /**
     * Test to add and find a product in the product catalogue
     */
    @Test
    public void testAddFind() {

        Product product1 = new Product("name", 123F, 1L, 1L);
        Product product2 = null;
        ProductCatalogue prodCat = (ProductCatalogue) ProductCatalogue.newInstance("shop_test_pu");
        prodCat.add(product1);
        product2 = prodCat.find(product1.getId());
        Assert.assertTrue(product1.toString().equals(product2.toString()));
    }

    /**
     * Test remove the product from the product catalogue
     */
    @Test
    public void testRemove() {
        Product product1 = new Product("name", 123F, 1L, 1L);
        Product product2 = null;
        ProductCatalogue prodCat = (ProductCatalogue) ProductCatalogue.newInstance("shop_test_pu");

        prodCat.add(product1);
        product2 = prodCat.find(product1.getId());
        Assert.assertTrue(product1.toString().equals(product2.toString()));

        prodCat.remove(product1.getId());
        product2 = prodCat.find(product1.getId());
        Assert.assertTrue(product2 == null);
    }

    /**
     * Test the update function of a product in the
     * product catalogue
     */
    @Test
    public void testUpdate() {
        Product product1 = new Product("name", 123F, 1L, 1L);
        Product product2 = null;
        Product product3 = null;

        ProductCatalogue prodCat = (ProductCatalogue) ProductCatalogue.newInstance("shop_test_pu");
        prodCat.add(product1);

        product2 = new Product(product1.getId(), "hej", 321F, 1L, 1L);
        prodCat.update(product2);
        product3 = prodCat.find(product1.getId());
        Assert.assertFalse(product1.toString().equals(product3.toString()));
        Assert.assertTrue(product3.toString().equals(product2.toString()));
    }

    /**
     * Test the method that counts how many product there is
     */
    @Test
    public void testCount() {
        ProductCatalogue prodCat = (ProductCatalogue) ProductCatalogue.newInstance("shop_test_pu");
        Product product1 = new Product("name", 123F, 1L, 1L);
        Product product2 = new Product("name1", 123F, 1L, 1L);
        Product product3 = new Product("name2", 123F, 1L, 1L);
        int x = prodCat.getCount();
        prodCat.add(product1);
        prodCat.add(product2);
        prodCat.add(product3);

        Assert.assertTrue(prodCat.getCount() == (3 + x));
    }

    /**
     * Test that method getAll() return all products in 
     * the product catalogue
     */
    @Test
    public void testGetAll() {
        ProductCatalogue prodCat = (ProductCatalogue) ProductCatalogue.newInstance("shop_test_pu");
        List<Product> list = prodCat.getAll();

        Assert.assertTrue(prodCat.getCount() == list.size());
    }
}