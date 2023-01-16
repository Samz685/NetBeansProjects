/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacionhibernate;

import models.Mensaje;
import org.hibernate.Transaction;

/**
 *
 * @author FranciscoRomeroGuill
 */
public class MensajeDAOHib implements MensajeDAO {

    @Override
    public void save(Mensaje m) {
        try(var s = HibernateUtil.getSessionFactory().openSession()){
            Transaction t = s.beginTransaction();
            s.save(m);
            t.commit();
        }
    }

    @Override
    public void update(Mensaje m) {
        try(var s = HibernateUtil.getSessionFactory().openSession()){
            Transaction t = s.beginTransaction();
            s.update(m);
            t.commit();
        }
    }

    @Override
    public Mensaje get(Integer id) {
        try(var s = HibernateUtil.getSessionFactory().openSession()){
            return s.get(Mensaje.class, id);
        }
    }

    @Override
    public void delete(Mensaje m) {
        try(var s = HibernateUtil.getSessionFactory().openSession()){
            Transaction t = s.beginTransaction();
            s.remove(m);
            t.commit();
        }
    }
    
}
