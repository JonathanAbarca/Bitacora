
package com.mycompany.bitacora.logica;

import com.mycompany.bitacora.persistencia.ControladorPersistencia;

/**
 *
 * @author Jonathan Abarca
 */
public class Controladora {
    ControladorPersistencia miControlPersis = new ControladorPersistencia();
    

    public Controladora() {
    }
    
    public void nuevoPuntoVaciado(String numCalle, String numPuntoVaciado,
            String foco, String alim220, String aldabaCL, String candadoCL, String chapaCL, String enchufe60CL, String enchufe30CL, String enchufe35CL,
            String aldabaSG, String candadoSG, String chapaSG, String safetySG, String alimGen600vSG,
            String turno, String grupo, String descrip,
            String cbPrincipalCI, String releDifCBPrinCI, String cbVentiladorCI, String contactorVentiCI, String olVentiladorCI, String cbBombaHCI,
            String contactorBombHCI, String olBombaHCI,String cbTrafo600CI, String trafo600CI, String trafo220CI,
            String cbEnchufeHemCI, String enchufeHem30CI) {
        //Creamos una instalcia de componentes
        ComponentesOP miComponentesOP = new ComponentesOP();
        
        //Creamos Punto vaciado
        PuntoVaciado miPuntoVaciado = new PuntoVaciado();
        miPuntoVaciado.setNumCalle(numCalle);
        miPuntoVaciado.setNumPunto(numPuntoVaciado);
        miPuntoVaciado.setId_Componente(miComponentesOP);
        //Creamos Alumbrado
        Alumbrado miAlumbrado = new Alumbrado();
        miAlumbrado.setFoco(foco);
        miAlumbrado.setAlimen(alim220);
        miAlumbrado.setId_Componentes(miComponentesOP);
        //Creamos Caja local
        CajaLocal miCajaLocal = new CajaLocal();
        miCajaLocal.setAldaba(aldabaCL);
        miCajaLocal.setCandado(candadoCL);
        miCajaLocal.setChapa(chapaCL);
        miCajaLocal.setEnchufe60(enchufe60CL);
        miCajaLocal.setEnchufe30(enchufe30CL);
        miCajaLocal.setEnchufe35(enchufe35CL);
        miCajaLocal.setId_Componentes(miComponentesOP);
        //Creamos Seguridad gabinete
        SeguridadGabinete miSeguridadGabinete = new SeguridadGabinete();
        miSeguridadGabinete.setAldaba(aldabaSG);
        miSeguridadGabinete.setCandado(candadoSG);
        miSeguridadGabinete.setChapa(chapaSG);
        miSeguridadGabinete.setSafety(safetySG);
        miSeguridadGabinete.setAlimGeneral(alimGen600vSG);
        miSeguridadGabinete.setId_Componentes(miComponentesOP);
        //Creamos Historial
        Historial miHistorial = new Historial();
        miHistorial.setTurno(turno);
        miHistorial.setGrupo(grupo);
        miHistorial.setDescrip(descrip);
        miHistorial.setId_Componentes(miComponentesOP);
        //Creamos los Componentes internos
        ComponentesInternos miComponentesInternos = new ComponentesInternos();
        miComponentesInternos.setCbPrincipal(cbPrincipalCI);
        miComponentesInternos.setReleDiferencial(releDifCBPrinCI);
        miComponentesInternos.setCbVentilador(cbVentiladorCI);
        miComponentesInternos.setContactorVentilador(contactorVentiCI);
        miComponentesInternos.setOlVentilador(olVentiladorCI);
        miComponentesInternos.setCbBombaH(cbBombaHCI);
        miComponentesInternos.setContactorBombaH(contactorBombHCI);
        miComponentesInternos.setOlBombaH(olBombaHCI);
        miComponentesInternos.setCbTrafo600(cbTrafo600CI);
        miComponentesInternos.setTrafo600(trafo600CI);
        miComponentesInternos.setTrafo220(trafo220CI);
        miComponentesInternos.setCbEnchufe(cbEnchufeHemCI);
        miComponentesInternos.setEnchufeHem30(enchufeHem30CI);
        miComponentesInternos.setId_Componente(miComponentesOP);
        //creamos la tabla de Compronentes
                
        //Llamado a controlpersis para guardar los datos
        miControlPersis.guardarOP(miComponentesOP,miPuntoVaciado,miAlumbrado,miCajaLocal,miSeguridadGabinete,miHistorial,miComponentesInternos);
    }
    
}
