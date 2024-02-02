
package com.mycompany.bitacora.logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;




/**
 *
 * @author Jonathan Abarca
 */
@Entity
public class PuntoVaciado implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_PuntoVaciado;
    
    @Basic
    private String numCalle;
    private String numPunto;
    
    @OneToOne
    ComponentesOP id_Componente;

    public PuntoVaciado() {
    }

    public PuntoVaciado(int id_PuntoVaciado, String numCalle, String numPunto, ComponentesOP id_Componente) {
        this.id_PuntoVaciado = id_PuntoVaciado;
        this.numCalle = numCalle;
        this.numPunto = numPunto;
        this.id_Componente = id_Componente;
    }

    public int getId_PuntoVaciado() {
        return id_PuntoVaciado;
    }

    public void setId_PuntoVaciado(int id_PuntoVaciado) {
        this.id_PuntoVaciado = id_PuntoVaciado;
    }

    public String getNumCalle() {
        return numCalle;
    }

    public void setNumCalle(String numCalle) {
        this.numCalle = numCalle;
    }

    public String getNumPunto() {
        return numPunto;
    }

    public void setNumPunto(String numPunto) {
        this.numPunto = numPunto;
    }

    public ComponentesOP getId_Componente() {
        return id_Componente;
    }

    public void setId_Componente(ComponentesOP id_Componente) {
        this.id_Componente = id_Componente;
    }
    
    
            
}
