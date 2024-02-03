
package com.mycompany.bitacora.logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 *
 * @author Jonathan Abarca
 */
@Entity
public class Reparaciones implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_Reparaciones;
    
    private String calle;
    private String punto;
    private String fecha;
    private String estado;
    private String nombre;
    private String turno;
    private String grupo;
    private String descrip;      

    public Reparaciones() {
    }

    public Reparaciones(int id_Reparaciones, String calle, String punto, String fecha, String estado, String nombre, String turno, String grupo, String descrip) {
        this.id_Reparaciones = id_Reparaciones;
        this.calle = calle;
        this.punto = punto;
        this.fecha = fecha;
        this.estado = estado;
        this.nombre = nombre;
        this.turno = turno;
        this.grupo = grupo;
        this.descrip = descrip;
    }

    public int getId_Reparaciones() {
        return id_Reparaciones;
    }

    public void setId_Reparaciones(int id_Reparaciones) {
        this.id_Reparaciones = id_Reparaciones;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getPunto() {
        return punto;
    }

    public void setPunto(String punto) {
        this.punto = punto;
    }

    public String getFecha() {
        return fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }
    
    
}

