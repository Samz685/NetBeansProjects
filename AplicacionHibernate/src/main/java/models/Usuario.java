
package models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
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
@NoArgsConstructor
@AllArgsConstructor
//@Table(name="usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy=IDENTITY)
    private Integer id;
    
    private String alias;
    
    @OneToMany( mappedBy="fromUser", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Mensaje> mensajesEnviados;
    
    @OneToMany( mappedBy="toUser", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Mensaje> mensajesRecibidos;
    
    public void send(String msg, Usuario dest){
        Mensaje m = new Mensaje();
        m.setFromUser(this);
        m.setToUser(dest);
        m.setContent(msg);
        mensajesEnviados.add(m);
        dest.getMensajesRecibidos().add(m);
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", alias=" + alias + ", mensajesEnviados=" + mensajesEnviados + ", mensajesRecibidos=" + mensajesRecibidos + '}';
    }
    
}
