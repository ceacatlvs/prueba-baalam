package com.baalam.model.histclinica.ep;

import com.baalam.model.histclinica.pa.PadecimientoActual;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EPBiometriaHematica.class)
public abstract class EPBiometriaHematica_ {

	public static volatile SingularAttribute<EPBiometriaHematica, PadecimientoActual> padecimientoActual;
	public static volatile SingularAttribute<EPBiometriaHematica, Double> leucocitos;
	public static volatile SingularAttribute<EPBiometriaHematica, String> otro;
	public static volatile SingularAttribute<EPBiometriaHematica, Date> fechaBH;
	public static volatile SingularAttribute<EPBiometriaHematica, String> resultadoBH;
	public static volatile SingularAttribute<EPBiometriaHematica, Double> hemoglobina;
	public static volatile SingularAttribute<EPBiometriaHematica, Double> hematocrito;
	public static volatile SingularAttribute<EPBiometriaHematica, Double> plaquetas;
	public static volatile SingularAttribute<EPBiometriaHematica, Double> linfocitos;

}

