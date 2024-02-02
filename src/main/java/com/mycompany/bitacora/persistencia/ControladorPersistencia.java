
package com.mycompany.bitacora.persistencia;

import com.mycompany.bitacora.logica.Alumbrado;
import com.mycompany.bitacora.logica.CajaLocal;
import com.mycompany.bitacora.logica.ComponentesInternos;
import com.mycompany.bitacora.logica.ComponentesOP;
import com.mycompany.bitacora.logica.Historial;
import com.mycompany.bitacora.logica.PuntoVaciado;
import com.mycompany.bitacora.logica.SeguridadGabinete;

/**
 *
 * @author Jonathan Abarca
 */
public class ControladorPersistencia {
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
        miComInter.create(miComponentesInternos);
        
    }
    
}
