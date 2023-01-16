package com.mycompany.clasefile;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClaseFilee {
    
    public static void main(String[] args){
        
        File f = new File("carpeta");
        
            if(f.exists()){
                System.out.println("Archivo ya existe");
                
            } else {
                System.out.println("Creando archivo");
                f.mkdir();
           
    }
     File f1 = new File("carpeta"+File.separatorChar+"archivo1.txt");
        
            if(f1.exists()){
                System.out.println("Archivo ya existe");
                
            } else {
                try{
                    System.out.println("Creando archivo");
                    f1.createNewFile();
                }  catch (IOException ex) {
            Logger.getLogger(ClaseFilee.class.getName()).log(Level.SEVERE, null, ex);
        }           
                }
            
            File d = new File(".");
            System.out.println(d.getAbsolutePath());
            
            for(File archivo : d.listFiles()) {
                Boolean esArchivo = archivo.isFile();
                
                System.out.println(
                        (esArchivo?"[F]":"[D]")+        
                        archivo.getName()+ " / " +
                        archivo.length()+"bytes");
            }
                 
}
}