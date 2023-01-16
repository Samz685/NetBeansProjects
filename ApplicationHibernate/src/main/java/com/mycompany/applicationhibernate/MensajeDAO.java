/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.applicationhibernate;

import models.Mensaje;

/**
 *
 * @author Syzer
 */
public interface MensajeDAO {
    
    
    public void save(Mensaje m);
    
    public void update(Mensaje m);
    
    public Mensaje get(Integer id);
    
    public void delete(Mensaje m);
    
  
    
    
    
    
}
