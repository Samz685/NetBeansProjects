package controllers;

import java.util.ArrayList;
import models.Pedido;
import models.Producto;

public interface PedidoDAO {

    Pedido verPedido(Integer idPed);

    ArrayList<Pedido> verPedidoPendienteHoy();
    
    ArrayList<Pedido> verPedidoCliente(String cliente);

    int verGananciasMes();

    int verTotalClientes();

    String verMejorCliente();

    int verPedidosSemana();

    String verMasVendido();

    void añadir(Pedido p);

    void update(Pedido p);

    void borrar(Integer idPed);

    ArrayList<Pedido> verComandas();

}
