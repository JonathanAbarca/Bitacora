
package com.mycompany.bitacora.persistencia;

import com.mycompany.bitacora.logica.Alumbrado;
import com.mycompany.bitacora.logica.CajaLocal;
import com.mycompany.bitacora.logica.ComponentesInternos;
import com.mycompany.bitacora.logica.ComponentesOP;
import com.mycompany.bitacora.logica.Historial;
import com.mycompany.bitacora.logica.PuntoVaciado;
import com.mycompany.bitacora.logica.Reparaciones;
import com.mycompany.bitacora.logica.SeguridadGabinete;
import com.mycompany.bitacora.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;





/**
 *
 * @author Jonathan Abarca
 */
public class ControladorPersistencia {
    ReparacionesJpaController miReparaciones = new ReparacionesJpaController();
    ComponentesOPJpaController miComprOP = new ComponentesOPJpaController();
    PuntoVaciadoJpaController miPuntoV = new PuntoVaciadoJpaController();
    AlumbradoJpaController miAlum = new AlumbradoJpaController();
    CajaLocalJpaController miCajaLo = new CajaLocalJpaController();
    SeguridadGabineteJpaController miSeguriGab = new SeguridadGabineteJpaController();
    HistorialJpaController miHisto = new HistorialJpaController();
    ComponentesInternosJpaController miComInter = new ComponentesInternosJpaController();
    
    
    public void guardarOP(ComponentesOP miComponentesOP, PuntoVaciado miPuntoVaciado, Alumbrado miAlumbrado, CajaLocal miCajaLocal, SeguridadGabinete miSeguridadGabinete, Historial miHistorial, ComponentesInternos miComponentesInternos) {
        miComprOP.create(miComponentesOP);
        miPuntoV.create(miPuntoVaciado);
        miAlum.create(miAlumbrado);
        miCajaLo.create(miCajaLocal);
        miSeguriGab.create(miSeguridadGabinete);
        miHisto.create(miHistorial);
        miComInter.create(miComponentesInternos);
        
        
    }

    public List<Reparaciones> cargarTabla() {
        
        return miReparaciones.findReparacionesEntities();
    }

    public void borrarRepara(int id_repa) {
        
        try {
            miReparaciones.destroy(id_repa);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public Reparaciones modRepas(int num_repa) {
        
        return miReparaciones.findReparaciones(num_repa);
        
    }

    public void modificaRepas(Reparaciones miRepara) {
        try {
            miReparaciones.edit(miRepara);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
