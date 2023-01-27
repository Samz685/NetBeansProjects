//package dao;
//
//
//import dao.ObjectDBUtil;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import javax.persistence.TypedQuery;
//import models.ProductoData;
//
//
//
//public class ProductoDataDAO {
//    
//    private static final String VENTAS_MES = "SELECT pr.nombre as nProducto, sum(pr.precio) as suma \n"
//            + "FROM Producto pr \n"
//            + "INNER JOIN Pedido p ON pr.nombre = p.producto.nombre \n"
//            + "WHERE pr.nombre IN (SELECT p2.producto.nombre FROM Pedido p2) \n"
//            + "AND p.fecha > :fechaIntervalo \n"
//            + "GROUP BY pr.nombre";
//    private static final String VENTAS_SEMANA = "SELECT pr.nombre as nProducto, sum(pr.precio) as suma \n"
//            + "FROM Producto pr \n"
//            + "INNER JOIN Pedido p ON pr.nombre = p.producto.nombre \n"
//            + "WHERE pr.nombre IN (SELECT p2.producto.nombre FROM Pedido p2) \n"
//            + "AND p.fecha > :fechaIntervalo \n"
//            + "GROUP BY pr.nombre";
//    private static final String VENTAS_HOY = "SELECT pr.nombre as nProducto, sum(pr.precio) as suma \n"
//            + "FROM Producto pr JOIN pr.pedido p WHERE p.fecha = CURRENT_DATE group by pr.nombre";
//    
//    public ArrayList<ProductoData> traerVentasHoy() {
//        
//        ArrayList<ProductoData> listaVentas = new ArrayList
//        
//        var em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
//        TypedQuery<Object[]> q = em.createQuery("SELECT pr.nombre as nProducto, sum(pr.precio) as suma \n"
//                + "FROM Producto pr JOIN pr.pedido p WHERE p.fecha =:hoy group by pr.nombre", Object[].class);
//        q.setParameter("hoy", LocalDate.now());
//        List<Object[]> rows = q.getResultList();
//        em.close();
//
//        for (Object[] row : rows) {
//                ProductoData pV = new ProductoData();
//                pV.setNombre(row[0].toString());
//                pV.setVenta(Integer.parseInt(row[1].toString()));
//                listaVentas.add(pV);
//            }
//
//       
//        return listaVentas;
//    }
//    
////    public ArrayList<ProductoData> traerVentasSemana() {
////        
////        ArrayList<ProductoData> listaVentas = new ArrayList
////        var em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
////        TypedQuery<Object[]> q = em.createQuery(VENTAS_SEMANA,ProductoData.class);
////        List<Object[]> rows = (List<Object[]>)q.getResultList();
////        em.close();
////
////        for (Object[] row : rows) {
////                ProductoData pV = new ProductoData();
////                pV.setNombre(row[0].toString());
////                pV.setVenta(Integer.parseInt(row[1].toString()));
////                listaVentas.add(pV);
////            }
////
////       
////        return listaVentas;
////    }
////    
////    public ArrayList<ProductoData> traerVentasMes() {
////        
////        ArrayList<ProductoData> listaVentas = new ArrayList
////        var em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
////        TypedQuery<Object[]> q = em.createQuery(VENTAS_MES,ProductoData.class);
////        List<Object[]> rows = (List<Object[]>)q.getResultList();
////        em.close();
////
////        for (Object[] row : rows) {
////                ProductoData pV = new ProductoData();
////                pV.setNombre(row[0].toString());
////                pV.setVenta(Integer.parseInt(row[1].toString()));
////                listaVentas.add(pV);
////            }
////
////       
////        return listaVentas;
////    }
//    
//    
//            
//    
//}
