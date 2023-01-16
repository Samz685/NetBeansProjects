/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.appalumnos;

import controlador.AlumnoDAOMySQL;
import modelos.Alumno;

/**
 *
 * @author MichanGalvanJamai
 */
public class NewMain {

    static AlumnoDAOMySQL dao = new AlumnoDAOMySQL();
    
    public static void main(String[] args) {
       
        
        
        Alumno a = new Alumno();
        a.setNombre("Hicham");
        a.setApellidos("Galvan Jamai");
        a.setCurso("2ºDAM");
        System.out.println(a.toString());
        
        
        dao = new AlumnoDAOMySQL();
        dao.add(a);
        
        
        
    }
    
}
