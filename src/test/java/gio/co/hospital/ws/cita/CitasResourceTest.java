package gio.co.hospital.ws.cita;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;

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
        String expResult = "";
        String result = sw.getBuffer().toString().trim();
        assertThat(result, CoreMatchers.containsString(expResult));
    }

    @Test
    public void testGetDisp() {
        System.out.println("getDisp");
        String fecha = "";
        int docId = 0;
        CitasResource instance = new CitasResource();
        Response result = instance.getDisp(fecha, docId);
        assertThat(result, instanceOf(Connection.class));
    }
}
