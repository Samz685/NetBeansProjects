/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author FranciscoRomeroGuill
 */
@Data
@NoArgsConstructor
public class Alumno implements Serializable {
    
    private Integer id;
    
    private String nombre;
    private String apellidos;
    private String curso;
    
}
