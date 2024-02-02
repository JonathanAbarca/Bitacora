package com.mycompany.bitacora.logica;

import com.mycompany.bitacora.logica.ComponentesOP;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-02-01T21:43:35", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(PuntoVaciado.class)
public class PuntoVaciado_ { 

    public static volatile SingularAttribute<PuntoVaciado, Integer> id_PuntoVaciado;
    public static volatile SingularAttribute<PuntoVaciado, String> numPunto;
    public static volatile SingularAttribute<PuntoVaciado, String> numCalle;
    public static volatile SingularAttribute<PuntoVaciado, ComponentesOP> id_Componente;

}