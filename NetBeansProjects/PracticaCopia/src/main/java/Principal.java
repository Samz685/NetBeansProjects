import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Alumno;

public class Principal {
    
    static ArrayList<models.Alumno> clase;
    static final String ARCHIVO = "archivo.bin";
    
    
    static{
        System.out.println("Iniciando...");
        clase = new ArrayList<>();
    }
    
    public static void saveData(){
        
        try( var fos = new FileOutputStream(ARCHIVO);
             var oos = new ObjectOutputStream(fos)  ) {
            
            oos.writeObject(clase);
            
             } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
              
    } 
    
    

    public static void loadData(){
        
        
        if(!(new File(ARCHIVO)).exists()){                      //si el archivo NO EXISTE no hacer nada
            System.out.println("El archivo no existe");
            return;
        }
                   
        
        try (
            FileInputStream fis = new FileInputStream(ARCHIVO);         //crear flujo para escribir bytes
            ObjectInputStream ois = new ObjectInputStream(fis))         //crear flujo para escribir object
        {
            clase = (ArrayList<Alumno>) ois.readObject();               //leemos el archivo con OIS y metemos los datos en la variable de array clase
                    
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static void main(String[] args){
        
        
        
        Scanner sc = new Scanner(System.in);
        
        while(sc.hasNext()){
            String s = sc.nextLine();
            if(s.equals("q")) break;
            
            var a = new Alumno();
            a.setNombre(s);
            a.setApellido(sc.nextLine());
            a.setDni(sc.nextLine());
            clase.add(a);
            
            
        }
        
        System.out.println("-------------------------");
        saveData();
        //loadData();
        System.out.println(clase);
        

    }
    

}