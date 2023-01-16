/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.aplicacionhibernate;

import java.util.List;
import models.Mensaje;
import models.Usuario;

/**
 *
 * @author FranciscoRomeroGuill
 */
public interface UsuarioDAO {
    public void save( Usuario m);
    public void update( Usuario m);
    public Usuario get( Integer id);
    public void delete( Usuario m);
    public List<Usuario> getAll();
}
