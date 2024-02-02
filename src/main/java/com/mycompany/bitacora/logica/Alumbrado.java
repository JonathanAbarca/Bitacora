
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
public class Alumbrado implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   private int id_alumbrado;
   @Basic
   private String foco;
   private String alimen;
   @OneToOne
   ComponentesOP id_Componentes;

    public Alumbrado() {
    }

    public Alumbrado(int id_alumbrado, String foco, String alimen, ComponentesOP id_Componentes) {
        this.id_alumbrado = id_alumbrado;
        this.foco = foco;
        this.alimen = alimen;
        this.id_Componentes = id_Componentes;
    }

    public int getId_alumbrado() {
        return id_alumbrado;
    }

    public void setId_alumbrado(int id_alumbrado) {
        this.id_alumbrado = id_alumbrado;
    }

    public String getFoco() {
        return foco;
    }

    public void setFoco(String foco) {
        this.foco = foco;
    }

    public String getAlimen() {
        return alimen;
    }

    public void setAlimen(String alimen) {
        this.alimen = alimen;
    }

    public ComponentesOP getId_Componentes() {
        return id_Componentes;
    }

    public void setId_Componentes(ComponentesOP id_Componentes) {
        this.id_Componentes = id_Componentes;
    }
   
    
   
}
