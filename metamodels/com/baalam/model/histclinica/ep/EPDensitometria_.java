package com.baalam.model.histclinica.ep;

import com.baalam.model.histclinica.pa.PadecimientoActual;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EPDensitometria.class)
public abstract class EPDensitometria_ {

	public static volatile SingularAttribute<EPDensitometria, String> tipoDensitometria;
	public static volatile SingularAttribute<EPDensitometria, PadecimientoActual> padecimientoActual;
	public static volatile SingularAttribute<EPDensitometria, Date> fechaDensitometria;
	public static volatile SingularAttribute<EPDensitometria, String> otroSitio;
	public static volatile SingularAttribute<EPDensitometria, String> otroSitioClas;
	public static volatile SingularAttribute<EPDensitometria, String> cadera;
	public static volatile SingularAttribute<EPDensitometria, String> observacones;
	public static volatile SingularAttribute<EPDensitometria, String> columna;

}

