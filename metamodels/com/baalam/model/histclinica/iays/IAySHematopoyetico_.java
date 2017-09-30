package com.baalam.model.histclinica.iays;

import com.baalam.model.usuario.Paciente;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(IAySHematopoyetico.class)
public abstract class IAySHematopoyetico_ {

	public static volatile SingularAttribute<IAySHematopoyetico, Boolean> adenopatias;
	public static volatile SingularAttribute<IAySHematopoyetico, Paciente> paciente;
	public static volatile SingularAttribute<IAySHematopoyetico, Boolean> negativo;
	public static volatile SingularAttribute<IAySHematopoyetico, String> otro;
	public static volatile SingularAttribute<IAySHematopoyetico, Boolean> sangrado;
	public static volatile SingularAttribute<IAySHematopoyetico, Boolean> equimosis;
	public static volatile SingularAttribute<IAySHematopoyetico, String> observaciones;

}

