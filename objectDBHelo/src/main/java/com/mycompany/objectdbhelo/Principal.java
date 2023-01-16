/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.objectdbhelo;

import models.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Syzer
 */
public class Principal {

    public static void main(String[] args) {
      
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("data.odb");
        
        
            EntityManager em = emf.createEntityManager();
            System.out.println("Conexión realizada con exito");
            
            Usuario u = new Usuario();
            u.setAlias("Sam");
            u.setPassword("1234");
            
            
            em.getTransaction().begin();
            System.out.println(u);
            em.persist(u);
            
            em.getTransaction().commit();
            System.out.println(u);
            
               
    }
}
