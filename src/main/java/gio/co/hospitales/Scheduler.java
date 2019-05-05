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
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Scheduler implements ServletContextListener {
    private Thread t = null;
    private ServletContext context;
    public void contextInitialized(ServletContextEvent contextEvent) {
        t =  new Thread(){
            //task
            public void run(){                
                try {
                    while(true){
                        System.out.println("Thread running every second");
                        Thread.sleep(1000);
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