package com.baalam.model.controlEmbarazo;

import com.baalam.model.histclinica.pa.PadecimientoActual;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ControlEmbarazo.class)
public abstract class ControlEmbarazo_ {

	public static volatile SingularAttribute<ControlEmbarazo, Long> idControlEmbarazo;
	public static volatile SingularAttribute<ControlEmbarazo, Date> fpp;
	public static volatile SingularAttribute<ControlEmbarazo, String> embarazo;
	public static volatile SingularAttribute<ControlEmbarazo, String> gesta;
	public static volatile SingularAttribute<ControlEmbarazo, Date> fum;
	public static volatile SingularAttribute<ControlEmbarazo, String> gs;
	public static volatile SingularAttribute<ControlEmbarazo, PadecimientoActual> consulta;
	public static volatile SingularAttribute<ControlEmbarazo, String> ab;
	public static volatile SingularAttribute<ControlEmbarazo, String> factorRiesgo;
	public static volatile SingularAttribute<ControlEmbarazo, String> ces;
	public static volatile SingularAttribute<ControlEmbarazo, String> para;

}

