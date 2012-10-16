/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author thituson
 */
public class InitiateDB {
 private static IProductCatalogue productCatalogue;
   
 @BeforeClass
    public static void setUpClass() {
       
        productCatalogue = (ProductCatalogue) JPAShop.INSTANCE.getProductCatalogue();
    }

    @AfterClass
    public static void tearDownClass() {
        productCatalogue = null;
        
    }

    @Test
    public void Init() {
//         
//        Product product1 = new Product( "King Kong", 125000F, 10L, 6L);
//        product1.setImageLink("http://localhost:8080/monkeyBusiness/resources/images/kong2.jpg");
//        Product product2 = new Product( "King Loui", 50000F, 9L, 7L);
//        product2.setImageLink("http://localhost:8080/monkeyBusiness/resources/images/king.jpeg");
//        Product product3 = new Product( "New Monkey", 123000F, 1L, 7L);
//        product3.setImageLink("http://localhost:8080/monkeyBusiness/resources/images/lesula_525.jpeg");
//        Product product4 = new Product( "Einstein", 12300F, 8L, 7L);
//        product4.setImageLink("http://localhost:8080/monkeyBusiness/resources/images/einstein.jpeg");
//        Product product5 = new Product( "Angry", 123F, 1L, 8L);
//        product5.setImageLink("http://localhost:8080/monkeyBusiness/resources/images/angry-monkey.jpg");
//        Product product6 = new Product( "Ugly", 12F, 1L, 9L);
//        product6.setImageLink("http://localhost:8080/monkeyBusiness/resources/images/ugly.jpeg");
//        Product product7 = new Product( "Rastafari", 1230F, 4L, 3L);
//        product7.setImageLink("http://localhost:8080/monkeyBusiness/resources/images/rastamonkey.jpeg");
//        Product product8 = new Product( "Surprised", 5230F, 3L, 4L);
//        product8.setImageLink("http://localhost:8080/monkeyBusiness/resources/images/images2.jpeg");
//        Product product9 = new Product( "Old Monkey", 5230F, 3L, 7L);
//        product9.setImageLink("http://localhost:8080/monkeyBusiness/resources/images/images.jpeg");
//
//        productCatalogue.add(product1);
//        productCatalogue.add(product2);
//        productCatalogue.add(product3);
//        productCatalogue.add(product4);
//        productCatalogue.add(product5);
//        productCatalogue.add(product6);
//        productCatalogue.add(product7);
//        productCatalogue.add(product8);
//        productCatalogue.add(product9);
    }
    
    
}