/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gio.co.hospitales;

/**
 *
 * @author migue
 */
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Scheduler implements ServletContextListener {
    private Thread t = null;
    private ServletContext context;
    public void contextInitialized(ServletContextEvent contextEvent) {
	//System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
        t =  new Thread(){
            //task
            public void run(){  
                DateFormat dateFormat = new SimpleDateFormat("HH:mm");
                try {
                    while(true){
                        Date date = new Date();
                        String formated = dateFormat.format(date).toString();
                        Date date2 = new Date("2016/11/16 00:00:00");
                        String formated2 = dateFormat.format(date2).toString();
                        if(formated.equals(formated2)){
                            System.out.println("Funcionaaaa!!! WUJUUUUU");
                            //Cada 24 horas 86400 segundos
                            Thread.sleep(86400000);
                        }
                    }
                } catch (InterruptedException e) {}
            }            
        };
        t.start();
        context = contextEvent.getServletContext();
        // you can set a context variable just like this
        context.setAttribute("TEST", "TEST_VALUE");
    }
    public void contextDestroyed(ServletContextEvent contextEvent) {
        // context is destroyed interrupts the thread
        t.interrupt();
    }            
}