/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author FranciscoRomeroGuill
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
public class Mensaje implements Serializable {

    public Mensaje() {
        time = new Date();
    }
    
    @Id
    @GeneratedValue(strategy=IDENTITY)
    private Integer id;
    
    private String content;
    
    private Date time;
    
    @ManyToOne
    @JoinColumn(name="from_user")
    private Usuario fromUser;
    
    @ManyToOne
    @JoinColumn(name="to_user")
    private Usuario toUser;

    @Override
    public String toString() {
        return "Mensaje{" + "id=" + id + ", content=" + content + 
                ", time=" + time + ", fromUser=" + fromUser.getAlias() + 
                ", toUser=" + toUser.getAlias() + '}';
    }
    
    
}
