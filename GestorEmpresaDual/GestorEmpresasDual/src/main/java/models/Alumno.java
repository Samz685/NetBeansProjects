
package models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Alumno implements Serializable {
    
    @Id
    @GeneratedValue(strategy=IDENTITY)
    
    int id;
    String nombre;
    String apellidos;
    String password;
    String dni;
    LocalDate fecha_nac;
    String email;
    String telefono;
    int horas_dual;
    int horas_fct;
    String observaciones;
    String tipo;
    Boolean login;
    
    @Transient
    private Integer horasRealizadasFCT;
    
    @Transient
    private Integer horasRealizadasDUAL;
    
    @Transient
    private Integer horasRestantesFCT;
    
    @Transient
    private Integer horasRestantesDUAL;
    
    
    @OneToMany( mappedBy="alumno", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Actividad> actividades;
    
    @ManyToOne
    @JoinColumn(name="tutor_id")
    Profesor profesor;
    
    @ManyToOne
    @JoinColumn(name="empresa_id")
    Empresa empresa;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(LocalDate fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getHoras_dual() {
        return horas_dual;
    }

    public void setHoras_dual(int horas_dual) {
        this.horas_dual = horas_dual;
    }

    public int getHoras_fct() {
        return horas_fct;
    }

    public void setHoras_fct(int horas_fct) {
        this.horas_fct = horas_fct;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Set<Actividad> getActividades() {
        return actividades;
    }

    public void setActividades(Set<Actividad> actividades) {
        this.actividades = actividades;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Integer getHorasRealizadasFCT() {
        return horasRealizadasFCT;
    }

    public void setHorasRealizadasFCT(Integer horasRealizadasFCT) {
        this.horasRealizadasFCT = horasRealizadasFCT;
    }

    public Integer getHorasRealizadasDUAL() {
        return horasRealizadasDUAL;
    }

    public void setHorasRealizadasDUAL(Integer horasRealizadasDUAL) {
        this.horasRealizadasDUAL = horasRealizadasDUAL;
    }

    public Integer getHorasRestantesFCT() {
        return horasRestantesFCT;
    }

    public void setHorasRestantesFCT(Integer horasRestantesFCT) {
        this.horasRestantesFCT = horasRestantesFCT;
    }

    public Integer getHorasRestantesDUAL() {
        return horasRestantesDUAL;
    }

    public void setHorasRestantesDUAL(Integer horasRestantesDUAL) {
        this.horasRestantesDUAL = horasRestantesDUAL;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Boolean getLogin() {
        return login;
    }

    public void setLogin(Boolean login) {
        this.login = login;
    }

    
    
    
    
    
    @Override
    public String toString() {
        return "Alumno{" + "id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos +
                ", dni=" + dni + ", email=" + email + ", telefono=" + telefono + ", profesor="
                + profesor.nombre + ", empresa=" + empresa.nombre+", actividades=" + actividades +'}';
    }

    

   
    
    

    
}
