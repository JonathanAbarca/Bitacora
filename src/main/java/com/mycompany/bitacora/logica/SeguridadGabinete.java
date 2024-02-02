
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
public class SeguridadGabinete implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_SeguridadGabinete;
    @Basic
    private String aldaba;
    private String candado;
    private String chapa;
    private String safety;
    private String alimGeneral;
    @OneToOne
    ComponentesOP id_Componentes;

    public SeguridadGabinete() {
    }

    public SeguridadGabinete(int id_SeguridadGabinete, String aldaba, String candado, String chapa, String safety, String alimGeneral, ComponentesOP id_Componentes) {
        this.id_SeguridadGabinete = id_SeguridadGabinete;
        this.aldaba = aldaba;
        this.candado = candado;
        this.chapa = chapa;
        this.safety = safety;
        this.alimGeneral = alimGeneral;
        this.id_Componentes = id_Componentes;
    }

    public int getId_SeguridadGabinete() {
        return id_SeguridadGabinete;
    }

    public void setId_SeguridadGabinete(int id_SeguridadGabinete) {
        this.id_SeguridadGabinete = id_SeguridadGabinete;
    }

    public String getAldaba() {
        return aldaba;
    }

    public void setAldaba(String aldaba) {
        this.aldaba = aldaba;
    }

    public String getCandado() {
        return candado;
    }

    public void setCandado(String candado) {
        this.candado = candado;
    }

    public String getChapa() {
        return chapa;
    }

    public void setChapa(String chapa) {
        this.chapa = chapa;
    }

    public String getSafety() {
        return safety;
    }

    public void setSafety(String safety) {
        this.safety = safety;
    }

    public String getAlimGeneral() {
        return alimGeneral;
    }

    public void setAlimGeneral(String alimGeneral) {
        this.alimGeneral = alimGeneral;
    }

    public ComponentesOP getId_Componentes() {
        return id_Componentes;
    }

    public void setId_Componentes(ComponentesOP id_Componentes) {
        this.id_Componentes = id_Componentes;
    }
    
}
