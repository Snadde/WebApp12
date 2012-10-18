package core;

//import java.util.ArrayList;
//import java.util.List;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
//import junit.framework.Assert;
//import org.junit.AfterClass;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
///**
// *
// * @author hajo
// */
//public class TestAll {
//
//    private static EntityManagerFactory emf;
//
//    @BeforeClass
//    public static void setUpClass() throws Exception {
//        emf = Persistence.createEntityManagerFactory("shop_test_pu");
//    }
//
//    @AfterClass
//    public static void tearDownClass() throws Exception {
//        emf.close();
//    }
//
//    @Test
//    public void testCascade() {
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//        Address adress = new Address("Tempgata", 2, "tempstad");
//        Customer customer = new Customer(adress,"","","","","");
//        Product b1 = new Product("abc", 111F, 1L, 1L);
//        Product b2 = new Product("def", 222F,1L, 1L);
//        Product b3 = new Product("ghi", 333F,1L, 1L);
//        customer.addProductToCart(b1);
//        customer.addProductToCart(b2);
//        customer.addProductToCart(b3);
//        PurchaseOrder order; 
//        order = customer.finishShopping();
//        
//     
//        tx.begin();
//        em.persist(order); // Cascade will do the work, see Author1MBi
//        tx.commit();
//
//        
//        PurchaseOrder order2 = em.find(PurchaseOrder.class, order.getId());
//        Customer tempCustomer = order2.getCustomer();
//        Customer tempCustomer2 = em.find(Customer.class, customer.getId());
//        
//        Assert.assertEquals(customer, tempCustomer2);
//        Assert.assertEquals(customer, tempCustomer);
//        
//        //order2.getItems().get(0).getProduct().toString();
//        //Assert.assertEquals(b3.getName(), order2.getItems().get(0).getProduct().getName());
//       // Assert.assertEquals(b2, order2.getItems().get(1));
//      //  Assert.assertEquals(b1, order2.getItems().get(2));
//        
////        tmp = a2.getBooks().get(1);
////        Assert.assertEquals(tmp, b2);
////
////        tmp = a2.getBooks().get(2);
////        Assert.assertEquals(tmp, b3);
//        em.close();
//
//    }
//
////    @Test
////    public void testReverseCascade() {
////        EntityManager em = emf.createEntityManager();
////        EntityTransaction tx = em.getTransaction();
////
////        Author1MBi a1 = new Author1MBi("aaa", null);
////        List<Book1MBi> books = new ArrayList<Book1MBi>();
////        Book1MBi b1 = new Book1MBi("abc", 111F, "x");
////        books.add(0, b1);
////
////        a1.setBooks(books);
////        b1.setAuthor(a1);
////
////        tx.begin();
////        //em.persist(a1);   If no cascade must do this
////        em.persist(b1);
////        tx.commit();
////
////        Book1MBi b2 = em.find(Book1MBi.class, b1.getId());
////
////        Assert.assertTrue(true);
////
////    }
//}
