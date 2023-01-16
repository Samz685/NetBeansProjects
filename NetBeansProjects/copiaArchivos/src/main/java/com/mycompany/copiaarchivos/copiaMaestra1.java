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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FranciscoRomeroGuill
 */
public class copiaMaestra1 {

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
            Logger.getLogger(copiaMaestra1.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
             
     public static void saveArrayList(ArrayList<String> a, String out){
         
        try {
            var fos = new FileOutputStream(out);
            var oos = new ObjectOutputStream(fos);
            
            oos.writeObject(a);
            oos.close();
            fos.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(copiaMaestra1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(copiaMaestra1.class.getName()).log(Level.SEVERE, null, ex);
        }
                 
     }
     
     public static ArrayList<String> loadArrayList(String in) {
         
         ArrayList<String> salida = new ArrayList<String>();
         
        try {
            var fis = new FileInputStream(in);
            var fos = new ObjectInputStream(fis);
            
            salida = (ArrayList<String>) fos.readObject();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(copiaMaestra1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(copiaMaestra1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(copiaMaestra1.class.getName()).log(Level.SEVERE, null, ex);
        }
         return salida;
     }
     
    
    public static void main(String[] args) {

        //procesadoScanner("numeros.txt");
        
        String s="""
                 What is Lorem Ipsum?
                 Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.
                 Why do we use it?
                 It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).
                 Where does it come from?
                 Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of "de Finibus Bonorum et Malorum" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, "Lorem ipsum dolor sit amet..", comes from a line in section 1.10.32.
                 The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from "de Finibus Bonorum et Malorum" by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.
                 Where can I get some?
                 There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.""";
        
        
        s = s.replace("\"", "");
        s = s.replace("'", "");
        String[] palabras= s.split("[\\s,.:()?!¿¡-]");
        
        ArrayList<String> total = new ArrayList<String>();
        
        for(String ss :palabras){        
            total.add(ss);
        }
        //saveArrayList(tota, "datos.bin");
        System.out.println(total);
        
        total = loadArrayList("datos.bin");
        System.out.println("total");
        
        
    }
    
}
