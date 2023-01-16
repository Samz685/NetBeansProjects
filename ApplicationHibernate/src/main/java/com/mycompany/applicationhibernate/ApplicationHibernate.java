/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.applicationhibernate;

import java.util.ArrayList;
import models.Mensaje;
import models.Usuario;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 *
 * @author Syzer
 */
public class ApplicationHibernate {

    public static void main(String[] args) {
      
        
        var gestorMensajes = new MensajeDAOHib();
        
        var gestorUsuarios = new UsuarioDAOHib();
        
        
        
        
        
        
        
        //gestorUsuarios.get(1).send("Buenos dias!!", gestorUsuarios.get(2));
        
        
        
//        Mensaje m = new Mensaje();
//        
//        m.setContent("Mensaje de prueba con hibernate");
//        
//        Session s = HibernateUtil.getSessionFactory().openSession();
//        
//        m.setFromUser(gestorUsuarios.get(1));
//        m.setToUser(gestorUsuarios.get(2));
//        
//        s.close();
//        
//        gestorMensajes.save(m);
//        
//        m.setContent("Mensaje de prueba con hibernate v2");
//        gestorMensajes.update(m);
        
        
        
       
//        try (Session s = HibernateUtil.getSessionFactory().openSession()){
//            Query q = s.createQuery("from Usuario");
//            
//            for(Usuario u : (ArrayList<Usuario>)q.list()){
//                System.out.println(u.getAlias());
//                
//                for(Mensaje m : u.getMensajesEnviados()){
//                    System.out.println("Enviado a " + m.getToUser().getAlias()+":" + m.getContent());
//                }
//                
//                for(Mensaje m : u.getMensajesRecibidos()){
//                    System.out.println("Recibidos de " + m.getToUser().getAlias()+":" + m.getContent());
//                }
//            }
//            
//        } catch (Exception e) {
//        }
    }
}
