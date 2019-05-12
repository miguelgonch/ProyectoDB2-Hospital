/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gio.co.hospital.correos;

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
 * Servlet implementation class AddCita
 */
@WebServlet("/sendEmailP")
public class sendEmailP extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static int hospitalNum = JavaConnectDb.getHospNum();

    ;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public sendEmailP() {
        super();
        // TODO Auto-generated constructor stub
    }

    // Generar jsons
 /*  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            
    }*/

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        try {
            //Obtener parametros
            String nombreP, apellidoP, correoP, correoPserver, correodot, citaFecha, docName, subcat;
            nombreP = request.getParameter("nombrep");
            apellidoP = request.getParameter("apellidop");
            correoP = request.getParameter("correop");
            correoPserver = request.getParameter("correoPserver");
            //correodot = request.getParameter("correodot");
            //citaId = request.getParameter("citaid");
            citaFecha = request.getParameter("fecha");
            docName = request.getParameter("docName");
            subcat = request.getParameter("subcat");
            
            
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("gioscompanies@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(correoP+"@"+correoPserver)
            );
            message.setSubject("Cita del "+citaFecha);
            message.setText("Estimado@: "+nombreP+" "+apellidoP+" ,"
                    + "\n\n El motivo del correo es para recordarle que tiene una cita asignada para el "+citaFecha+"."
                    +"\n\n La cita sera para "+subcat+" con el Dr. "+docName+"."
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
}



















