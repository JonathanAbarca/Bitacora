package com.mycompany.bitacora.logica;

import com.mycompany.bitacora.logica.ComponentesOP;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-02-03T11:41:47", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Alumbrado.class)
public class Alumbrado_ { 

    public static volatile SingularAttribute<Alumbrado, Integer> id_alumbrado;
    public static volatile SingularAttribute<Alumbrado, String> alimen;
    public static volatile SingularAttribute<Alumbrado, String> foco;
    public static volatile SingularAttribute<Alumbrado, ComponentesOP> id_Componentes;

}