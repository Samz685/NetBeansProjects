/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;


import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Usuario implements Serializable {
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    
    private String alias;
    
    @OneToMany(mappedBy="fromUser")
    private List<Mensaje> mensajesEnviados;
    
    @OneToMany(mappedBy="toUser")
    private List<Mensaje> mensajesRecibidos;
    
    public void send(String msg, Usuario dest){
        
        
        Mensaje m = new Mensaje();
        m.setFromUser(this);
        m.setToUser(dest);
        m.setContent(msg);
        mensajesEnviados.add(m);
        dest.getMensajesRecibidos().add(m);
        
        
    }
    
}
