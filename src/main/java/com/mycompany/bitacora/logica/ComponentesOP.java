
package com.mycompany.bitacora.logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Jonathan Abarca
 */
@Entity
public class ComponentesOP implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_Componentes;
    
    @Basic
    private int id_ComponentesInternos;
    private int id_PuntoVaciado;
    private int id_Alumbrado;
    private int id_CajaLocal;
    private int id_SeguridadGabinete;
    private int id_Historial;
    public ComponentesOP() {
    }

    public ComponentesOP(int id_Componentes, int id_PuntoVaciado, int id_Alumbrado, int id_CajaLocal, int id_SeguridadGabinete, int id_Historial, int id_ComponentesInternos) {
        this.id_Componentes = id_Componentes;
        this.id_PuntoVaciado = id_PuntoVaciado;
        this.id_Alumbrado = id_Alumbrado;
        this.id_CajaLocal = id_CajaLocal;
        this.id_SeguridadGabinete = id_SeguridadGabinete;
        this.id_Historial = id_Historial;
        this.id_ComponentesInternos = id_ComponentesInternos;
    }

    public int getId_Componentes() {
        return id_Componentes;
    }

    public void setId_Componentes(int id_Componentes) {
        this.id_Componentes = id_Componentes;
    }

    public int getId_PuntoVaciado() {
        return id_PuntoVaciado;
    }

    public void setId_PuntoVaciado(int id_PuntoVaciado) {
        this.id_PuntoVaciado = id_PuntoVaciado;
    }

    public int getId_Alumbrado() {
        return id_Alumbrado;
    }

    public void setId_Alumbrado(int id_Alumbrado) {
        this.id_Alumbrado = id_Alumbrado;
    }

    public int getId_CajaLocal() {
        return id_CajaLocal;
    }

    public void setId_CajaLocal(int id_CajaLocal) {
        this.id_CajaLocal = id_CajaLocal;
    }

    public int getId_SeguridadGabinete() {
        return id_SeguridadGabinete;
    }

    public void setId_SeguridadGabinete(int id_SeguridadGabinete) {
        this.id_SeguridadGabinete = id_SeguridadGabinete;
    }

    public int getId_Historial() {
        return id_Historial;
    }

    public void setId_Historial(int id_Historial) {
        this.id_Historial = id_Historial;
    }

    public int getId_ComponentesInternos() {
        return id_ComponentesInternos;
    }

    public void setId_ComponentesInternos(int id_ComponentesInternos) {
        this.id_ComponentesInternos = id_ComponentesInternos;
    }
    
    
    
    
    
    
    
}
