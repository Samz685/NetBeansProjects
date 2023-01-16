/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacionhibernate;

import java.util.List;
import models.Usuario;
import org.hibernate.Transaction;

/**
 *
 * @author FranciscoRomeroGuill
 */
public class UsuarioDAOHib implements UsuarioDAO {

    @Override
    public void save(Usuario u) {
        try(var s = HibernateUtil.getSessionFactory().openSession()){
            Transaction t = s.beginTransaction();
            s.save(u);
            t.commit();
        }
    }

    @Override
    public void update(Usuario u) {
        try(var s = HibernateUtil.getSessionFactory().openSession()){
            Transaction t = s.beginTransaction();
            s.update(u);
            t.commit();
        }
    }

    @Override
    public Usuario get(Integer id) {
        try(var s = HibernateUtil.getSessionFactory().openSession()){
            return s.get(Usuario.class,id);            
        }
    }

    @Override
    public void delete(Usuario u) {
        try(var s = HibernateUtil.getSessionFactory().openSession()){
            Transaction t = s.beginTransaction();
            s.delete(u);
            t.commit();
        }
    }

    @Override
    public List<Usuario> getAll() {
        try(var s = HibernateUtil.getSessionFactory().openSession()){
            var q = s.createQuery("from Usuario");
            return q.list();
        }

    }
    
}
