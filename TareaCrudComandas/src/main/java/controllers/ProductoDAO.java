
package controllers;

import java.util.ArrayList;
import models.Producto;


public interface ProductoDAO {

    Producto verProducto(Integer idPro);

    void update(Producto p);

    ArrayList<Producto> verCarta();

}
