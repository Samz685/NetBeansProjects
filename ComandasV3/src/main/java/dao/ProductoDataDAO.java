package dao;


import dao.ObjectDBUtil;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import models.Producto;
import models.ProductoData;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class ProductoDataDAO {
    
    private static final String VENTAS_MES = "SELECT pr.nombre as nProducto, sum(pr.precio) as suma FROM producto pr\n"
            + "INNER JOIN pedido p\n"
            + "WHERE pr.nombre = p.producto\n"
            + "and pr.nombre in (SELECT producto FROM pedido)\n"
            + "and p.fecha > current_date - interval 1 month\n"
            + "group by pr.nombre";
    private static final String VENTAS_SEMANA = "SELECT pr.nombre as nProducto, sum(pr.precio) as suma FROM producto pr\n"
            + "INNER JOIN pedido p\n"
            + "WHERE pr.nombre = p.producto\n"
            + "and pr.nombre in (SELECT producto FROM pedido)\n"
            + "and p.fecha > current_date - interval 1 week\n"
            + "group by pr.nombre";
    private static final String VENTAS_HOY = "SELECT pr.nombre as nProducto, sum(pr.precio) as suma FROM producto pr\n"
            + "INNER JOIN pedido p\n"
            + "WHERE pr.nombre = p.producto\n"
            + "and pr.nombre in (SELECT producto FROM pedido)\n"
            + "and p.fecha = current_date\n"
            + "group by pr.nombre";
    
    public ArrayList<ProductoData> traerVentasHoy() {
        
        ArrayList<ProductoData> listaVentas = new ArrayList
        var em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        TypedQuery<Object[]> q = em.createQuery(VENTAS_HOY,ProductoData.class);
        List<Object[]> rows = (List<Object[]>)q.getResultList();
        em.close();

        for (Object[] row : rows) {
                ProductoData pV = new ProductoData();
                pV.setNombre(row[0].toString());
                pV.setVenta(Integer.parseInt(row[1].toString()));
                listaVentas.add(pV);
            }

       
        return listaVentas;
    }
    
    public ArrayList<ProductoData> traerVentasSemana() {
        
        ArrayList<ProductoData> listaVentas = new ArrayList
        var em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        TypedQuery<Object[]> q = em.createQuery(VENTAS_SEMANA,ProductoData.class);
        List<Object[]> rows = (List<Object[]>)q.getResultList();
        em.close();

        for (Object[] row : rows) {
                ProductoData pV = new ProductoData();
                pV.setNombre(row[0].toString());
                pV.setVenta(Integer.parseInt(row[1].toString()));
                listaVentas.add(pV);
            }

       
        return listaVentas;
    }
    
    public ArrayList<ProductoData> traerVentasMes() {
        
        ArrayList<ProductoData> listaVentas = new ArrayList
        var em = ObjectDBUtil.getEntityManagerFactory().createEntityManager();
        TypedQuery<Object[]> q = em.createQuery(VENTAS_MES,ProductoData.class);
        List<Object[]> rows = (List<Object[]>)q.getResultList();
        em.close();

        for (Object[] row : rows) {
                ProductoData pV = new ProductoData();
                pV.setNombre(row[0].toString());
                pV.setVenta(Integer.parseInt(row[1].toString()));
                listaVentas.add(pV);
            }

       
        return listaVentas;
    }
    
    
            
    
}
