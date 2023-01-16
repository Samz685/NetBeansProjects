
package controlador;

import java.util.ArrayList;
import modelos.Alumno;


public interface AlumnoDAO {
    
    Alumno get(Integer id);
    
    void add(Alumno a);
    
    ArrayList<Alumno> getAll();
    
    void delete(Alumno a);
    
    void delete(Integer id);
    
}
