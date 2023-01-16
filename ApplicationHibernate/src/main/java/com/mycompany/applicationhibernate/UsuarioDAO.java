/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.applicationhibernate;

import models.Mensaje;
import models.Usuario;


/**
 *
 * @author Syzer
 */
public interface UsuarioDAO {
    
    public void save(Usuario u);
    
    public void update(Usuario u);
    
    public Usuario get(Integer id);
    
    public void delete(Usuario u);
    
}
