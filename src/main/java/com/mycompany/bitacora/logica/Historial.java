
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
public class Historial implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_Historial;
    @Basic
    private String turno;
    private String grupo;
    private String descrip;
    @OneToOne
    ComponentesOP id_Componentes;

    public Historial() {
    }

    public Historial(int id_Historial, String turno, String grupo,String descrip, ComponentesOP id_Componentes) {
        this.id_Historial = id_Historial;
        this.turno = turno;
        this.grupo = grupo;
        this.descrip= descrip;
        this.id_Componentes = id_Componentes;
    }

    public int getId_Historial() {
        return id_Historial;
    }

    public void setId_Historial(int id_Historial) {
        this.id_Historial = id_Historial;
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
    

    public ComponentesOP getId_Componentes() {
        return id_Componentes;
    }

    public void setId_Componentes(ComponentesOP id_Componentes) {
        this.id_Componentes = id_Componentes;
    }
    
}
