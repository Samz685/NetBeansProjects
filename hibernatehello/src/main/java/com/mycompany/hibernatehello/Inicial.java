
package com.mycompany.hibernatehello;

import models.Persona;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;




public class Inicial {

   static SessionFactory sf;
    
    public static void main(String[] args) {
       
        
        sf = new Configuration().configure().buildSessionFactory();
        var s = sf.openSession();
        
        var p = new Persona();
        p.setNombre("Hicham");
        p.setApellidos("Galvan");
        p.setCurso("2DAM");
        
        
        
    }
    
}
