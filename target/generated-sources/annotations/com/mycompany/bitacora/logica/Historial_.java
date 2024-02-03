package com.mycompany.bitacora.logica;

import com.mycompany.bitacora.logica.ComponentesOP;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-02-03T11:41:47", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Historial.class)
public class Historial_ { 

    public static volatile SingularAttribute<Historial, String> descrip;
    public static volatile SingularAttribute<Historial, Integer> id_Historial;
    public static volatile SingularAttribute<Historial, String> grupo;
    public static volatile SingularAttribute<Historial, String> turno;
    public static volatile SingularAttribute<Historial, ComponentesOP> id_Componentes;

}