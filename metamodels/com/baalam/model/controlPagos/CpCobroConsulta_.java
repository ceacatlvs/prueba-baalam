package com.baalam.model.controlPagos;

import com.baalam.model.histclinica.pa.PadecimientoActual;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CpCobroConsulta.class)
public abstract class CpCobroConsulta_ {

	public static volatile SetAttribute<CpCobroConsulta, CpPagos> cpPagos;
	public static volatile SingularAttribute<CpCobroConsulta, Boolean> recibo;
	public static volatile SingularAttribute<CpCobroConsulta, PadecimientoActual> padecimientoActual;
	public static volatile SingularAttribute<CpCobroConsulta, String> descripcion;
	public static volatile SingularAttribute<CpCobroConsulta, Double> monto;
	public static volatile SingularAttribute<CpCobroConsulta, Long> idCobroConsulta;

}

