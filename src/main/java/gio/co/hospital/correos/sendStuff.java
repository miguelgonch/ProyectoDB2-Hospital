/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gio.co.hospital.correos;


import gio.co.hospital.ws.cita.Citas;
import gio.co.hospitales.JavaConnectDb;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;
import org.json.JSONObject;

import gio.co.hospitales.JavaConnectDb;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import gio.co.hospitales.JavaConnectDb;
import static java.lang.System.out;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author manu
 */

//@WebServlet("/sendStuff")

public class sendStuff /*extends HttpServlet*/{
    
    //private static final long serialVersionUID = 1L;
    private static final long serialVersionUID = 1L;
    private static int hospitalNum = JavaConnectDb.getHospNum();
    
    //private static final long serialVersionUID = 1L;
  //  private static int hospitalNum = JavaConnectDb.getHospNum();

       /*
    public sendStuff(){
        super();
    }*/
    
    public static void enviar() { 
    //protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Response info
        final String username = "gioscompanies@gmail.com";
        final String password = "gioSEGUROhospital!";

        Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        
        
        Connection conn = gio.co.hospitales.JavaConnectDb.connectDbH(hospitalNum);
        //response.setContentType("application/json");
        //response.setCharacterEncoding("UTF-8");
        //PrintWriter out = response.getWriter();
        try {
            //var query sql
            
            String sql;
              
            
                sql = "SELECT P.NOMBRE, P.APELLIDO, P.EMAIL, C.CITA_ID, C.DOC_ID, C.PACIENTE_ID, C.FECHA, U.NOMBRE AS MIDOC, U.APELLIDO AS MIDOCTOR, U.USUARIO_ID, S.SUBCAT FROM CITAS C INNER JOIN PACIENTES P ON C.PACIENTE_ID=P.PACIENTE_ID  INNER JOIN USUARIO U ON C.DOC_ID=U.USUARIO_ID INNER JOIN SUBCATEGORIA S ON C.ID_SUBCAT=S.ID_SUBCAT WHERE C.FECHA>SYSDATE AND C.FECHA<SYSDATE+3";
                
            OraclePreparedStatement pst = (OraclePreparedStatement) conn.prepareStatement(sql);
            OracleResultSet rs = (OracleResultSet) pst.executeQuery();
            while (rs.next()) {
              
                String nombreP = rs.getString("nombre");
                String apellidoP = rs.getString("apellido");
                String emailP = rs.getString("email");
                String fechaC = rs.getString("fecha");
                //String nombreDoc = rs.getString("midoc");
                String apellidoDoc = rs.getString("midoctor");
                String subcat = rs.getString("subcat");
                
            try {               
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("gioscompanies@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(emailP)
            );
            message.setSubject("Cita del "+fechaC);
            message.setText("Estimado@: "+nombreP+" "+apellidoP+" ,"
                    + "\n\n El motivo del correo es para recordarle que tiene una cita asignada para el "+fechaC+"."
                    +"\n\n La cita sera para "+subcat+" con el Dr. "+apellidoDoc+"."
                    +"\n\n Gracias por elegir GioHospitales"
                    +"\n\n "
                    +"\n\n "
                    +"\n\n Por favor no responder este correo.");

            Transport.send(message);

            //out.println("Done");
            
             } catch (Exception e) {
            System.err.println(e);
        }
                         
              }
                rs.close();
              pst.close();
              conn.close();
              
              
                             
           

             } catch(SQLException e){
                  
                     System.err.println(e);
                 }
    
    }
    
    /*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }*/
    
}
    

   






















































