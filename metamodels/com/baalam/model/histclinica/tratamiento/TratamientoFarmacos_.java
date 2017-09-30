package com.baalam.model.histclinica.tratamiento;

import com.baalam.model.histclinica.pa.PadecimientoActual;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TratamientoFarmacos.class)
public abstract class TratamientoFarmacos_ {

	public static volatile SingularAttribute<TratamientoFarmacos, PadecimientoActual> padecimientoActual;
	public static volatile SingularAttribute<TratamientoFarmacos, String> medicamento;
	public static volatile SingularAttribute<TratamientoFarmacos, Long> idTratamientoFarmaco;
	public static volatile SingularAttribute<TratamientoFarmacos, String> viaAdmon;
	public static volatile SingularAttribute<TratamientoFarmacos, String> frecuencia;
	public static volatile SingularAttribute<TratamientoFarmacos, String> duracion;
	public static volatile SingularAttribute<TratamientoFarmacos, String> dosis;

}

