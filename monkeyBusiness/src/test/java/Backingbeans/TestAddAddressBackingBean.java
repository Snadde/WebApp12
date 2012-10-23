/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Backingbeans;

import backingbeans.AddAddressBackingBean;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This class tests the getters and setters for AddAddressBackingBean
 *
 * @author thituson
 */
public class TestAddAddressBackingBean {

    private AddAddressBackingBean bean;

    public TestAddAddressBackingBean() {
    }

    @Before
    public void setUp() {
        bean = new AddAddressBackingBean();
    }

    @After
    public void tearDown() {
        bean = null;
    }

    /**
     * Tests all the getters and setters
     */
    @Test
    public void testGettersAndSetters() {
        String street = "tempStreet";
        String town = "tempTown";
        int nbr = 5;
        bean.setStreet(street);
        Assert.assertEquals(bean.getStreet(),street);
        bean.setNbr(nbr);
        Assert.assertTrue(bean.getNbr()==nbr);
        bean.setTown(town);
        Assert.assertEquals(bean.getTown(),town);
    }
}
