package com.baalam.model.histclinica.iays;

import com.baalam.model.usuario.Paciente;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(IAySMamas.class)
public abstract class IAySMamas_ {

	public static volatile SingularAttribute<IAySMamas, Boolean> secrecionPezon;
	public static volatile SingularAttribute<IAySMamas, Paciente> paciente;
	public static volatile SingularAttribute<IAySMamas, Boolean> negativo;
	public static volatile SingularAttribute<IAySMamas, String> otro;
	public static volatile SingularAttribute<IAySMamas, Boolean> mastalgiaNoCiclica;
	public static volatile SingularAttribute<IAySMamas, Boolean> cambiosPezon;
	public static volatile SingularAttribute<IAySMamas, Boolean> mastalgiaCiclica;
	public static volatile SingularAttribute<IAySMamas, String> observaciones;
	public static volatile SingularAttribute<IAySMamas, Boolean> cambiosPiel;
	public static volatile SingularAttribute<IAySMamas, Boolean> nodulos;

}

