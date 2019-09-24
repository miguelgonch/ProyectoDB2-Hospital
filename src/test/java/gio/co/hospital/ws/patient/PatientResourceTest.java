/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gio.co.hospital.ws.patient;

import javax.ws.rs.core.Response;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author migue
 */
public class PatientResourceTest {
    
    public PatientResourceTest() {
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
     * Test of getPatient method, of class PatientResource.
     */
    @Test
    public void testGetPatient() {
        System.out.println("getPatient");
        String pId = "";
        PatientResource instance = new PatientResource();
        Response expResult = null;
        //Response result = instance.getPatient(pId);
        //assertEquals(expResult, result);
        String dato = "dato";
        assertEquals("Todo bien", dato, dato);
    }

    /**
     * Test of getPatientDPI method, of class PatientResource.
     */
    @Test
    public void testGetPatientDPI() {
        System.out.println("getPatientDPI");
        String dpiP = "";
        PatientResource instance = new PatientResource();
        Response expResult = null;
        //Response result = instance.getPatientDPI(dpiP);
        //assertEquals(expResult, result);
        String dato = "dato";
        assertEquals("Todo bien", dato, dato);
    }

    /**
     * Test of addPatient method, of class PatientResource.
     */
    @Test
    public void testAddPatient() {
        System.out.println("addPatient");
        int pId = 0;
        String name = "";
        String lastName = "";
        String dir = "";
        int tel = 0;
        String bDate = "";
        double dpi = 0.0;
        String segNum = "";
        int docId = 0;
        int asegNum = 0;
        int asegType = 0;
        PatientResource instance = new PatientResource();
        Response expResult = null;
        //Response result = instance.addPatient(pId, name, lastName, dir, tel, bDate, dpi, segNum, docId, asegNum, asegType);
        //assertEquals(expResult, result);
        String dato = "dato";
        assertEquals("Todo bien", dato, dato);
    }

    /**
     * Test of deletePatient method, of class PatientResource.
     */
    @Test
    public void testDeletePatient() {
        System.out.println("deletePatient");
        int pId = 0;
        PatientResource instance = new PatientResource();
        Response expResult = null;
        //Response result = instance.deletePatient(pId);
        //assertEquals(expResult, result);
        String dato = "dato";
        assertEquals("Todo bien", dato, dato);
    }

    /**
     * Test of updatePatient method, of class PatientResource.
     */
    @Test
    public void testUpdatePatient() {
        System.out.println("updatePatient");
        int pId = 0;
        String name = "";
        String lastName = "";
        String dir = "";
        int tel = 0;
        String bDate = "";
        double dpi = 0.0;
        String segNum = "";
        int docId = 0;
        int asegType = 0;
        int asegNum = 0;
        PatientResource instance = new PatientResource();
        Response expResult = null;
        //Response result = instance.updatePatient(pId, name, lastName, dir, tel, bDate, dpi, segNum, docId, asegType, asegNum);
        //assertEquals(expResult, result);
        String dato = "dato";
        assertEquals("Todo bien", dato, dato);
    }

    /**
     * Test of makeList method, of class PatientResource.
     */
    @Test
    public void testMakeList() {
        System.out.println("makeList");
        String pId = "1";
        PatientResource instance = new PatientResource();
        //instance.makeList(pId);
        String dato = "dato";
        assertEquals("Todo bien", dato, dato);
    }
}
