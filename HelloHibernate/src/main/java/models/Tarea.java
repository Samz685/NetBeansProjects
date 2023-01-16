/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import static javax.persistence.GenerationType.IDENTITY;



import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor


public class Tarea implements Serializable {

    @Override
    public String toString() {
        return "Tarea{" + "id=" + id + ", nombre=" + nombre + ", modulo=" + modulo + ", alumno=" + alumno.getNombre() + '}';
    }
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    
    private Long id;
    
    private String nombre;
    private String modulo;
    
    @ManyToOne
    @JoinColumn(name="idAlumno")         //para referencias la columna que queremos
    private Alumno alumno;                //se crea un alumno aqui para que se sepa a quien perteneza la tarea
    
}