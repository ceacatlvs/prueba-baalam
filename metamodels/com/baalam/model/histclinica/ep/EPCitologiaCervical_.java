package com.baalam.model.histclinica.ep;

import com.baalam.model.histclinica.pa.PadecimientoActual;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EPCitologiaCervical.class)
public abstract class EPCitologiaCervical_ {

	public static volatile SingularAttribute<EPCitologiaCervical, PadecimientoActual> padecimientoActual;
	public static volatile SingularAttribute<EPCitologiaCervical, String> resultadoCitologia;
	public static volatile SingularAttribute<EPCitologiaCervical, String> observaciones;
	public static volatile SingularAttribute<EPCitologiaCervical, Date> fechaCitologia;

}

