package gio.co.hospital.ws.cita;

import java.io.IOException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author migue
 */

public class CitasResourceTest {
    
    @Mock
    HttpServletRequest request;
    
    @Mock
    HttpServletResponse response;
    
    public CitasResourceTest() {
    }
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetCita() throws IOException {
        System.out.println("getCita");
        when(request.getParameter("pId")).thenReturn("1");
        
        String pId = "1";
        String docId = "";
        String citaId = "";
        
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);

        when(response.getWriter()).thenReturn(pw);

        CitasResource instance = new CitasResource();
        instance.getCita(pId, docId, citaId);
        String expResult = "id=\"1\"";
        String result = sw.getBuffer().toString().trim();
        assertThat(result, CoreMatchers.containsString(expResult));
    }
/*
    @Test
    public void testGetDisp() {
        System.out.println("getDisp");
        String fecha = "";
        int docId = 0;
        CitasResource instance = new CitasResource();
        Response expResult = null;
        Response result = instance.getDisp(fecha, docId);
        assertEquals(expResult, result);
    }

    @Test
    public void testAddCita() {
        System.out.println("addCita");
        int pId = 0;
        String dateCita = "";
        String hora = "";
        int sId = 0;
        int citaId = 0;
        int seg = 0;
        int docId = 0;
        CitasResource instance = new CitasResource();
        Response expResult = null;
        Response result = instance.addCita(pId, dateCita, hora, sId, citaId, seg, docId);
        assertEquals(expResult, result);
    }

    @Test
    public void testUpdateCita() {
        System.out.println("updateCita");
        int citaId = 0;
        String dateCita = "";
        String hora = "";
        int sId = 0;
        String diag = "";
        String pasos = "";
        String res = "";
        String obsrv = "";
        String meds = "";
        int docId = 0;
        CitasResource instance = new CitasResource();
        Response expResult = null;
        Response result = instance.updateCita(citaId, dateCita, hora, sId, diag, pasos, res, obsrv, meds, docId);
        assertEquals(expResult, result);
    }

    @Test
    public void testDeleteCita() {
        System.out.println("deleteCita");
        int citaId = 0;
        CitasResource instance = new CitasResource();
        Response expResult = null;
        Response result = instance.deleteCita(citaId);
        assertEquals(expResult, result);
    }

    @Test
    public void testMakeList() {
        System.out.println("makeList");
        String pId = "";
        String citaId = "";
        String pDocId = "";
        CitasResource instance = new CitasResource();
        instance.makeList(pId, citaId, pDocId);
    }
    */
}
