package com.baalam.model.histclinica.ef;

import com.baalam.model.histclinica.pa.PadecimientoActual;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EFLinfatico.class)
public abstract class EFLinfatico_ {

	public static volatile SingularAttribute<EFLinfatico, String> gangliosCuello;
	public static volatile SingularAttribute<EFLinfatico, PadecimientoActual> padecimientoActual;
	public static volatile SingularAttribute<EFLinfatico, String> gangliosInguinales;
	public static volatile SingularAttribute<EFLinfatico, String> observaciones;
	public static volatile SingularAttribute<EFLinfatico, String> otrosGanglios;
	public static volatile SingularAttribute<EFLinfatico, String> gangliosAxila;

}

