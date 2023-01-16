/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controllers;

import java.util.ArrayList;
import models.Alumno;

/**
 *
 * @author FranciscoRomeroGuill
 */
public interface AlumnoDAO {
    
    Alumno get(Integer id);
    
    void add(Alumno a);
    
    void update(Alumno a);
    
    ArrayList<Alumno> getAll();
    
    void delete(Alumno a);
    
    void delete(Integer id);
    
    ArrayList<Alumno> getAllByCurso(String curso);
        
}
