package com.baalam.model.histclinica.ef;

import com.baalam.model.histclinica.pa.PadecimientoActual;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EFRespiratorio.class)
public abstract class EFRespiratorio_ {

	public static volatile SingularAttribute<EFRespiratorio, PadecimientoActual> padecimientoActual;
	public static volatile SingularAttribute<EFRespiratorio, String> esfuerzoResp;
	public static volatile SingularAttribute<EFRespiratorio, String> observaciones;
	public static volatile SingularAttribute<EFRespiratorio, String> camposPulmo;

}

