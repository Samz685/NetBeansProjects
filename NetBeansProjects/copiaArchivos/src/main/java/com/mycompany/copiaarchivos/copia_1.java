package com.mycompany.copiaarchivos;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class copia_1 {

    
    public static void copiaBinaria(String origen, String destino){
        
        try( FileInputStream fis = new FileInputStream(origen);
            FileOutputStream fos = new FileOutputStream(new File(destino))) {
            
            int b = 0;
            while( (b = fis.read()) > 0 ){
            
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(copia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(copia1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }
    
        
        public static void copiaTexto( String origen, String destino) {
            
            
            try(var fr = new FileReader(origen);
                var fw = new FileWriter(destino) ){
                
                int c;
                while( (c = fr.read())>0){
                    System.out.println((char)c);
                    fw.write(c);
                    
                }
            } catch (FileNotFoundException ex) {
            Logger.getLogger(copia_1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(copia_1.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    
        
    
        
    
        
    
    
    public static void main(String[] args) {
        
        
        copiaBinaria("pom.xml" , "pom_bak.xml");
        
    }
    
}
        