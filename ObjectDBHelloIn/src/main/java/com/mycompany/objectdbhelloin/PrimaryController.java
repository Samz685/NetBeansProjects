package com.mycompany.objectdbhelloin;

import models.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class PrimaryController implements Initializable {

    @FXML
    private TableColumn<Usuario, Integer> cId;
    @FXML
    private TableColumn<Usuario, String> cAlias;
    @FXML
    private TableColumn<Usuario, String> cPassword;
    @FXML
    private TableView<Usuario> tabla;

    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("data.odb");
        
        
            EntityManager em = emf.createEntityManager();
            System.out.println("Conexión realizada con exito");
            Usuario u = new Usuario();
            u.setAlias("Sam");
            u.setPassword("1234");
            em.getTransaction().begin();
            System.out.println(u);
            em.persist(u);
            
            em.getTransaction().commit();
            em.close();
            
            cId.setCellValueFactory(new PropertyValueFactory("id"));
            cAlias.setCellValueFactory(new PropertyValueFactory("nombre"));
            cPassword.setCellValueFactory(new PropertyValueFactory("categoria"));
            
            em = emf.createEntityManager();
            TypedQuery<Usuario> q = em.createQuery("select u from Usuario u",Usuario.class);
            for (Usuario u : q.getResultList()){
                tabla.getItems().add(u);
                
            }
            em.close();
            
            

    }
}
