package com.baalam.model.histclinica.ep;

import com.baalam.model.histclinica.pa.PadecimientoActual;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EPEgo.class)
public abstract class EPEgo_ {

	public static volatile SingularAttribute<EPEgo, String> resultadoEgo;
	public static volatile SingularAttribute<EPEgo, PadecimientoActual> padecimientoActual;
	public static volatile SingularAttribute<EPEgo, Double> sedimentoBacterias;
	public static volatile SingularAttribute<EPEgo, Double> sedimentoLeucocitos;
	public static volatile SingularAttribute<EPEgo, String> aspecto;
	public static volatile SingularAttribute<EPEgo, Double> proteinas;
	public static volatile SingularAttribute<EPEgo, Double> sedimentoPiocitos;
	public static volatile SingularAttribute<EPEgo, Double> sedimentoEritrocitos;
	public static volatile SingularAttribute<EPEgo, Double> nitritos;
	public static volatile SingularAttribute<EPEgo, Double> cuerposCetonicos;
	public static volatile SingularAttribute<EPEgo, Double> hemoglobina;
	public static volatile SingularAttribute<EPEgo, String> ph;
	public static volatile SingularAttribute<EPEgo, Date> fechaEgo;

}

