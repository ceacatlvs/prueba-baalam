package com.baalam.model.controlPagos;

import com.baalam.model.catalogo.CatTipoPago;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CpPagos.class)
public abstract class CpPagos_ {

	public static volatile SingularAttribute<CpPagos, CatTipoPago> tipoPago;
	public static volatile SingularAttribute<CpPagos, Long> idPago;
	public static volatile SingularAttribute<CpPagos, Date> fechaPago;
	public static volatile SingularAttribute<CpPagos, CpCobroConsulta> idCobroConsulta;
	public static volatile SingularAttribute<CpPagos, Double> cantidadPagada;

}

