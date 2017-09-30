package com.baalam.model.histclinica.ep;

import com.baalam.model.histclinica.pa.PadecimientoActual;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EPVdrlHiv.class)
public abstract class EPVdrlHiv_ {

	public static volatile SingularAttribute<EPVdrlHiv, Date> fechaVdrl;
	public static volatile SingularAttribute<EPVdrlHiv, PadecimientoActual> padecimientoActual;
	public static volatile SingularAttribute<EPVdrlHiv, String> resultadoVdrl;
	public static volatile SingularAttribute<EPVdrlHiv, String> resultadoHIV;
	public static volatile SingularAttribute<EPVdrlHiv, Date> fechaHIV;

}

