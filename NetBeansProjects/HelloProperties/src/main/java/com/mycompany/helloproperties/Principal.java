
package com.mycompany.helloproperties;

import java.awt.RenderingHints;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Principal {

    
    public static void main(String[] args) {
        
        try {
            
            var fis = Principal.class.getClassLoader().getResourceAsStream("config.properties");     //variable para el la lectura del flujo - getResource crea el flujo para el archivo
            
            var config = new Properties();
            
            config.load(fis);                       //se carga en el objeto PROPERTIES(config) la variable FIS que tiene el valor del archivo config que hemos creado
            /* config.forEach((k,v) -> {               //for each para imprimir los dos valores que existen en el archivo config(ejemplo: user=valor)
            
            System.out.println(k + " = " + v);
        });*/
            
           
            String user = null;
            if(config.containsKey("user")){                                                 //si el archivo config contiene el valor "user" entonces...
                user = config.getProperty("user");                                          //Se crea la variable user para meter dentro el valor del archivo confir(por ejemplo el nombre)
                
                config.setProperty("user", user+" m6");                                      //se setea la clave "user" y el valor con lo que queramos añadir
                config.store(new FileOutputStream("src/main/resources/config.properties") , "Comentario");     //config.store para salvar el archivo y usamos FileOutputStream para escribir en el archivo
            }                                                                                                  //el segundo parametro es para añadir un comentario
            System.out.println(user);
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
