package com.baalam.model.histclinica;

import com.baalam.model.histclinica.pa.PadecimientoActual;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EvolucionCuadroClinico.class)
public abstract class EvolucionCuadroClinico_ {

	public static volatile SingularAttribute<EvolucionCuadroClinico, PadecimientoActual> padecimientoActual;
	public static volatile SingularAttribute<EvolucionCuadroClinico, String> notasIndicaciones;
	public static volatile SingularAttribute<EvolucionCuadroClinico, String> notas;
	public static volatile SingularAttribute<EvolucionCuadroClinico, Boolean> siguiIndicaciones;
	public static volatile SingularAttribute<EvolucionCuadroClinico, Boolean> ingestaAlcohol;
	public static volatile SingularAttribute<EvolucionCuadroClinico, Boolean> noModificacion;
	public static volatile SingularAttribute<EvolucionCuadroClinico, Boolean> ingestaTabaco;
	public static volatile SingularAttribute<EvolucionCuadroClinico, Boolean> empeoramiento;
	public static volatile SingularAttribute<EvolucionCuadroClinico, Boolean> curacion;
	public static volatile SingularAttribute<EvolucionCuadroClinico, Boolean> otrosAgregados;
	public static volatile SingularAttribute<EvolucionCuadroClinico, Boolean> otrasAdicciones;
	public static volatile SingularAttribute<EvolucionCuadroClinico, Boolean> mejoria;

}

