package com.baalam.model.histclinica.ads;

import com.baalam.model.histclinica.pa.PadecimientoActual;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ADSGabinete.class)
public abstract class ADSGabinete_ {

	public static volatile SingularAttribute<ADSGabinete, Boolean> ultrasonogramaPelvico;
	public static volatile SingularAttribute<ADSGabinete, Boolean> ultrasonogramaMama;
	public static volatile SingularAttribute<ADSGabinete, PadecimientoActual> padecimientoActual;
	public static volatile SingularAttribute<ADSGabinete, Boolean> urogramaExcetor;
	public static volatile SingularAttribute<ADSGabinete, Boolean> mamografia;
	public static volatile SingularAttribute<ADSGabinete, Boolean> histerosonografia;
	public static volatile SingularAttribute<ADSGabinete, Boolean> densitometria;
	public static volatile SingularAttribute<ADSGabinete, String> ultrasonogramaOtro;
	public static volatile SingularAttribute<ADSGabinete, Boolean> histeosalpingografia;
	public static volatile SingularAttribute<ADSGabinete, Boolean> ultrasonogramaTransvaginal;
	public static volatile SingularAttribute<ADSGabinete, String> otrosDescripcion;
	public static volatile SingularAttribute<ADSGabinete, Boolean> ultrasonogramaAbdomen;

}

