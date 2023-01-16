//package controllers;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import static java.sql.Statement.RETURN_GENERATED_KEYS;
//import java.util.ArrayList;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import models.Pedido;
//import models.Producto;
//
//public class PedidoDAOmySQL implements PedidoDAO {
//
//    ////Sentencias SQL-----------------------------------------------------------------
//    private static final String GET_QUERY = "select * from pedido where idPed=?";
//    private static final String GETALL_QUERY = "SELECT * FROM pedido ORDER BY idPed";
//    private static final String INSERT_QUERY = """
//                INSERT INTO pedido 
//                        (idPed, fecha, cliente, producto, estado) 
//                VALUES  (NULL, ?, ?, ?, ?);""";
//    private static final String UPDATE_QUERY = """
//                UPDATE pedido SET
//                                              
//                    fecha = ?,
//                    cliente = ?,                                    
//                    producto = ?, 
//                    estado = ?                           
//                WHERE pedido.idPed = ?""";
//    private static final String GET_BY_CLIENT = "SELECT * FROM pedido WHERE idPed = ?";
//    private static final String DELETE_ID_QUERY = "DELETE FROM pedido WHERE idPed = ?";
//    private static final String CUANTOS_CLIENTES = "SELECT count(distinct cliente) from pedido";
//    private static final String GANANCIAS_ULTIMO_MES = """
//                                                SELECT sum(pr.precio)
//                                                from producto pr
//                                                INNER JOIN pedido p
//                                                ON p.producto = pr.nombre
//                                                where p.producto IN (SELECT producto from pedido)
//                                                and p.fecha > current_date - interval 1 month;""";
//
//    private static final String PEDIDOS_SEMANA = "SELECT count(*) FROM pedido where fecha > current_date - interval 1 week;";
//
//    private static final String PEDIDOS_PENDIENTES_HOY = "SELECT * FROM pedido where estado = 'PENDIENTE' and fecha = current_date();";
//
//    private static final String PRODUCTO_MAS_VENDIDO = """
//                                                       SELECT idPed, producto, count(producto)
//                                                       from pedido group by producto
//                                                       order by count(producto) desc limit 1
//                                                       """;
//
//    private static final String MEJOR_CLIENTE = """
//                                                SELECT idPed, cliente, count(cliente)
//                                                from pedido group by cliente
//                                                order by count(cliente) desc limit 1
//                                                """;
//
//    private static Connection conexion = Conexion.getConexion();
//
//    //---------------------------------------------------------------------------------
//    @Override
//    public Pedido verPedido(Integer idPed) {
//
//        try ( var pst = conexion.prepareStatement(GET_QUERY)) {
//
//            pst.setInt(1, idPed);
//
//            ResultSet resultado = pst.executeQuery();
//
//            if (resultado.next()) {
//                var pedido = new Pedido();
//                pedido.setIdPed(resultado.getInt("idPed"));
//                pedido.setFecha(resultado.getString("fecha"));
//                pedido.setCliente(resultado.getString("cliente"));
//                pedido.setEstado(resultado.getString("estado"));
//                pedido.setProducto(resultado.getString("producto"));
//
//                return pedido;
//            } else {
//                return null;
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(PedidoDAOmySQL.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return null;
//    }
//
//    @Override
//    public ArrayList<Pedido> verPedidoPendienteHoy() {
//        var salida = new ArrayList<Pedido>();
//
//        try ( var pst = conexion.prepareStatement(PEDIDOS_PENDIENTES_HOY)) {
//
//            ResultSet resultado = pst.executeQuery();
//
//            while (resultado.next()) {
//                var pedido = new Pedido();
//                pedido.setIdPed(resultado.getInt("idPed"));
//                pedido.setFecha(resultado.getString("fecha"));
//                pedido.setCliente(resultado.getString("cliente"));
//                pedido.setEstado(resultado.getString("estado"));
//                pedido.setProducto(resultado.getString("producto"));
//                salida.add(pedido);
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(PedidoDAOmySQL.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return salida;
//    }
//
//    
//    
//    @Override
//    public ArrayList<Pedido> verPedidoCliente(String cliente) {
//
//        var salida = new ArrayList<Pedido>();
//        
//
//        try ( var pst = conexion.prepareStatement(GETALL_QUERY)) {
//
//            ResultSet resultado = pst.executeQuery();
//
//            while (resultado.next()) {
//                var pedido = new Pedido();
//                
//                pedido.setIdPed(resultado.getInt("idPed"));
//                pedido.setFecha(resultado.getString("fecha"));
//                pedido.setCliente(resultado.getString("cliente"));
//                pedido.setEstado(resultado.getString("estado"));
//                pedido.setProducto(resultado.getString("producto"));
//                
//                if(pedido.getCliente().equals(cliente) ){
//                salida.add(pedido);
//                }
//                
//            }
//            
//
//
//        } catch (SQLException ex) {
//            Logger.getLogger(PedidoDAOmySQL.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return salida;
//
//    }
//
//    @Override
//    public int verGananciasMes() {
//        int ventaMes = 0;
//
//        try ( var pst = conexion.prepareStatement(GANANCIAS_ULTIMO_MES)) {
//
//            ResultSet resultado = pst.executeQuery();
//
//            if (resultado.next()) {
//                ventaMes = resultado.getInt(1);
//
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(PedidoDAOmySQL.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return ventaMes;
//    }
//
//    @Override
//    public int verTotalClientes() {
//        int totalClientes = 0;
//
//        try ( var pst = conexion.prepareStatement(CUANTOS_CLIENTES)) {
//
//            ResultSet resultado = pst.executeQuery();
//
//            if (resultado.next()) {
//                totalClientes = resultado.getInt(1);
//
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(PedidoDAOmySQL.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return totalClientes;
//    }
//
//    @Override
//    public String verMejorCliente() {
//        var salida = new Pedido();
//        String nombreCliente = "";
//
//        try ( var pst = conexion.prepareStatement(MEJOR_CLIENTE)) {
//
//            ResultSet resultado = pst.executeQuery();
//
//            while (resultado.next()) {
//                var pedido = new Pedido();
//                pedido.setIdPed(resultado.getInt("idPed"));
//                pedido.setCliente(resultado.getString("cliente"));
//                salida.setCliente(pedido.getCliente());
//                nombreCliente = salida.getCliente();
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(PedidoDAOmySQL.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return nombreCliente;
//    }
//
//    @Override
//    public int verPedidosSemana() {
//        int pedidosSemana = 0;
//
//        try ( var pst = conexion.prepareStatement(PEDIDOS_SEMANA)) {
//
//            ResultSet resultado = pst.executeQuery();
//
//            if (resultado.next()) {
//                pedidosSemana = resultado.getInt(1);
//
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(PedidoDAOmySQL.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return pedidosSemana;
//    }
//
//    @Override
//    public String verMasVendido() {
//        var salida = new Pedido();
//        String nombreProducto = "";
//
//        try ( var pst = conexion.prepareStatement(PRODUCTO_MAS_VENDIDO)) {
//
//            ResultSet resultado = pst.executeQuery();
//
//            while (resultado.next()) {
//                var pedido = new Pedido();
//                pedido.setIdPed(resultado.getInt("idPed"));
//                pedido.setProducto(resultado.getString("producto"));
//                salida.setProducto(pedido.getProducto());
//                nombreProducto = salida.getProducto();
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(PedidoDAOmySQL.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return nombreProducto;
//    }
//
//    @Override
//    public void añadir(Pedido p) {
//
//        try ( var pst = conexion.prepareStatement(INSERT_QUERY, RETURN_GENERATED_KEYS)) {
//
//            pst.setString(1, p.getFecha());
//            pst.setString(2, p.getCliente());
//            pst.setString(3, p.getProducto());
//            pst.setString(4, p.getEstado());
//
//            if (pst.executeUpdate() > 0) {
//
//                var keys = pst.getGeneratedKeys();
//                keys.next();
//
//                p.setIdPed(keys.getInt(1));
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(PedidoDAOmySQL.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
//
//    @Override
//    public void update(Pedido p) {
//
//        try ( var pst = conexion.prepareStatement(UPDATE_QUERY)) {
//
//            pst.setString(1, p.getFecha());
//            pst.setString(2, p.getCliente());
//            pst.setString(3, p.getProducto());
//            pst.setString(4, p.getEstado());
//            pst.setInt(5, p.getIdPed());
//
//            if (pst.executeUpdate() == 0) {
//                Logger.getLogger(PedidoDAOmySQL.class.getName()).severe("Pedido no existente.");
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(PedidoDAOmySQL.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
//
//    @Override
//    public ArrayList<Pedido> verComandas() {
//        var salida = new ArrayList<Pedido>();
//
//        try ( var pst = conexion.prepareStatement(GETALL_QUERY)) {
//
//            ResultSet resultado = pst.executeQuery();
//
//            while (resultado.next()) {
//                var pedido = new Pedido();
//                pedido.setIdPed(resultado.getInt("idPed"));
//                pedido.setFecha(resultado.getString("fecha"));
//                pedido.setCliente(resultado.getString("cliente"));
//                pedido.setEstado(resultado.getString("estado"));
//                pedido.setProducto(resultado.getString("producto"));
//                salida.add(pedido);
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(PedidoDAOmySQL.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return salida;
//    }
//
//    @Override
//    public void borrar(Integer idPed) {
//
//        try ( var pst = conexion.prepareStatement(DELETE_ID_QUERY)) {
//
//            pst.setInt(1, idPed);
//
//            if (pst.executeUpdate() == 0) {
//                Logger.getLogger(ProductoDAOmySQL.class.getName()).warning("Pedido no existe");
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(PedidoDAOmySQL.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
//
//}
