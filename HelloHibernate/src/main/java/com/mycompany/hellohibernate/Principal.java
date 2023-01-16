/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.hellohibernate;

import java.util.ArrayList;
import java.util.Scanner;
import models.Alumno;
import models.Tarea;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 *
 * @author FranciscoRomeroGuill
 */
public class Principal {

    public static void main(String[] args) {
        
        
        //creando tarea --------------------------
        var sf = new Configuration().configure().buildSessionFactory();
        
        try( Session s = sf.openSession()){
            
            var tarea = new Tarea();
            tarea.setNombre("Preparar Examen PMDM");
            tarea.setModulo("PMDM");
            
           Alumno a1 = s.get(Alumno.class, 3);
           
           if( a1 != null){
               tarea.setAlumno(a1);
               a1.getTareas().add(tarea);
           } ;
            System.out.println("------------tarea creada--------------");
            System.out.println(tarea);
            
            Transaction t = s.beginTransaction();
            s.save(tarea);
            s.update(a1);
            t.commit();
            
            
        }
        
        try( Session s = sf.openSession()){             
            Query consulta = s.createQuery("from Tarea");     
            ArrayList<Tarea> listado = (ArrayList<Tarea>) consulta.list();        
            
            listado.forEach((a1)->{System.out.println(a1);});
    }
        System.out.println("------------Alumnos------------");
        
        try( Session s = sf.openSession()){             
            Query consulta = s.createQuery("from Alumno");     
            ArrayList<Alumno> listadoAl = (ArrayList<Alumno>) consulta.list();        
            
            listadoAl.forEach((a1)->{System.out.println(a1);});
    }
        
    }
    
    
    public static void main2(String[] args) {

        var sf = new Configuration().configure().buildSessionFactory();
        var sc = new Scanner(System.in);
        //----------------------------------------
        var a = new Alumno();
        System.out.println("escribe tu nombre, apellidos y curso: ");
        a.setNombre(sc.nextLine());
        a.setApellidos(sc.nextLine());
        a.setCurso(sc.nextLine());
        //----------------------------------------
        
        try( Session s = sf.openSession()){             //se crea la sesion
            Transaction t = s.beginTransaction();       //aqui creamos la transaccion SOLO hace falta para escribir o borrar algo de la BDD
            
            s.save(a);                               //guardamos la transaccion con el alumno creado
            
            t.commit();                                //ejecutamos la transaccion
            
        }
        
        System.out.println("----------ALUMNADO----------");
        
        ArrayList<Alumno> listado;
        
        try( Session s = sf.openSession()){             
            Query consulta = s.createQuery("from alumno");      //creamos una consulta HQL
            listado = (ArrayList<Alumno>) consulta.list();        //ejecuta la consulta y me devuelve una lista y la casteo a arraylist
            
            listado.forEach((a1)->{System.out.println(a1);});
    }
        //-------------------------------Prueba para actualizar alumno-------------
        System.out.println("forzando curso...");
        a.setCurso("DAM");
        try( Session s = sf.openSession()){           
            Transaction t = s.beginTransaction();       
            s.update(a);                              
            t.commit();       
        }
        //-------------------------------Prueba para eliminar alumno-------------    
            System.out.println("Borrando alumno...");
            try( Session s = sf.openSession()){           
                Transaction t = s.beginTransaction();       
                s.delete(a);                              
                t.commit(); 
            // t = s.beginTransaction();
            //s.delete(a);                              
            //t.commit();
            }
            System.out.println("Borrando alumno con ID concreto...");
            try( Session s = sf.openSession()){           
                Transaction t = s.beginTransaction();
                Alumno paraborrar = s.get(Alumno.class, 7);
                System.out.println(paraborrar);
                
                s.delete(paraborrar);
                t.commit();
            
            }
            
}
}
