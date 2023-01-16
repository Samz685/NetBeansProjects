/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.sumaarray;

import java.util.ArrayList;

/**
 *
 * @author Syzer
 */
public class SumaArray {

    public static void main(String[] args) {
        
        ArrayList<Producto> result = new ArrayList<>();
        
        String c1 = "Rojo";
        String c2 = "Verde";
        String c3 = "Azul";
        String c4 = "Amarillo";
        
        ArrayList<String> colores = new ArrayList<>();
        colores.add(c1);
        colores.add(c2);
        colores.add(c3);
        colores.add(c4);
        
        
        Producto btn1 = new Producto();
        btn1.setNombre("a");
        Producto btn2 = new Producto();
        btn2.setNombre("b");
        Producto btn3 = new Producto();
        btn3.setNombre("c");
        Producto btn4 = new Producto();
        btn4.setNombre("d");
        
        ArrayList<Producto> botones = new ArrayList<>();
        botones.add(btn1);
        botones.add(btn2);
        botones.add(btn3);
        botones.add(btn4);
        
        System.out.println(botones.toString());
        
        int i = 0;
//        for(i = 0 ; i<= botones.size()-1; i++){
//            result.add(botones.get(i));
//            System.out.println(botones.get(i).toString());
//            
//        }
       
        for (i = 0; i<=  botones.size(); i++) {

            btn1.setColor(colores[i]);

            result.add(btn1);


        }
                
        
        
//        for (int i = 1; i < 4; i++) {
//            
//            Producto temp = new Producto();
//            temp.setNombre("btn"+i);
//            System.out.println(temp);
//            temp.setNombre("boton"+i);
//            System.out.println(temp);
//            
//            
//        }
        
//        Producto p1 = new Producto();
//        p1.setNombre("a");
//        p1.setPrecio(5);
//        
//        Producto p2 = new Producto();
//        p2.setNombre("b");
//        p2.setPrecio(5);
//        
//        Producto p3 = new Producto();
//        p3.setNombre("c");
//        p3.setPrecio(5);
//        
//        ArrayList<Producto> productos = new ArrayList();
//        productos.add(p1);
//        productos.add(p2);
//        productos.add(p3);
//        
//        
//        System.out.println(productos.toString());
//        
//       Integer suma = 0;
//        for (Producto p : productos) {
//            
//           suma += p.getPrecio();
//            
//        }
//        
//        System.out.println(suma+"€");


        
    }
}
