/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jpa_shop;

import core.*;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hajo
 */
public class TestAdd {

    private static ProductCatalogue preg;


    @BeforeClass
    public static void setUpClass() {
        preg = (ProductCatalogue) JPAShop.INSTANCE.getProductCatalogue();

        
    }

    @AfterClass
    public static void tearDownClass() {
        preg = null;
        
    }

    // Database will generate id's 
//    @Test
//    public void addProduct() {
//        Product p = new Product("test", 999);
//
//        // We have no cascade her so have to insert all
//        // in correct order (Cascade better)
//        preg.add(p);  // pnumb set after this operation
//        Product pp = preg.find(p.getId());
//        System.out.println(p);
//        
//        System.out.println(pp);
//        Assert.assertTrue(p.toString().equals(pp.toString()));
//
//    }
    
    @Test
    public void testSearch() {
       Product p = new Product("test", 999, 1L);
       Product p1 = new Product("test2", 888, 1L);
       Product p2 = new Product("test3", 666,1L);
       Product p3 = new Product("hej", 1999,1L);
       Product p4 = new Product("1hej", 1337,1L);
       Product p5 = new Product("2hej", 50,1L);
       Product result;
       preg.add(p);
       preg.add(p1);  
       preg.add(p2);  
       preg.add(p3);  
       preg.add(p4);  
       preg.add(p5);
       //test getById
       result = preg.getById(p.getId());
       Assert.assertTrue(p.toString().equals(result.toString()));
       //test getByPrice
       List<Product> results2 = preg.getByPrice(1337);
       Assert.assertTrue(results2.get(0).getName().equals("1hej"));
       //test getByNameLike
       List<Product> results = preg.getByNameLike("test");
     //  Assert.assertTrue(results.size()==3);
        
        
    }
}
