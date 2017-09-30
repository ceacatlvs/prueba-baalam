package com.baalam.model.histclinica.ef;

import com.baalam.model.histclinica.pa.PadecimientoActual;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EFPiel.class)
public abstract class EFPiel_ {

	public static volatile SingularAttribute<EFPiel, PadecimientoActual> padecimientoActual;
	public static volatile SingularAttribute<EFPiel, String> palpacion;
	public static volatile SingularAttribute<EFPiel, String> inspeccion;
	public static volatile SingularAttribute<EFPiel, String> observaciones;

}

