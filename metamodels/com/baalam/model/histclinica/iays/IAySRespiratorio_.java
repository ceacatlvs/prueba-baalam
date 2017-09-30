package com.baalam.model.histclinica.iays;

import com.baalam.model.usuario.Paciente;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(IAySRespiratorio.class)
public abstract class IAySRespiratorio_ {

	public static volatile SingularAttribute<IAySRespiratorio, Paciente> paciente;
	public static volatile SingularAttribute<IAySRespiratorio, Boolean> negativo;
	public static volatile SingularAttribute<IAySRespiratorio, Boolean> hemoptisis;
	public static volatile SingularAttribute<IAySRespiratorio, Boolean> tos;
	public static volatile SingularAttribute<IAySRespiratorio, Boolean> disnea;
	public static volatile SingularAttribute<IAySRespiratorio, String> otro;
	public static volatile SingularAttribute<IAySRespiratorio, String> observaciones;
	public static volatile SingularAttribute<IAySRespiratorio, Boolean> sibilancias;
	public static volatile SingularAttribute<IAySRespiratorio, Boolean> taquipnea;

}

