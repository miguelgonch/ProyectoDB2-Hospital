/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gio.co.hospitales;

import java.sql.Connection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import gio.co.hospitales.JavaConnectDb;

/**
 *
 * @author migue
 */
public class JavaConnectDbTest {
    
    public JavaConnectDbTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getHospNum method, of class JavaConnectDb.
     */
    @Test
    public void testGetHospNum() {
        System.out.println("getHospNum");
        int expResult = 1;
        int result = JavaConnectDb.getHospNum();
        assertEquals(expResult, result);
    }    
}
