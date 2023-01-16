/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.prueba;

import java.io.File;

/**
 *
 * @author Syzer
 */
public class Prueba {

    public static void main(String[] args) {
        
        String archivo = "textito.txt";
        
        File file = new File(archivo);
        
        String ubicacion = file.getAbsolutePath();
        System.out.println(ubicacion);
        
        
    }
}
