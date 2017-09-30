package com.baalam.model.histclinica.tratamiento;

import com.baalam.model.histclinica.pa.PadecimientoActual;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Tratamiento.class)
public abstract class Tratamiento_ {

	public static volatile SingularAttribute<Tratamiento, Date> proximaCita;
	public static volatile SingularAttribute<Tratamiento, PadecimientoActual> padecimientoActual;
	public static volatile SingularAttribute<Tratamiento, Boolean> chActividadNormal;
	public static volatile SingularAttribute<Tratamiento, Boolean> chBano;
	public static volatile SingularAttribute<Tratamiento, Double> minutosEducacionSalud;
	public static volatile SingularAttribute<Tratamiento, Boolean> chReposo;
	public static volatile SingularAttribute<Tratamiento, String> dietaObservaciones;
	public static volatile SingularAttribute<Tratamiento, String> dieta;
	public static volatile SingularAttribute<Tratamiento, String> chOtros;
	public static volatile SingularAttribute<Tratamiento, Boolean> chActividadSexual;
	public static volatile SingularAttribute<Tratamiento, String> observacionesEducacionSalud;
	public static volatile SingularAttribute<Tratamiento, Boolean> chEjercicio;

}

