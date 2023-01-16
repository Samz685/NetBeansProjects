package com.mycompany.copiaarchivos;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;


public class copia {

    
    public static void copiaBinaria(String origen, String destino){
        
        try {
            //creamos los flujos de lectura y escritura
          
            FileInputStream fis = new FileInputStream(origen);
            FileOutputStream fos = new FileOutputStream(new File(destino));
            
            int b = 0;
            
            
            // creamos el bucle para leer el archivo y copiarlo
            try {
                while( (b = fis.read()) > 0 ){   //primero se lee el fis y despues se compara a 0
                    fos.write(b);               //escribir en el flujo de output
                }
            } catch (IOException ex) {
                Logger.getLogger(copia.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {                   //cerramos el flujo
                fos.close();
                fis.close();
                
            } catch (IOException ex) {
                Logger.getLogger(copia.class.getName()).log(Level.SEVERE, null, ex);
            }
            
           
        } catch (FileNotFoundException ex) {
            Logger.getLogger(copia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
    }
    
    
    public static void copiaTextoBuffered(String origen, String destino){ //Se copian lineas enteras de texto del archivo
        
        try (var fr = new BufferedReader(new FileReader(origen));
             var fw = new BufferedWriter(new FileWriter(destino))
            ){
            
             String s;
             while((s=fr.readLine())!=null){
                System.out.println(s);
                s=s.toUpperCase();
                fw.write(s);
                fw.newLine();
            
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(copia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(copia.class.getName()).log(Level.SEVERE, null, ex);
        }     
         
       
        
        
    }
    
    
    public static void copiaTextoBufferedLines(String origen, String destino){ //metodo para introducir el contenido del archivo en forma DE LISTA con el .toList
        
        try (var fr = new BufferedReader(new FileReader(origen));
             var fw = new BufferedWriter(new FileWriter(destino))
            ){
            
            /* String s;
             
             ArrayList<String> lineas = new ArrayList<String>();
             lineas.addAll(fr.lines().toList());
             System.out.println(lineas);
             */
            
            Iterator<String> it = fr.lines().iterator(); //iterator sirve como puntero que se coloca al principio y con el while de abajo va hasta el final
            
            while(it.hasNext()){
                String s = it.next();
                System.out.println(it.next());
                System.out.println(s.length());
            }
            
             
        } catch (FileNotFoundException ex) {
            Logger.getLogger(copia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(copia.class.getName()).log(Level.SEVERE, null, ex);
        }     
         
       
        
        
    }
    public static void main(String[] args) {
        
        copiaTextoBufferedLines("pom.xml" , "pom_bak.xml");
        
    }
    
}
