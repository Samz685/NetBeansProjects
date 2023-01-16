/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.copiaarchivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FranciscoRomeroGuill
 */
public class copiaMaestra {

    public static void copiaBinaria( String origen, String destino){
        
        try( FileInputStream fis = new FileInputStream(origen);
             FileOutputStream fos = new FileOutputStream( new File(destino)) ) {
            
                int b = 0;          
                while( (b = fis.read()) > 0  ) fos.write(b);
                
        } catch (FileNotFoundException ex) {
            Logger.getLogger(copia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(copia.class.getName()).log(Level.SEVERE, null, ex);
        }   
            
    }
    
    public static void copiaTexto( String origen, String destino){
        
        try( var fr = new FileReader(origen);
             var fw = new FileWriter(destino)){
            
            int c;
            while( (c=fr.read())>0){
                System.out.print( (char) c );
                fw.write(c);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(copia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }


    public static void copiaTextoBuffered( String origen, String destino){
        
        try( var fr = new BufferedReader(new FileReader(origen) );
             var fw = new BufferedWriter(new FileWriter(destino)) ){
            
            String s;
            
            while((s=fr.readLine())!=null){
                System.out.println(s);
                s=s.toUpperCase();
                fw.write(s);
                fw.newLine();
            }
            
        } catch (IOException ex) {
            Logger.getLogger(copia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
     public static void copiaTextoBufferedLines( String origen, String destino){
        
        try( var fr = new BufferedReader(new FileReader(origen) );
             var fw = new BufferedWriter(new FileWriter(destino)) ){
            
         /*
           for(String s :fr.lines().toList()){
               System.out.println(s);
           }
           */
         
           Iterator<String> it = fr.lines().iterator();
           
           while(it.hasNext()){
               String s = it.next();
               System.out.println(s.length());
               
           }
            
        } catch (IOException ex) {
            Logger.getLogger(copia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
     
     
     public static void procesadoScanner(String origen) {
         
         try {
         Scanner sc = new Scanner(new File(origen));
         sc.useDelimiter(",");  //las expresiones regulares empiezan con \ y \s* indica
         var listado = new ArrayList<Integer>();
         
         
         
         while(sc.hasNextInt()){
             listado.add(sc.nextInt());  //metiendo lo que escanea del archivo en un arraylist
         }
             System.out.println(listado);
             
             
         /*
             while(sc.hasNextLine()){   //alternativa con split
             for (String s: sc.nextLine().split(" ")){
                 System.out.println(s);      
             }   
         }
         */
     
        } catch (FileNotFoundException ex) {
            Logger.getLogger(copiaMaestra.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
             
     
    
    public static void main(String[] args) {

        procesadoScanner("numeros.txt");
    }
    
}
