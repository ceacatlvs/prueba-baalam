package com.baalam.model.histclinica.ep;

import com.baalam.model.histclinica.pa.PadecimientoActual;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EPMamas.class)
public abstract class EPMamas_ {

	public static volatile SingularAttribute<EPMamas, PadecimientoActual> padecimientoActual;
	public static volatile SingularAttribute<EPMamas, String> usgMamasBirads;
	public static volatile SingularAttribute<EPMamas, String> mamoBirads;
	public static volatile SingularAttribute<EPMamas, Date> fechaUsgMama;
	public static volatile SingularAttribute<EPMamas, String> observaciones;
	public static volatile SingularAttribute<EPMamas, Date> fechaMamografia;

}

