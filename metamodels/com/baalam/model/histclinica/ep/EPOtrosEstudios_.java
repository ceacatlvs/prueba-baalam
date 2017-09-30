package com.baalam.model.histclinica.ep;

import com.baalam.model.histclinica.pa.PadecimientoActual;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EPOtrosEstudios.class)
public abstract class EPOtrosEstudios_ {

	public static volatile SingularAttribute<EPOtrosEstudios, PadecimientoActual> padecimientoActual;
	public static volatile SingularAttribute<EPOtrosEstudios, String> observaciones;
	public static volatile SingularAttribute<EPOtrosEstudios, Date> fechaOtrosEstudios;

}

