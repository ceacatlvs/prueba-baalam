package com.baalam.model.histclinica.ep;

import com.baalam.model.histclinica.pa.PadecimientoActual;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EPUrocultivo.class)
public abstract class EPUrocultivo_ {

	public static volatile SingularAttribute<EPUrocultivo, String> resultadoUrocultivo;
	public static volatile SingularAttribute<EPUrocultivo, PadecimientoActual> padecimientoActual;
	public static volatile SingularAttribute<EPUrocultivo, String> antibiograma;
	public static volatile SingularAttribute<EPUrocultivo, Date> fechaUrocultivo;
	public static volatile SingularAttribute<EPUrocultivo, String> bacteria;

}

