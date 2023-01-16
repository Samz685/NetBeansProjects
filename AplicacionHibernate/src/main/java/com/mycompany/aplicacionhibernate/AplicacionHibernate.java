/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.aplicacionhibernate;

import java.util.ArrayList;
import java.util.Scanner;
import models.Mensaje;
import models.Usuario;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 *
 * @author FranciscoRomeroGuill
 */
public class AplicacionHibernate {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
 
        Scanner sc= new Scanner(System.in);
        
        var gestorUsuarios = new UsuarioDAOHib();
                
        System.out.println("¿quien eres?");
        Integer orig=sc.nextInt();
        sc.nextLine();        
    
        Usuario origen = gestorUsuarios.get(orig);
                
        gestorUsuarios.getAll().forEach( (u)->{
            System.out.println(u.getId()+") "+u.getAlias());
        });

        System.out.println("Puedes empezar a chatear...");
        
        while(true){
            
            String msg=sc.nextLine();
            if("q".equals(msg)) System.exit(0);
            
            Integer dest=sc.nextInt();
            sc.nextLine();
            
            origen.send(msg, gestorUsuarios.get(dest));            
            gestorUsuarios.update(origen);
            
            origen.getMensajesEnviados().forEach( (u)->{
                System.out.println(u.getToUser()+") "+u.getContent());
            });            
            origen.getMensajesRecibidos().forEach( (u)->{
                System.out.println(u.getToUser().getAlias()+") "+u.getContent());
            });                        
        }
        
        //MensajeDAO gestorMensajes;     
        //gestorMensajes = new MensajeDAOHib();
     
        
        
//        Usuario u1 = gestorUsuarios.get(1);
//        Usuario u2 = gestorUsuarios.get(2);
//        
//        u1.send("Hola carabola", u2);
//        gestorUsuarios.update(u1);
//        gestorUsuarios.update(u2);
//        
//        System.out.println(u1);
//        System.out.println(u2);
        
 //       gestorUsuarios.delete(gestorUsuarios.get(1));
        
//        Mensaje m = new Mensaje();
//        
//        m.setContent("Mensaje de prueba con hibernate");      
//        
//              
//        m.setFromUser( gestorUsuarios.get(1) );
//        m.setToUser( gestorUsuarios.get(2)  );
//        
//        gestorMensajes.save(m);
//
//        m.setContent("Mensaje de prueba con hibernate v2");       
//        gestorMensajes.update(m);
//        
        
    }
    
//        try( Session s = HibernateUtil.getSessionFactory().openSession()){
//            Query q = s.createQuery("from Usuario");
//            
//            for(Usuario u : (ArrayList<Usuario>)q.list()){
//                System.out.println(u.getAlias());
//                
//                for(Mensaje m : u.getMensajesEnviados()){
//                    System.out.println("ENVIADO A "+ m.getToUser().getAlias() +":" + m.getContent());
//                }
//                for(Mensaje m : u.getMensajesRecibidos()){
//                    System.out.println("RECIBIDO DE "+ m.getToUser().getAlias() +":" + m.getContent());
//                }
//            }
//        }
//    }
    
}
