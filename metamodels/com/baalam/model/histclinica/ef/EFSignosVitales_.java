package com.baalam.model.histclinica.ef;

import com.baalam.model.histclinica.pa.PadecimientoActual;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EFSignosVitales.class)
public abstract class EFSignosVitales_ {

	public static volatile SingularAttribute<EFSignosVitales, PadecimientoActual> padecimientoActual;
	public static volatile SingularAttribute<EFSignosVitales, Double> pesoKg;
	public static volatile SingularAttribute<EFSignosVitales, Integer> tallaCm;
	public static volatile SingularAttribute<EFSignosVitales, Double> circunfAbdominal;
	public static volatile SingularAttribute<EFSignosVitales, Double> pesoIdealKg;
	public static volatile SingularAttribute<EFSignosVitales, String> observaciones;
	public static volatile SingularAttribute<EFSignosVitales, Double> pesoLb;
	public static volatile SingularAttribute<EFSignosVitales, Double> fc;
	public static volatile SingularAttribute<EFSignosVitales, Double> pesoIdealLb;
	public static volatile SingularAttribute<EFSignosVitales, Date> fechaConsulta;
	public static volatile SingularAttribute<EFSignosVitales, Double> imc;
	public static volatile SingularAttribute<EFSignosVitales, Integer> tallaIn;
	public static volatile SingularAttribute<EFSignosVitales, Double> ta;
	public static volatile SingularAttribute<EFSignosVitales, Double> temp;
	public static volatile SingularAttribute<EFSignosVitales, Integer> tallaPies;
	public static volatile SingularAttribute<EFSignosVitales, Double> fr;
	public static volatile SingularAttribute<EFSignosVitales, Boolean> acudioCita;

}

