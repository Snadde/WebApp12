package core;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test class to test customer and customer registry
 * @author Patrik Thituson
 */
public class TestCustomer {
    
    private static CustomerRegistry customerReg;
    private static OrderBook orderBook;
    private static Address addr;
    private static Customer customerOne;
    private static Product prod;
    private static ProductCatalogue prodCat;

    @BeforeClass
    public static void setUpClass() {
        customerReg = (CustomerRegistry) JPAShop.INSTANCE.getCustomerRegistry();
        orderBook = (OrderBook)JPAShop.INSTANCE.getOrderBook();
        prodCat = (ProductCatalogue) JPAShop.INSTANCE.getProductCatalogue();
        addr = new Address("Gatan", 15, "GOTEBAAAARG");
        customerOne = new Customer(addr, "fornamn", "efternamn", "email.com", "apa", "apa");
        customerOne.addGroup(Group.ADMIN);
        prod = new Product("ProdNamn", 123, 1L, 1L);
        
    }

    @AfterClass
    public static void tearDownClass() {
        customerReg = null;
        
    }
    
    /**
     * Test to add and to remove a customer
     */
    @Test
    public void testAddandRemoveCustomer()
    {
        Address addr = new Address("Gatan", 15, "GOTEBAAAARG");
        Customer cus1 = new Customer(addr, "fornamn", "efternamn", "email.com","username", "password");
        customerReg.add(cus1);
        Customer cus2 = customerReg.find(cus1.getUserName());
        Assert.assertEquals(cus1.toString(), cus2.toString());
        removeCustomer(cus1);
        Customer cus3 = customerReg.find(cus1.getUserName());
        Assert.assertNull(cus3);
    }
    
    /**
     * Removes the customer
     * @param customer the customer to remove
     */
    private void removeCustomer(Customer customer)
    {
        customerReg.remove(customer.getUserName());
    }
    
    /**
     * Add product to cart and create purchaseorder which adds to the orderbook
     * then remove and check
     */
    @Test
    public void testOrderbook()
    {
        prodCat.add(prod);
        customerOne.addProductToCart(prod);
        customerReg.add(customerOne);
        PurchaseOrder po = customerOne.finishShopping();
        orderBook.add(po);
        PurchaseOrder po2 = orderBook.find(po.getId());
        Assert.assertEquals(po.toString(), po2.toString());
        orderBook.remove(po.getId());
        PurchaseOrder po3 = orderBook.find(po.getId());
        Assert.assertNull(po3);
    }
    
}
