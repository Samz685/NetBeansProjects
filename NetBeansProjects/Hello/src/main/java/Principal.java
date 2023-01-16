
import com.mysql.cj.xdevapi.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Principal {

  
    public static Connection conexion;
    public static final String URL =
                                     "jdbc:mysql://localhost:3306/accesoadatos"
                                 +    "?zeroDateTimeBehavior=CONVERT_TO_NULL";
    public static final String USER = "root";
    public static final String PASSWORD = "";
    
    
    
    public static void main(String[] args) {
        try {
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);                   //INICIAR CONECTOR CON LOS PARAMETROS
            System.out.println("Conectando...");
            
            Statement st = conexion.createStatement();                                     //SE CREA LA CONSULTA SQL
            String consulta = "select * from hello";
            
                                                                                            //SE EJECUTA LA CONSULTA MEDIANTE ExecuteQuery
            ResultSet resultado = st.executeQuery(consulta);                                //es la forma de recorrer un resultset (el resultado de la consulta)
            while(resultado.next()){                                                        //mientras hayan datos que leer (next)
                Integer id = resultado.getInt("id");
                String nombre = resultado.getString("nombre");
                System.out.println("ID: " +id);
                System.out.println("Nombre: "+nombre);
                System.out.println("---------------");
                
            }
            
            int filasafectadas = st.executeUpdate(consulta);
            
            consulta = "INSERT INTO  hello (id, nombre) VALUES (NULL, 'Lopez')";
            st.executeUpdate(consulta);
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      
        
        
    }
    
}
