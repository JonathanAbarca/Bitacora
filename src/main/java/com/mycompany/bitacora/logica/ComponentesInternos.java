
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
public class ComponentesInternos implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_ComponentesInternos;
    @Basic
    private String cbPrincipal;
    private String releDiferencial;
    private String cbVentilador;
    private String contactorVentilador;
    private String olVentilador;
    private String cbBombaH;
    private String contactorBombaH;
    private String olBombaH;
    private String cbTrafo600;
    private String trafo600;
    private String trafo220;
    private String cbEnchufe;
    private String enchufeHem30;
    @OneToOne
    ComponentesOP id_Componente;

    public ComponentesInternos() {
    }

    public ComponentesInternos(int id_ComponentesInternos, String cbPrincipal, String releDiferencial, String cbVentilador, String contactorVentilador, String olVentilador, String cbBombaH, String contactorBombaH, String olBombaH, String cbTrafo600, String trafo600, String trafo220, String cbEnchufe, String enchufeHem30, ComponentesOP id_Componente) {
        this.id_ComponentesInternos = id_ComponentesInternos;
        this.cbPrincipal = cbPrincipal;
        this.releDiferencial = releDiferencial;
        this.cbVentilador = cbVentilador;
        this.contactorVentilador = contactorVentilador;
        this.olVentilador = olVentilador;
        this.cbBombaH = cbBombaH;
        this.contactorBombaH = contactorBombaH;
        this.olBombaH = olBombaH;
        this.cbTrafo600 = cbTrafo600;
        this.trafo600 = trafo600;
        this.trafo220 = trafo220;
        this.cbEnchufe = cbEnchufe;
        this.enchufeHem30 = enchufeHem30;
        this.id_Componente = id_Componente;
    }

    public int getId_ComponentesInternos() {
        return id_ComponentesInternos;
    }

    public void setId_ComponentesInternos(int id_ComponentesInternos) {
        this.id_ComponentesInternos = id_ComponentesInternos;
    }

    public String getCbPrincipal() {
        return cbPrincipal;
    }

    public void setCbPrincipal(String cbPrincipal) {
        this.cbPrincipal = cbPrincipal;
    }

    public String getReleDiferencial() {
        return releDiferencial;
    }

    public void setReleDiferencial(String releDiferencial) {
        this.releDiferencial = releDiferencial;
    }

    public String getCbVentilador() {
        return cbVentilador;
    }

    public void setCbVentilador(String cbVentilador) {
        this.cbVentilador = cbVentilador;
    }

    public String getContactorVentilador() {
        return contactorVentilador;
    }

    public void setContactorVentilador(String contactorVentilador) {
        this.contactorVentilador = contactorVentilador;
    }

    public String getOlVentilador() {
        return olVentilador;
    }

    public void setOlVentilador(String olVentilador) {
        this.olVentilador = olVentilador;
    }

    public String getCbBombaH() {
        return cbBombaH;
    }

    public void setCbBombaH(String cbBombaH) {
        this.cbBombaH = cbBombaH;
    }

    public String getContactorBombaH() {
        return contactorBombaH;
    }

    public void setContactorBombaH(String contactorBombaH) {
        this.contactorBombaH = contactorBombaH;
    }

    public String getOlBombaH() {
        return olBombaH;
    }

    public void setOlBombaH(String olBombaH) {
        this.olBombaH = olBombaH;
    }

    public String getCbTrafo600() {
        return cbTrafo600;
    }

    public void setCbTrafo600(String cbTrafo600) {
        this.cbTrafo600 = cbTrafo600;
    }

    public String getTrafo600() {
        return trafo600;
    }

    public void setTrafo600(String trafo600) {
        this.trafo600 = trafo600;
    }

    public String getTrafo220() {
        return trafo220;
    }

    public void setTrafo220(String trafo220) {
        this.trafo220 = trafo220;
    }

    public String getCbEnchufe() {
        return cbEnchufe;
    }

    public void setCbEnchufe(String cbEnchufe) {
        this.cbEnchufe = cbEnchufe;
    }

    public String getEnchufeHem30() {
        return enchufeHem30;
    }

    public void setEnchufeHem30(String enchufeHem30) {
        this.enchufeHem30 = enchufeHem30;
    }

    public ComponentesOP getId_Componente() {
        return id_Componente;
    }

    public void setId_Componente(ComponentesOP id_Componente) {
        this.id_Componente = id_Componente;
    }
    
}
