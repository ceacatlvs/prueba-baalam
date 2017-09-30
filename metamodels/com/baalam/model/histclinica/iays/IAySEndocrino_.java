package com.baalam.model.histclinica.iays;

import com.baalam.model.usuario.Paciente;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(IAySEndocrino.class)
public abstract class IAySEndocrino_ {

	public static volatile SingularAttribute<IAySEndocrino, Boolean> bochornos;
	public static volatile SingularAttribute<IAySEndocrino, Paciente> paciente;
	public static volatile SingularAttribute<IAySEndocrino, Boolean> negativo;
	public static volatile SingularAttribute<IAySEndocrino, Boolean> intoleranciaCalor;
	public static volatile SingularAttribute<IAySEndocrino, Boolean> hipertiroidea;
	public static volatile SingularAttribute<IAySEndocrino, String> otro;
	public static volatile SingularAttribute<IAySEndocrino, Boolean> hipotiroidea;
	public static volatile SingularAttribute<IAySEndocrino, Boolean> diabetes;
	public static volatile SingularAttribute<IAySEndocrino, Boolean> intoleranciaFrio;
	public static volatile SingularAttribute<IAySEndocrino, String> observaciones;
	public static volatile SingularAttribute<IAySEndocrino, Boolean> caidaCabello;

}

