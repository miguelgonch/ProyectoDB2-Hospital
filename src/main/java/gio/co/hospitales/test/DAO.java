/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gio.co.hospitales.test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author migue
 */
public class DAO {
    public static List<Producto> getProductos(){
        List<Producto> lista = new ArrayList();
        Producto producto = new Producto(1,"Hola",500);
        Producto producto2 = new Producto(2,"Hola2",500);
        Producto producto3 = new Producto(3,"Hola3",500);
        Producto producto4 = new Producto(4,"Hola4",500);
        Producto producto5 = new Producto(5,"Hola5",500);
        lista.add(producto);
        lista.add(producto2);
        lista.add(producto3);
        lista.add(producto4);
        lista.add(producto5);
        return lista;
    }
}
