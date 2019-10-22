/*
 * Test clase para la conexion con servidor JAVA
 */
package gio.co.hospitales;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 *
 * @author migue
 */
@RunWith(MockitoJUnitRunner.class)
public class JavaConnectDbTest {

    @InjectMocks
    private JavaConnectDb javaConnectDb;
    @Mock
    private Connection mockConnection;
    @Mock
    DataSource mockDataSource;

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
     * Test of getHospNum este etrega el numero de hospital en el que se esta
     * trabajando
     */
    @Test
    public void testGetHospNum() {
        System.out.println("getHospNum");
        int expResult = 1;
        int result = JavaConnectDb.getHospNum();
        assertEquals(expResult, result);
    }

    /**
     * Test of connectDbH method, se prueba si se genera una conexion correcta
     * con el jdbc
     */
    @Test
    public void testConnectDbH() throws SQLException {
        System.out.println("connectDbH");

        Connection conn = javaConnectDb.connectDbH(1);
        assertThat(conn, instanceOf(Connection.class));
    }

}
