/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Syzer
 */
public class Alumno implements Serializable {
    
    String nombre;
    String apellidos;
    String contraseña;
    String dni;
    Date fecha;
    String email;
    String telefono;
    Empresa empresa;
    Profesor profesor;
    int horasDual;
    int horasFct;
    String observaciones;
    
}
