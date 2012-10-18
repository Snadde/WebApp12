///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package core;
//
//import java.util.List;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import org.junit.AfterClass;
//import org.junit.Assert;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
///**
// *
// * @author thituson
// */
//public class TestCustomer {
//    
//    private static CustomerRegistry customerReg;
//    private static OrderBook orderBook;
//    private static Address addr;
//    private static Customer customerOne;
//    private static Product prod;
//
//    @BeforeClass
//    public static void setUpClass() {
//        customerReg = (CustomerRegistry) JPAShop.INSTANCE.getCustomerRegistry();
//        orderBook = (OrderBook)JPAShop.INSTANCE.getOrderBook();
//        addr = new Address("Gatan", 15, "GOTEBAAAARG");
//        customerOne = new Customer(addr, "fornamn", "efternamn", "email.com", "apa", "apa");
//        customerOne.setIsAdmin(true);
//        prod = new Product("ProdNamn", 123, 1L, 1L);
//        
//    }
//
//    @AfterClass
//    public static void tearDownClass() {
//        customerReg = null;
//        
//    }
//    
//    
//    @Test
//    public void testAddCustomer()
//    {
//        Address addr = new Address("Gatan", 15, "GOTEBAAAARG");
//        Customer cus1 = new Customer(addr, "fornamn", "efternamn", "email.com","username", "password");
//        customerReg.add(cus1);
//        Customer cus2 = customerReg.find(cus1.getId());
//        Assert.assertEquals(cus1.toString(), cus2.toString());
//        removeCustomer(cus1);
//        Customer cus3 = customerReg.find(cus1.getId());
//        Assert.assertNull(cus3);
//    }
//    
//    private void removeCustomer(Customer customer)
//    {
//        customerReg.remove(customer.getId());
//    }
//    /**
//     * Add product to cart and create purchaseorder which adds to the orderbook
//     * then remove and check
//     */
//    @Test
//    public void testOrderbook()
//    {

//        customerOne.addProductToCart(prod);
//        PurchaseOrder po = customerOne.finishShopping();
//        orderBook.add(po);
//        PurchaseOrder po2 = orderBook.find(po.getId());
//        Assert.assertEquals(po.toString(), po2.toString());
//        orderBook.remove(po.getId());
//        PurchaseOrder po3 = orderBook.find(po.getId());
//        Assert.assertNull(po3);

//    }
//    
//}
