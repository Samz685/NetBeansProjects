
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import static java.sql.Statement.RETURN_GENERATED_KEYS;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Alumno;


public class AlumnoDAOMySQL implements AlumnoDAO {
    
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:mysql://localhost:3306/accesoadatos";
    
    private static Connection conexion;
    private static final String GET_QUERY = "select * from alumno where id=?";
    private static final String INSERT_QUERY = "insert into alumno (id, nombre, apellidos, curso) VALUES (NULL, ?, ?, ?)";
    private static final String GETALL_QUERY="select * from alumno";
    private static final String DELETE_QUERY = "DELETE from alumno WHERE id=?";
    
    static{
        try {
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexion realizada con éxito!");
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    

    @Override
    public Alumno get(Integer id) {
        
       try(var pst = conexion.prepareStatement(GET_QUERY);){
           
           pst.setInt(1, id);
           ResultSet resultado = pst.executeQuery();
           
           if(resultado.next()){
               var alumno = new Alumno();
               alumno.setId(resultado.getInt("id"));
               alumno.setNombre(resultado.getString("nombre"));
               alumno.setApellidos(resultado.getString("apellidos"));
               alumno.setCurso(resultado.getString("curso"));
               
           }else{
               return null;
           }
                   
       } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    @Override
    public void add(Alumno a) {
        
        try( var pst = conexion.prepareStatement(INSERT_QUERY, RETURN_GENERATED_KEYS)){
            
            pst.setString(1, a.getNombre());
            pst.setString(2, a.getApellidos());
            pst.setString(3, a.getCurso());
            
            if(pst.executeUpdate() > 0){
                
                var keys = pst.getGeneratedKeys();
                keys.next();
                
                a.setId(keys.getInt(1));
                
                
            } 
            
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public ArrayList<Alumno> getAll() {
        
        var salida = new ArrayList<Alumno>();
        
        try(var pst = conexion.prepareStatement(GETALL_QUERY)){
            
            ResultSet resultado = pst.executeQuery();
            
            while(resultado.next()){
               Alumno alumno = new Alumno();
               alumno.setId(resultado.getInt("id"));
               alumno.setNombre(resultado.getString("nombre"));
               alumno.setApellidos(resultado.getString("apellidos"));
               alumno.setCurso(resultado.getString("curso"));
               salida.add(alumno);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    @Override
    public void delete(Integer id) {
        try( var pst = conexion.prepareStatement(DELETE_QUERY)){
            pst.setInt(1, id);
            pst.executeUpdate();
            if(pst.executeUpdate() == 0){
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AlumnoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        
    }

    @Override
    public void delete(Integer id) {
       
    }
    
    
}
