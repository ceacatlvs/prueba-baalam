package com.baalam.model.histclinica.ant.go;

import com.baalam.model.usuario.Paciente;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AGOObstetrica.class)
public abstract class AGOObstetrica_ {

	public static volatile SingularAttribute<AGOObstetrica, Paciente> paciente;
	public static volatile SingularAttribute<AGOObstetrica, Integer> obitos;
	public static volatile SingularAttribute<AGOObstetrica, Integer> vivosActuales;
	public static volatile SingularAttribute<AGOObstetrica, Integer> embarazos;
	public static volatile SingularAttribute<AGOObstetrica, Integer> prematuros;
	public static volatile SingularAttribute<AGOObstetrica, String> observaciones;
	public static volatile SingularAttribute<AGOObstetrica, Integer> nacidosVivos;
	public static volatile SingularAttribute<AGOObstetrica, Integer> abortos;

}

