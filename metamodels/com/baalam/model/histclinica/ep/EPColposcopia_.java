package com.baalam.model.histclinica.ep;

import com.baalam.model.histclinica.pa.PadecimientoActual;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EPColposcopia.class)
public abstract class EPColposcopia_ {

	public static volatile SingularAttribute<EPColposcopia, Date> fechaColposcopia;
	public static volatile SingularAttribute<EPColposcopia, PadecimientoActual> padecimientoActual;
	public static volatile SingularAttribute<EPColposcopia, String> resultadoColposcopia;
	public static volatile SingularAttribute<EPColposcopia, String> observaciones;

}

