package com.baalam.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Campo.class)
public abstract class Campo_ {

	public static volatile SingularAttribute<Campo, String> nombre;
	public static volatile SingularAttribute<Campo, String> tipo;
	public static volatile SingularAttribute<Campo, Long> idCampo;
	public static volatile SingularAttribute<Campo, Boolean> requerido;
	public static volatile SingularAttribute<Campo, Tabla> tabla;

}

