
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
public class CajaLocal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_CajaLocal;
    @Basic
    private String aldaba;
    private String candado;
    private String chapa;
    private String enchufe60;
    private String enchufe30;
    private String enchufe35;
    @OneToOne
    ComponentesOP id_Componentes;

    public CajaLocal() {
    }

    public CajaLocal(int id_CajaLocal, String aldaba, String candado, String chapa, String enchufe60, String enchufe30, String enchufe35, ComponentesOP id_Componentes) {
        this.id_CajaLocal = id_CajaLocal;
        this.aldaba = aldaba;
        this.candado = candado;
        this.chapa = chapa;
        this.enchufe60 = enchufe60;
        this.enchufe30 = enchufe30;
        this.enchufe35 = enchufe35;
        this.id_Componentes = id_Componentes;
    }

    public int getId_CajaLocal() {
        return id_CajaLocal;
    }

    public void setId_CajaLocal(int id_CajaLocal) {
        this.id_CajaLocal = id_CajaLocal;
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

    public String getEnchufe60() {
        return enchufe60;
    }

    public void setEnchufe60(String enchufe60) {
        this.enchufe60 = enchufe60;
    }

    public String getEnchufe30() {
        return enchufe30;
    }

    public void setEnchufe30(String enchufe30) {
        this.enchufe30 = enchufe30;
    }

    public String getEnchufe35() {
        return enchufe35;
    }

    public void setEnchufe35(String enchufe35) {
        this.enchufe35 = enchufe35;
    }

    public ComponentesOP getId_Componentes() {
        return id_Componentes;
    }

    public void setId_Componentes(ComponentesOP id_Componentes) {
        this.id_Componentes = id_Componentes;
    }

    
    
}
