package com.baalam.model.histclinica.iays;

import com.baalam.model.usuario.Paciente;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(IAySNeurologico.class)
public abstract class IAySNeurologico_ {

	public static volatile SingularAttribute<IAySNeurologico, Boolean> problemasSevMemoria;
	public static volatile SingularAttribute<IAySNeurologico, Paciente> paciente;
	public static volatile SingularAttribute<IAySNeurologico, Boolean> negativo;
	public static volatile SingularAttribute<IAySNeurologico, String> otro;
	public static volatile SingularAttribute<IAySNeurologico, Boolean> parestesias;
	public static volatile SingularAttribute<IAySNeurologico, Boolean> convulsiones;
	public static volatile SingularAttribute<IAySNeurologico, String> observaciones;
	public static volatile SingularAttribute<IAySNeurologico, Boolean> transtornosMarcha;
	public static volatile SingularAttribute<IAySNeurologico, Boolean> sincope;

}

