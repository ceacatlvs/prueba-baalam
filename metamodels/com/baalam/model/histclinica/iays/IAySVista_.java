package com.baalam.model.histclinica.iays;

import com.baalam.model.usuario.Paciente;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(IAySVista.class)
public abstract class IAySVista_ {

	public static volatile SingularAttribute<IAySVista, Boolean> lentes;
	public static volatile SingularAttribute<IAySVista, Boolean> fosfenos;
	public static volatile SingularAttribute<IAySVista, Paciente> paciente;
	public static volatile SingularAttribute<IAySVista, Boolean> negativo;
	public static volatile SingularAttribute<IAySVista, String> otro;
	public static volatile SingularAttribute<IAySVista, Boolean> cambiosVision;
	public static volatile SingularAttribute<IAySVista, String> observaciones;

}

